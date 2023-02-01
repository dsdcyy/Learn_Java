import java.sql.*;
import java.util.Scanner;

/**
 * @author ljw
 * @version 1.0
 */
public class PreparedStatement_ {
    public static void main(String[] args) throws Exception {
        // 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmp", "root", "12344321");
        // 执行sql语句
        // ？表示占位符
        String sql = "call add_stu(?,?,?,?)";
        // 得到PreparedStatement 用于执行静态sql语句并返回其生成结果的对象,并防止sql注入
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int[] ids = {8108, 8111, 8112, 8113};
        String[] names = {"张飞", "吕布", "小乔", "西施"};
        int[] ages = {28, 26, 21, 20};
        int[] classids = {121, 101, 131, 241};
        for (int i = 0; i < 4; i++) {
            // 执行前先设置占位符值 1 表示第一个？号
            preparedStatement.setInt(1, ids[i]);
            preparedStatement.setString(2, names[i]);
            preparedStatement.setInt(3, ages[i]);
            preparedStatement.setInt(4, classids[i]);
            // 查询语言获得结果集executeQuery（）ResultSet
            preparedStatement.execute();
        }
        System.out.println("执行成功...");
        // 关闭连接
        preparedStatement.close();
        connection.close();
        System.out.println("连接已关闭...");
    }
}
