import java.sql.Connection;

/**
 * @author ljw
 * @version 1.0
 */
public class ConQuest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = JDBCUtils.getConnection();
            JDBCUtils.closeConnection(null, null, connection);
        }
        long end = System.currentTimeMillis();
        System.out.println("连接5000次时间：" + (end - start));
    }

}
