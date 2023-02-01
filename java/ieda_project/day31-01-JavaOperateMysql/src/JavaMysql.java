import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author ljw
 * @version 1.0
 */
public class JavaMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 加载类，得到mysql连接
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("数据库驱动加载成功...");
        // 连接数据库获得Connection
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/javaTest?useUnicode=true&characterEncoding=utf8", "root", "12344321");
        // 准备sql语句
        String sql = "Create table goods\n" +
                "(\n" +
                "    id    int  primary key auto_increment,\n" +
                "    name  varchar(255),\n" +
                "    price decimal(10, 2) default 0.00,\n" +
                "    info  text\n" +
                ");";
        // 通过Connection对象的createStatement()方法获取Statement对象
        Statement statement = connection.createStatement();
        // 使用Statement对象的execute(sql)方法执行sql语句
        statement.execute(sql);
        // 关闭连接
        statement.close();
        connection.close();
        System.out.println("成功...");
    }

}
