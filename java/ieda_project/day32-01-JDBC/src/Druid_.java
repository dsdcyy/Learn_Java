import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author ljw
 * @version 1.0
 */
public class Druid_ {
    @Test
    public void testDruid() throws Exception {
        //1.加入Druid包
        //2.加入配置文件 druid.properties
        // 3.创建Properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileReader("druid.properties"));
        // 4.创建指定参数的数据库连接池 DruidDataSourceFactory.createDataSource(properties)
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取连接
        // 测试连接效率
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
