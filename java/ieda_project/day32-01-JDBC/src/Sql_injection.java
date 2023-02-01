import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author ljw
 * @version 1.0
 */
public class Sql_injection {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmp", "root","12344321");
        // 得到Statement 用于执行静态sql语句并返回其生成结果的对象
        Statement statement = connection.createStatement();
        // 执行sql语句
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名:");
        String user = scanner.nextLine();
        System.out.print("请输入密码:");
        String password = scanner.nextLine();
        String sql = "select * from students where classid = " + user + " and name = " + password;
        // 查询语言获得结果集executeQuery（sql）ResultSet
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println("执行成功...");
        // 获取结果集 while 循环
        int s = 0;
        while (resultSet.next()) {
            if (s == 0) {
                // 获取当前列名
                String columnName = resultSet.getMetaData().getColumnLabel(1);
                String columnName2 = resultSet.getMetaData().getColumnLabel(2);
                String columnName3 = resultSet.getMetaData().getColumnLabel(3);
                String columnName4 = resultSet.getMetaData().getColumnLabel(4);
                System.out.println(columnName + "  " + "  " + columnName2 + "  " + columnName3 + "  " + columnName4);
                s++;
            }

//             获取当前列类型
//            int columnType = resultSet.getMetaData().getColumnType(1);
            int student_id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            int classid = resultSet.getInt(4);
            System.out.println(name + "\t\t" + student_id + "\t\t" + age + "\t\t" + classid);
        }

        // 关闭连接
        statement.close();
        connection.close();
        System.out.println("连接已关闭...");

    }
}
