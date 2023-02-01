import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ljw
 * @version 1.0
 */
public class UserJDBCUtils {
    public static void main(String[] args) throws SQLException {
        // 1.得到连接
        Connection connection = JDBCUtils.getConnection();
        // 2.组织sql
        String sql = "update students set age = 19 where studentid = ?";
        // 3.获取PreparedStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 4. 给?赋值
        preparedStatement.setInt(1, 8102);
        // 5.执行sql
        int i = preparedStatement.executeUpdate();
        System.out.println(i > 0 ? "执行成功..." : "执行失败...");
        // 关闭连接
        JDBCUtils.closeConnection(null,preparedStatement,connection);
        System.out.println("关闭连接...");
    }
}
