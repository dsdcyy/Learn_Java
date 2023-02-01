import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ljw
 * @version 1.0
 * 演示在JDBC中使用事物
 */
public class Transaction_ {
    // 没有使用事物
    public static void main(String[] args) throws Exception {
        // 1.得到连接
        Connection connection = JDBCUtils.getConnection();
        // 2.组织sql
        String sql = "update account set balance = balance-1000 where id = 2";
        String sql2 = "update account set balance = balance+1000 where id = 1";
        // 3.获取PreparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 5.执行sql
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "执行成功..." : "执行失败...");
        int j = 1 / 0; // 抛出异常
        preparedStatement = connection.prepareStatement(sql2);
        i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "执行成功..." : "执行失败...");

        // 关闭连接
        JDBCUtils.closeConnection(null, preparedStatement, connection);
        System.out.println("关闭连接...");
    }

    // 使用事物
    @Test
    public void useTransaction() {
        // 1.得到连接
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            // 关闭自动提交事物,开启事物
            connection.setAutoCommit(false);
            // 2.组织sql
            String sql = "update account set balance = balance-1000 where id = 2";
            String sql2 = "update account set balance = balance+1000 where id = 1";
            // 3.获取PreparedStatement对象
            preparedStatement = connection.prepareStatement(sql);
            // 5.执行sql
            int i = preparedStatement.executeUpdate();
            System.out.println(i > 0 ? "执行成功1..." : "执行失败...");
//            int j = 1 / 0; // 抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            i = preparedStatement.executeUpdate();
            System.out.println(i > 0 ? "执行成功2..." : "执行失败...");
            // 提交事物
            connection.commit();

        } catch (SQLException e) {
            System.out.println("发生了异常，回滚了执行sql执行...");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            // 关闭连接
            JDBCUtils.closeConnection(null, preparedStatement, connection);
            System.out.println("关闭连接...");
        }
    }
}
