/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        /*
        Java/DB/JDBC
        HTML/CSS/JS
        CS：客户端服务器架构模式
        优点：充分利用客户端机器的资源，减轻服务器的负荷
        （一部分安全要求不高的计算任务存储任务放在客户端执行，不需要把所有的计算和
        存储都在服务器端执行，从而能够减轻服务器的压力，也能够减轻网络负荷）
        缺点：需要安装；升级维护成本较高
        BS：浏览器服务器架构模式
        优点：客户端不需要安装；维护成本较低
        缺点：所有的计算和存储任务都是放在服务器端的，服务器的负荷较重；在服务端计算完成
        之后把结果再传输给客户端，因此客户端和服务器端会进行非常频繁的数据通信，从而网络
        负荷较重
        * */

        /*
        1.Tomcat的安装和配置
        1）解压：不要有中文不要有空格
        ！2）目录结构说明：
        bin可执行文件目录
        conf配置文件目录
        lib存放lb的目录
        logs日志文件目录
        webapps项目部署的目录
        work工作目录
        temp临时目录
        ;3）配置环境变量，让tomcat能够运行
        因为tomcat也是用java和C来写的，因
        此需要JRE，所以需要配置JAVA_HOME
        14）启动tomcat，然后访问主页
        ;2.新建Web项目，并在tomcat中部署
        在webapps新建自己的项目文件夹，里面需要包含一个WEB-INF的文件夹和项目文件
        */

        System.out.println("Hello world!");
    }
}