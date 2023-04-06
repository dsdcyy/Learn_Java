1.设置编码
tomcat8之前，设置编码：
1)get请求方式：
//get方式目前不需要设置编码（基于tomcat8）
//如果是get请求发送的中文数据，转码稍微有点麻烦（tomcat8之前）
String fNAME = request.gEtPArAMETER("fNAME");
//1.将字符串打散成字节数组
bytel] bytes = fname.getBytes("IS0-8859-1"）；
//2.将字节数组按照设定的编码重新组装成字符串
EnAME =NEW STe，"UTF-8"）；

2)post请求方式：
request.setcharacterEncoding("UTF-8"）；
tomcat8开始，设置编码，只需要针对post方式
request.setcharacterEncoding("UTF-8");
注意：
需要注意的是，设置编码（post）这一句代码必须在所有的获取参数动作之前

2．Servlet的继承关系
1，继承关系
javax.servlet.servlet接口
javax.servlet.Genericservlet抽象类 实现了servlet接口
javax.servlet.http.Httpservlet Genericservlet抽象类的抽象子类
2．相关方法
javax.servlet.servlet接口：
void init(config）－初始化方法
void service(request,response）－服务方法
void destory（）－销毁方法

javax.servlet.Genericservlet抽象类：
void service(request,response）－仍然是抽象的

javax.servlet.http.Httpservlet 抽象子类：
void service(request,response）－不是抽象的
1.string method = req.getMethod(）；获取请求的方式
2．各种if判断，根据请求方式不同，决定去调用不同的do方法
3．在HttpServlet这个抽象类中，do方法都差不多：
3.小结：
1）继承关系： HttpServlet -> GenericServlet -> servlet
2） Servlet中的核心方法：init（），service（），destroy()
3）服务方法：当有请求过来时，service方法会自动响应（其实是tomcat容器调用的）
在HttpServlet中我们会去分析请求的方式：到底是get、post、head还是delete等等
然后再决定调用的是哪个do开头的方法
那么在HttpServlet中这些do方法默认都是405的实现风格-要我们子类去实现对应的方法，否则会报错
4）因此，我们在新建servlet时，我们才会去考虑请求方法，从而决定重写哪个do方法

3．Servlet的生命周期
1）生命周期：从出生到死亡的过程就是生命周期。对应servlet中的三个方法：init（），service（），destroy（）
2）默认情况下：
第一次接收请求时，这个servlet会进行实例化
（调用构造方法）
））、初始化(调用init（））、然后服务(调用service（））
从第二次请求开始，每一次都是服务
当容器关闭时，其中的所有的servlet实例会被销毁，调用销毁方法

3）通过案例我们发现：
-Servlet实例tomcat只会创建一个，所有的请求都是这个实例去响应。
-默认情况下，第一次请求时，tomcat才会去实例化，初始化，然后再服务.这样的好处是什么？提高系统的启动速度
－因此得出结论：如果需要提高系统的启动速度，当前默认情况就是这样。如果需要提高响应速度，我们应该设置servlet的初始化时机
4）Servlet的初始化时机：
·默认是第一次接收请求时，实例化，初始化
·我们可以通过<load-on-startup>来设置servlet启动的先后顺序，数字越小，启动越靠前，最小值0
5）Servlet在容器中是：单例的、线程不安全的
    --单例：所有的请求都是同一个实例去响应
    --线程不安全：一个线程需要根据这个实例中的某个成员变量值去做逻辑判断。但是在中间某个时机，另一个线程改变了这个成员变量的值，从而导致第一个线程的执行路径发生了变化
    --我们已经知道了servlet是线程不安全的，给我们的启发是：尽量的不要在servlet中定义成员变量，如果不得不定义成员变量，
    那么不要去：不要去修改成员变量的值②不要去根据成员变量的值做一些逻辑判断
Http协议
1、介绍
HTTP：Hyper TextTransfer Protocol超文本传输协议。
HTTP最大的作用就是确定了请求和响应数据的格式。
浏览器发送给服务器的数据：请求报文；服务器返回给浏览器的数据：响应报文。
2、请求报文
1）在开发者工具中浏览报文原码
2) 请求报文的三个部分
    -- 请求行
    -- 请求消息头
    -- 请求体
3）请求行
    -- 请求的方式
    -- 请求的url
    -- 请求的协议(一般:http1.1)
4) 请求消息头
    客户端报告服务器的信息
    -- 浏览器型号
    -- 版本
    -- 我能接收的内容类型
    -- 我给你发消息的方式
    -- 等
5) 请求体
作用:作为请求的主体，发送数据给服务器，具体就是post请求方式的请求参数
    get方式 没有请求体,但是有一个queryString
    post方式,有请求体 form data 当前请求体是一个表单提交的请求参数
    json格式 有请求体 request payload
3、请求方式
    ①HTTP协议已定义的请求方式
    HTTP1.1中共定义了八种请求方式：
    GET：从服务器端获取数据
    POST：将数据保存到服务器端
    PUT：命令服务器对数据执行更新
    DELETE：命令服务器删除数据
    HEAD
    CONNECT
    OPTIONS
    TRACE

4.响应报文
    -- 响应状态行
        -- 协议
        -- 响应状态码
        -- 响应状态
    -- 响应消息头
        -- 包含了服务器的信息，服务器发送给浏览器的信息
        -- 内容的媒体类型
        -- 编码
        -- 内容长度
        -- 等
    -- 响应体
        -- 响应的实际内容 html页面带代码
5.会话
    --Http无状态
        -- 服务器无法判断这两次请求是同一个客户端还是不同客户端发过来的
        -- 无状态带来的现实问题:第一次请求是添加商品到购物车，第二次请求是结帐，如果两次请求服务器无法区分
            是一个用户的，就会导致混乱
        -- 解决 通过会话跟踪技术；来解决无状态的问题
            S：请告诉我你的会话ID
            C：没有！
            S：哦，那我知道了，你是第一次给我发请求，我给你分配一个SessionID：123
            S：请告诉我你的会话ID
            C:123
            S：哦，我知道了，你是*大**，上次什么时间访问我的。
            S：请告诉我你的会话ID
            C:345
            S：哦，我知道了，你是***，上次什么时间访问我的
        -- 第一次请求 在响应标头里有Set-Cookie:JSESSIONID=E29BF060B0A12031E8D72C684FD18F50; Path=/pro01; HttpOnly 属性
        -- 第二次请求 在请求标头里有 Cookie: JSESSIONID=E29BF060B0A12031E8D72C684FD18F50; Pycharm-3ca47621=f5d4444f-4c4b-4de3-ac6d-4be364147348; Idea-e933c2c0=731e0f7c-972d-47f2-9f42-d96b8c36d484
        -- 客户端第一次发送请求给服务器，服务器获取session，获取不到，则创建新的，然后响应给客户端
        -- 客户端第二次发送请求给服务器，客户端携带sessionid发送给服务器，服务器就能根据session id判断是哪一位用户和我进行连接的

        常用的API：
        request.getSession（）->获取当前的会话，没有则创建一个新的会话
        request.getSession（true）->效果和不带参数相同
        request.getSession（false）->获取当前会话，没有则返回nul1，不会创建新的
        session.getId(）-> 获取sessionID
        session.isNew（）->判断当前session是否是新的
        session.getMaxInactiveInterval（）-> session的非激活间隔时长，默认1800秒
        session.setMaxInactiveInterval()  -> 设置 session的非激活间隔时长
        session.invalidate（）->强制性让会话立即失效
    -- session保存作用域
        -- session保存作用域是和具体的某一个session对应的
        -- 常用API
            session.setAttribute(key,value)  向当前session作用域保存一个数据'lina'，对应的key:value
            session.getAttribute(key) 通过key向当前session作用域获取对应key的value值
            removeAttribute(k) 删除key对应的数据
6．服务器内部转发以及客户端重定向
    -- 服务器内部转发：request.getRequestDispatcher（"..."）.forward(request,response）；
        一次请求响应的过程，对于客户端而言，内部经过了多少次转发，客户端是不知道的地址栏没有变化
    -- 客户端重定向：response.sendRedirect（"...."）；
        两次请求响应的过程。客户端肯定知道请求URL有变化地址栏有变化



