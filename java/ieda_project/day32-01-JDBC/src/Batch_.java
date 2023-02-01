import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author ljw
 * @version 1.0
 * 演示java批处理5000条数据
 */
public class Batch_ {
    // 传统方法
    @Test
    public void noBatch() throws SQLException {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into account values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行...");
        long start = System.currentTimeMillis();
        for (int i = 1; i < 5001; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setInt(2, 3000 + i * 100);
            preparedStatement.execute();
        }
        JDBCUtils.closeConnection(null, preparedStatement, connection);
        long end = System.currentTimeMillis();
        System.out.println("结束执行,用时:" + (end - start) + "毫秒...");
    }
    @Test
    public void Batch() throws SQLException {
        // 注意添加连接参数以支持批处理
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into account values(null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行...");
        long start = System.currentTimeMillis();
        for (int i = 1; i < 5001; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setInt(2, 3000 + i * 100);
            // 添加到批处理包中
            preparedStatement.addBatch();
            // 当有一千条数据时，再批量执行
            if (i % 1000 == 0) {
                // 执行executeBatch的数据
                preparedStatement.executeBatch();
                System.out.println("执行成功1000...");
                // 执行完后清空batch
                preparedStatement.clearBatch();
            }
        }
        JDBCUtils.closeConnection(null, preparedStatement, connection);
        long end = System.currentTimeMillis();
        System.out.println("结束执行,用时:" + (end - start) + "毫秒...");
    }
}
