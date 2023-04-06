import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ljw
 * @version 1.0
 */
public class UserJDBCUtils_Druid {
    public static void main(String[] args) {
        Connection connection = JDBCUtils_Druid.getConnection();
        System.out.println("连接成功...");
        JDBCUtils_Druid.closeConnection(null, null, connection);
    }

    @Test
    public void testSelectToArraylist() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ArrayList<Account> accounts = new ArrayList<>();
        String sql = "select * from account where id between 1000 and 1010";
        try {
            // 获取连接
            connection = JDBCUtils_Druid.getConnection();
            // 得到Statement 用于执行静态sql语句并返回其生成结果的对象
            statement = connection.prepareStatement(sql);
            // 查询语言获得结果集executeQuery（sql）ResultSet
            resultSet = statement.executeQuery(sql);
            // 获取结果集 while 循环
            int s = 0;
            while (resultSet.next()) {
                if (s == 0) {
                    // 获取当前列名
                    String columnName = resultSet.getMetaData().getColumnLabel(1);
                    String columnName2 = resultSet.getMetaData().getColumnLabel(2);
                    String columnName3 = resultSet.getMetaData().getColumnLabel(3);
                    System.out.println(columnName + "  " + "  " + columnName2 + "  " + columnName3);
                    s++;
                }

                //             获取当前列类型
                //            int columnType = resultSet.getMetaData().getColumnType(1);
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double balance = resultSet.getDouble(3);
                System.out.println(id + "\t\t" + name + "\t\t" + balance);
                accounts.add(new Account(id, name, balance));
            }
            System.out.println("account数据：" + accounts);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭连接
            JDBCUtils_Druid.closeConnection(resultSet, statement, connection);
            System.out.println("连接已关闭...");
        }
    }
}
