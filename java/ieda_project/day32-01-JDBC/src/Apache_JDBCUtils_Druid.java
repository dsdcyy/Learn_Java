import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 * 使用apache-DBUtils 工具类 + druid完成对表操作
 */
public class Apache_JDBCUtils_Druid {
    private Connection connection = null;
    private final QueryRunner queryRunner = new QueryRunner();

    @Test
    public void testQueryMany() {
        // 2.引入DBUtils类和接口，先引入相关的jar文件
        // 3.创建QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        // 4.就可以执行相关的方法，返回ArrayList结果集
        String sql = "select * from account where id between ? and ?;";
        // query方法，执行sql语句，将结果通过BeanListHandler封装到ArrayList集合中
        // 1000是个查询语句的？号赋值,可以多个值
        // 底层得到的ResultSet，prepareStatement会在query（）中会关闭
        try {
            // 1.得到连接(druid)
            connection = JDBCUtils_Druid.getConnection();
            List<Account> query = queryRunner.query(connection, sql, new BeanListHandler<>(Account.class), 1000, 1010);
            // 取出结果
            for (Account account : query) {
                System.out.println(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeConnection(null, null, connection);
        }
    }

    // 测试返回单行记录
    @Test
    public void testQueryOne() {
        // 返回单行记录
        String sql = "select * from account where id = ?;";
        try {
            connection = JDBCUtils_Druid.getConnection();
            // 返回的是单行数据 使用BeanHandler()
            Account account = queryRunner.query(connection, sql, new BeanHandler<>(Account.class), 2000);
            System.out.println(account);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeConnection(null, null, connection);
        }
    }

    // 查询结果为单行单列 ,返回结果为一个对象
    @Test
    public void testOROL() {
        String sql = "select max(balance) from account;";
        try {
            connection = JDBCUtils_Druid.getConnection();
            // 返回的是单个对象 使用BeanHandler()
            Object query = queryRunner.query(connection, sql, new ScalarHandler());
            System.out.println(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeConnection(null, null, connection);
        }
    }

    // 执行dml语言(update insert delete)
    @Test
    public void testDML() {
        String sql = "insert into account values (null,?,?);";
        try {
            connection = JDBCUtils_Druid.getConnection();
            // 返回值为受影响的行数
            int tom = queryRunner.update(connection, sql, "tom", 580664);
            System.out.println(tom > 0 ? "成功" : "未收影响");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils_Druid.closeConnection(null, null, connection);
        }
    }
}
