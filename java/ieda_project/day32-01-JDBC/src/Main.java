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

        // 传统获取Connection问题分析
        /*
        * 1.传统的JDBC数据库连接使用DriverManager来获取，每次向数据库建立连接的时候都要将Connection加载到内存中，
        * 再验证IP地址，用户名和密码(0.05s~1s时间)。需要数据库连接的时候，就向数据库要求一个，
        * 频繁的进行数据库连接操作将占用很多的系统资源，容易造成服务器崩溃。
        * 2.每一次数据库连接，使用完后都得断开，如果程序出现异常而未能关闭，将导致数据库内存泄漏，最终将导致重启数据库。
        * 3.传统获取连接的方式，不能控制创建的连接数量，如连接过多，也可能导致内存泄漏，MySQL崩溃。
        * 4.解决传统开发中的数据库连接问题，可以采用数据库连接池技术(Connection pool）
        * */

        // 数据库连接池
        // 数据库连接池基本介绍
        /*
        * 1.预先在缓冲池中放入一定数量的连接，当需要建立数据库连接时，只需从“缓冲池”中取出一个，使用完毕之后再放回去
        * 2.数据库连接池负责分配、管理和释放数据库连接，它允许应用程序重复使用一个现有的数据库连接，而不是重新建立一个。
        * 3.当应用程序向连接池请求的连接数超过最大连接数量时，这些请求将被加入到等待队列中.
        * */

        // 数据库连接池种类
        /*
        * 1.JDBC的数据库连接池使用javax.sql.DataSource来表示，DataSource只是一个接口，该接口通常由第三方提供实现
        * 2.C3P0数据库连接池，速度相对较慢，稳定性不错（hibernate，spring）C3P0_java
        * 3.DBCP数据库连接池，速度相对c3p0较快，但不稳定
        * 4.Proxool数据库连接池，有监控连接池状态的功能，稳定性较c3p0差一点
        * 5.BoneCP数据库连接池，速度快
        * 6.Druid（德鲁伊）是阿里提供的数据库连接池，集DBCP、C3PO、Proxool,优点于一身的数据库连接池 Druid_.java
        * */

        // Apache-JDBCUtils_Druid
        /*
        * 1.关闭connection后，resultSet结果集无法使用
        * 2.resultSet不利于数据的管理，只能使用一次
        * 3.示意图
        * */

        // 基本介绍
        /*
        * 1.commons-dbutils是Apache组织提供的一个开源JDBC工具类库，它是对JDBC的封装使用dbutils能极大简化jdbc编码的工作量。
        * */
        // DbUtils类
        /*
        * 1.QueryRunner类：该类封装了SQL的执行，是线程安全的。可以实现增、删、改、查、批处理
        * 2.使用QueryRunner类实现查询
        * 3.ResultSetHandler接口：该接口用于处理java.sql.ResultSet，将数据按要求转换为另一种形式
        * */
        /*
        * ArrayHandler：把结果集中的第一行数据转成对象数组，
        * ArrayListHandler：把结果集中的每一行数据都转成一个数组，再存放到List中。
        * BeanHandler：将结果集中的第一行数据封装到一个对应的JavaBean实例中。
        * BeanListHandler：将结果集中的每一行数据都封装到一个对应的JavaBean实例中，存放到List里。
        * ColumnListHandler：将结果集中某一列的数据存放到List中。
        * KeyedHandler(name）：将结果集中的每行数据都封装到Map里，再把这些map再存到一个map里，其key为指定的key。
        * MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
        * MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
        * */

        // DAO和增删改查通用方法-BasicDao DAO 数据访问对象
        // 先分析一个问题
        /*
        * apache-dbutils+Druid简化了JDBC开发，但还有不足：
        * 1. SQL语句是固定，不能通过参数传入，通用性不好，需要进行改进，更方便执行增删改查
        * 2.对于select操作，如果有返回值，返回类型不能固定，需要使用泛型
        * 3.将来的表很多，业务需求复杂，不可能只靠一个Java类完成
        * 4.引出=》BasicDAO画出示意图
        * */

        // 基本说明
        /*
         * 1.DAO:data access object数据访问对象
         * 2.这样的通用类，称为BasicDao，是专门和数据库交互的，即完成对数据库(表)的crud操作。
         * 3.在BasicDao的基础上，实现一张表对应一个Dao，更好的完成功能，比如Customer表-Customer.java*(javabean)-CustomerDao.java
         */

        // 完成一个简单设计
         // com.ljw.dao
        /*
        * 1.com.ljw.dao.utils // 工具类
        * 2.com.ljw.dao.domain // javabean
        * 3.com.ljw.dao.dao // xxxDao,BasicDao
        * 4.com.ljw.dao.test // 测试类
        * */
        System.out.println("Hello world!");
    }
}