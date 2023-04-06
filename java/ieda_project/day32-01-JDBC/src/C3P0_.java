import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author ljw
 * @version 1.0
 */
public class C3P0_ {
    // 第一种方法
    public static void main(String[] args) throws Exception {
        // 1.创建数据库源对象
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        // 2.通过配置文件获取相关信息
        Properties properties = new Properties();
        properties.load(new FileReader("conf.properties"));
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        Class.forName(driver);
        System.out.println("数据库驱动加载成功...");

        // 给数据源cpds设置相关参数
        cpds.setDriverClass(driver);
        cpds.setJdbcUrl(url);
        cpds.setUser(user);
        cpds.setPassword(password);
        // 初始化连接数
        cpds.setInitialPoolSize(10);
        // 设置最大连接数
        cpds.setMaxPoolSize(10);
        // 获取连接
        // 测试连接效率
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = cpds.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("连接池连接时间: " + (end - start));
    }

    // 第二种方法 配置文件模板xml
    @Test
    public void C3POTest2() throws Exception {
        ComboPooledDataSource c3p0 = new ComboPooledDataSource();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = c3p0.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
