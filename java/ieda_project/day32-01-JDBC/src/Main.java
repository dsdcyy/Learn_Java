/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
//        基本介绍
        /*
        * 1.JDBC为访问不同的数据库提供了统一的接口，为使用者屏蔽了细节问题
        * 2.Java程序员使用JDBC，可以连接任何提供了JDBC驱动程序的数据库系统，从而
        * 完成对数据库的各种操作。
        * 3.JDBC的基本原理t
        * 4.模拟JDBC com.ljw.jdbc.myjdbc
        */
        // JDBC带来的好处
        /*说明：JDBC是Java提作的接口API，Java程序员只需要面向这套接口编程即可。
        不同的数据库厂商，需要针对这套接口，提供不同实现。
        */

        //JDBCAPI

        /*
           JDBCAPI是一系列的接口，它统一和规范了应用程序与数据库的连接、执行SQL语句，并到得到返回结果等各类操作，
           相关类和接口在java.sql与javax.sgl包中
        * */

        // UDBC程序编写步骤 com.ljw.jdbc.JDBC01.java
        /*
        * 1.注册驱动－加载Driver类
        * 2.获取连接－得到Connection
        * 3.执行增删改查－发送SQL给mysql执行
        * 4.释放资源关闭相关连接
        * */

        // ResultSet[结果集]
        // 基本介绍
        /*
        * 1.表示数据库结果集的数据表，通常通过执行查询数据库的语句生成
        * 2.ResultSet对象保持一个光标指向其当前的数据行。最初，光标位于第一行之前
        * 3.next方法将光标移动到下一行，并且由于在ResultSet对象中没有更多行时返回false，
        * 因此可以在while循环中使用循环来遍历结果集
        * */

        // Statement
        // 基本介绍
        /*
        * 1.Statement对象用于执行静态SQL语句并返回其生成的结果的对象
        * 2.在连接建立后，需要对数据库进行访问，执行命名或是SQL语句可以通过
        * Statement[存在SQL注入]
        * PreparedStatement [预处理
        * CallableStatement [存储过程]
        * 3.Statement对象执行SQL语句，存在SQL注入风险
        * 4.SQL注入是利用某些系统没有对用户输入的数据进行充分的检查，
        * 而在用户输入数据中注入非法的SQL语句段或命令,恶意攻击数据库。Sql_injection.sql
        * 5.要防范SQL注入，只要用PreparedStatement(从Statement扩展而来】取代Statement就可以了
        * */

        /*
        * 输入用户名为 1' or ,密码为or '1'='1
        * */
        /*

        // PreparedStatement
        // 基本介绍 PreparedStatement_.java
        * 1.PreparedStatement执行的SQL语句中的参数用问号（3)来表示，调用PreparedStatement对象的setxxx()方法来设置这些参数.
        * setXxx0方法有两个参数，第一个参数是要设置的SQL语句中的参数的索引从1开始），第二个是设置的SQL语句中的参数的值
        * 2.调用executeUpdate()：执行更新，包括增、删、修改
        * 3.调用executeQuery()，返回ResultSet 对象
        * */
        // 预处理好处
        /*
        1.不再使用+拼接sgl语句，减少语法错误
        2.有效的解决了sgl注入问题！
        3.大大减少了编译次数，效率较高
        */

        // DriverManager驱动管理类
        /*
        getConnection(url,user.pwd）：获取连接
        Connection 接口
        1.createStatement()：生成命令对象
        2.prepareStatement(sql）：生成预编译命令对象
        * */

        // JDBC工具类 JDBCUtils.java

        // 事物
        // 基本介绍
        /*
        * 1.JDBC程序中当一个Connection对象创建时，默认情况下是自动提交事务：
        * 每次执行一个SQL语句时，如果执行成功，就会向数据库自动提交，而不能回滚
        * 2.JDBC程序中为了让多个SQL语句作为一个整体执行，
        * 3.需要使用事务调用Connection的setAutoCommit(false）可以取消自动提交事务
        * 4.在所有的SQL语句都成功执行后，调用commit()方法提交事务
        * 5.在其中某个操作失败或出现异常时，调用rollback()；方法回滚事务
        * */

        // 批处理
        // 基本介绍
        /*
        * 1.当需要成批插入或者更新记录时。可以采用Java的批量更新机制，这一机制允许多条语句一次性提交给数据库批量处理。
        * 通常情况下比单独提交处理更有效率
        * 2.JDBC的批量处理语句包括下面方法：
            addBatch()：添加需要批量处理的SQL语句或参数
            executeBatch()：执行批量处理语句；
            clearBatch()：清空批处理包的语句
        * 3.JDBC连接MySQL时，如果要使用批处理功能，请再url中加参数?rewriteBatchedStatements=true
        * 4.批处理往往和PreparedStatement一起搭配使用，可以既减少编译次数，又减少运行次数，效率大大提高
        * */
        System.out.println("Hello world!");
    }
}