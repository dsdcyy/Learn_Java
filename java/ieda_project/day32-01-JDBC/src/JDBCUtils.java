import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author ljw
 * @version 1.0
 */
public class JDBCUtils {
    private static final String url;
    private static final String driver;
    private static final String user;
    private static final String password;
    // 初始化操作
    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("conf.properties"));
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driver);
            System.out.println("数据库驱动加载成功...");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    // 获取连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // 关闭连接
    public static void closeConnection(ResultSet result, Statement statement, Connection connection) {
        try {
            if (result != null) {
                result.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
