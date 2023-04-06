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
7．Thymeleaf－视图模板技术
    -- 添加thymeleaf的jar包
    -- 新建一个servlet类viewBaseservlet
    -- 在web.xml文件中添加配置
    -- 配置前缀 view-prefix
    -- 配置后缀view-suffix
    -- 使得我们的servlet继承viewBaseServlet

    部分标签：
    -- <th:if> if判断 <th:if>=“${#lists.isEmpty(session.fruitList)} 判断一个session作用域的变量列表是否为空”
    -- <th:unless> 否则
    -- <th:each> 循环获取 th:each="fruit : ${session.fruitList}"
    -- <th:text> 设置文本 th:text="${fruit.price}"
    -- th:href="@{/edit.do(fid=${fruit.fid})}
    -- th:value="xxx" 设置的是标签的值，比如input框的值
8.保存作用域
    -- 原始情况下，保存作用域有四个:
        -- page(页面级别,现在几乎不用)
        -- request(一次请求响应范围)
        -- session(一次会话范围)






review:

1. 保存作用域
   原始情况下，保存作用域我们可以认为有四个： page（页面级别，现在几乎不用） , request（一次请求响应范围） , session（一次会话范围） , application（整个应用程序范围）
   1） request：一次请求响应范围
   2） session：一次会话范围有效
   3） application： 一次应用程序范围有效

2. 路径问题
   1） 相对路径
   2） 绝对路径

3. 实现库存系统的功能

review:
1. 最初的做法是： 一个请求对应一个Servlet，这样存在的问题是servlet太多了
2. 把一些列的请求都对应一个Servlet, IndexServlet/AddServlet/EditServlet/DelServlet/UpdateServlet -> 合并成FruitServlet
   通过一个operate的值来决定调用FruitServlet中的哪一个方法
   使用的是switch-case
3. 在上一个版本中，Servlet中充斥着大量的switch-case，试想一下，随着我们的项目的业务规模扩大，那么会有很多的Servlet，也就意味着会有很多的switch-case，这是一种代码冗余
   因此，我们在servlet中使用了反射技术，我们规定operate的值和方法名一致，那么接收到operate的值是什么就表明我们需要调用对应的方法进行响应，如果找不到对应的方法，则抛异常
4. 在上一个版本中我们使用了反射技术，但是其实还是存在一定的问题：每一个servlet中都有类似的反射技术的代码。因此继续抽取，设计了中央控制器类：DispatcherServlet
   DispatcherServlet这个类的工作分为两大部分：
   1.根据url定位到能够处理这个请求的controller组件：
    1)从url中提取servletPath : /fruit.do -> fruit
    2)根据fruit找到对应的组件:FruitController ， 这个对应的依据我们存储在applicationContext.xml中
      <bean id="fruit" class="com.atguigu.fruit.controllers.FruitController/>
      通过DOM技术我们去解析XML文件，在中央控制器中形成一个beanMap容器，用来存放所有的Controller组件
    3)根据获取到的operate的值定位到我们FruitController中需要调用的方法
   2.调用Controller组件中的方法：
    1) 获取参数
       获取即将要调用的方法的参数签名信息: Parameter[] parameters = method.getParameters();
       通过parameter.getName()获取参数的名称；
       准备了Object[] parameterValues 这个数组用来存放对应参数的参数值
       另外，我们需要考虑参数的类型问题，需要做类型转化的工作。通过parameter.getType()获取参数的类型
    2) 执行方法
       Object returnObj = method.invoke(controllerBean , parameterValues);
    3) 视图处理
       String returnStr = (String)returnObj;
       if(returnStr.startWith("redirect:")){
        ....
       }else if.....

今日内容：
1. 再次学习Servlet的初始化方法
 1) Servlet生命周期：实例化、初始化、服务、销毁
 2) Servlet中的初始化方法有两个：init() , init(config)
   其中带参数的方法代码如下：
   public void init(ServletConfig config) throws ServletException {
     this.config = config ;
     init();
   }
   另外一个无参的init方法如下：
   public void init() throws ServletException{
   }
   如果我们想要在Servlet初始化时做一些准备工作，那么我们可以重写init方法
   我们可以通过如下步骤去获取初始化设置的数据
   - 获取config对象：ServletConfig config = getServletConfig();
   - 获取初始化参数值： config.getInitParameter(key);
 3) 在web.xml文件中配置Servlet
    <servlet>
        <servlet-name>Demo01Servlet</servlet-name>
        <servlet-class>com.atguigu.servlet.Demo01Servlet</servlet-class>
        <init-param>
            <param-name>hello</param-name>
            <param-value>world</param-value>
        </init-param>
        <init-param>
            <param-name>uname</param-name>
            <param-value>jim</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>Demo01Servlet</servlet-name>
        <url-pattern>/demo01</url-pattern>
    </servlet-mapping>
 4) 也可以通过注解的方式进行配置：
 @WebServlet(urlPatterns = {"/demo01"} ,
     initParams = {
         @WebInitParam(name="hello",value="world"),
         @WebInitParam(name="uname",value="jim")
     })

2. 学习Servlet中的ServletContext和<context-param>
    1) 获取ServletContext，有很多方法
       在初始化方法中： ServletContxt servletContext = getServletContext();
       在服务方法中也可以通过request对象获取，也可以通过session获取：
       request.getServletContext(); session.getServletContext()
    2) 获取初始化值：
       servletContext.getInitParameter();

3. 什么是业务层
    1) Model1和Model2
    MVC : Model（模型）、View（视图）、Controller（控制器）
    视图层：用于做数据展示以及和用户交互的一个界面
    控制层：能够接受客户端的请求，具体的业务功能还是需要借助于模型组件来完成
    模型层：模型分为很多种：有比较简单的pojo/vo(value object)，有业务模型组件，有数据访问层组件
        1) pojo/vo : 值对象
        2) DAO ： 数据访问对象
        3) BO ： 业务对象

    2) 区分业务对象和数据访问对象：
      1） DAO中的方法都是单精度方法或者称之为细粒度方法。什么叫单精度？一个方法只考虑一个操作，比如添加，那就是insert操作、查询那就是select操作....
      2） BO中的方法属于业务方法，也实际的业务是比较复杂的，因此业务方法的粒度是比较粗的
          注册这个功能属于业务功能，也就是说注册这个方法属于业务方法。
          那么这个业务方法中包含了多个DAO方法。也就是说注册这个业务功能需要通过多个DAO方法的组合调用，从而完成注册功能的开发。
          注册：
                1. 检查用户名是否已经被注册 - DAO中的select操作
                2. 向用户表新增一条新用户记录 - DAO中的insert操作
                3. 向用户积分表新增一条记录（新用户默认初始化积分100分） - DAO中的insert操作
                4. 向系统消息表新增一条记录（某某某新用户注册了，需要根据通讯录信息向他的联系人推送消息） - DAO中的insert操作
                5. 向系统日志表新增一条记录（某用户在某IP在某年某月某日某时某分某秒某毫秒注册） - DAO中的insert操作
                6. ....
    3) 在库存系统中添加业务层组件

4. IOC
    1) 耦合/依赖
      依赖指的是某某某离不开某某某
      在软件系统中，层与层之间是存在依赖的。我们也称之为耦合。
      我们系统架构或者是设计的一个原则是： 高内聚低耦合。
      层内部的组成应该是高度聚合的，而层与层之间的关系应该是低耦合的，最理想的情况0耦合（就是没有耦合）
    2) IOC - 控制反转 / DI - 依赖注入













5. 过滤器Filter
6. 事务管理
7. TransActionManager、ThreadLocal、OpenSessionInViewFilter


review:
1. Servlet生命周期中的初始化方法： init() ， init(config)
   public void init(ServletConfig config) throws ServletException {
        this.config = config ;
        init();
   }
   因此，如果我们需要在初始化时执行一些自定义的操作，那么我们可以重写无参的init方法。
   我们可以通过getConfig()获取ServletConfig对象
   可以通过config.getInitParameter()获取初始化参数

2. 通过ServletContext获取配置的上下文参数

3. MVC ： V：view 视图 ； C：Controller 控制器  ； M：Model 模型
   模型有很多种类：数据访问模型（DAO）；业务逻辑模型（BO）；值对象模型（POJO）；数据传输对象（DTO）

4. IOC
    IOC - 控制反转 / DI - 依赖注入
    控制反转：
    1) 之前在Servlet中，我们创建service对象 ， FruitService fruitService = new FruitServiceImpl();
       这句话如果出现在servlet中的某个方法内部，那么这个fruitService的作用域（生命周期）应该就是这个方法级别；
       如果这句话出现在servlet的类中，也就是说fruitService是一个成员变量，那么这个fruitService的作用域（生命周期）应该就是这个servlet实例级别
    2) 之后我们在applicationContext.xml中定义了这个fruitService。然后通过解析XML，产生fruitService实例，存放在beanMap中，这个beanMap在一个BeanFactory中
       因此，我们转移（改变）了之前的service实例、dao实例等等他们的生命周期。控制权从程序员转移到BeanFactory。这个现象我们称之为控制反转

    依赖注入：
    1) 之前我们在控制层出现代码：FruitService fruitService = new FruitServiceImpl()；
       那么，控制层和service层存在耦合。
    2) 之后，我们将代码修改成FruitService fruitService = null ;
       然后，在配置文件中配置:
       <bean id="fruit" class="FruitController">
            <property name="fruitService" ref="fruitService"/>
       </bean>

今日内容：
    1. 过滤器Filter
    2. 事务管理(TransactionManager、ThreadLocal、OpenSessionInViewFilter)
    3. 监听器(Listener , ContextLoaderListener)

1. 过滤器Filter
1) Filter也属于Servlet规范
2) Filter开发步骤：新建类实现Filter接口，然后实现其中的三个方法：init、doFilter、destroy
   配置Filter，可以用注解@WebFilter，也可以使用xml文件 <filter> <filter-mapping>
3) Filter在配置时，和servlet一样，也可以配置通配符，例如 @WebFilter("*.do")表示拦截所有以.do结尾的请求
4) 过滤器链
   1）执行的顺序依次是： A B C demo03 C2 B2 A2
   2）如果采取的是注解的方式进行配置，那么过滤器链的拦截顺序是按照全类名的先后顺序排序的
   3）如果采取的是xml的方式进行配置，那么按照配置的先后顺序进行排序

2. 事务管理
   1) 涉及到的组件：
     - OpenSessionInViewFilter
     - TransactionManager
     - ThreadLocal
     - ConnUtil
     - BaseDAO

   2) ThreadLocal
     - get() , set(obj)
     - ThreadLocal称之为本地线程 。 我们可以通过set方法在当前线程上存储数据、通过get方法在当前线程上获取数据
     - set方法源码分析：
     public void set(T value) {
         Thread t = Thread.currentThread(); //获取当前的线程
         ThreadLocalMap map = getMap(t);    //每一个线程都维护各自的一个容器（ThreadLocalMap）
         if (map != null)
             map.set(this, value);          //这里的key对应的是ThreadLocal，因为我们的组件中需要传输（共享）的对象可能会有多个（不止Connection）
         else
             createMap(t, value);           //默认情况下map是没有初始化的，那么第一次往其中添加数据时，会去初始化
     }
     -get方法源码分析：
     public T get() {
         Thread t = Thread.currentThread(); //获取当前的线程
         ThreadLocalMap map = getMap(t);    //获取和这个线程（企业）相关的ThreadLocalMap（也就是工作纽带的集合）
         if (map != null) {
             ThreadLocalMap.Entry e = map.getEntry(this);   //this指的是ThreadLocal对象，通过它才能知道是哪一个工作纽带
             if (e != null) {
                 @SuppressWarnings("unchecked")
                 T result = (T)e.value;     //entry.value就可以获取到工具箱了
                 return result;
             }
         }
         return setInitialValue();
     }
3. 监听器
    1) ServletContextListener - 监听ServletContext对象的创建和销毁的过程
    2) HttpSessionListener - 监听HttpSession对象的创建和销毁的过程
    3) ServletRequestListener - 监听ServletRequest对象的创建和销毁的过程

    4) ServletContextAttributeListener - 监听ServletContext的保存作用域的改动(add,remove,replace)
    5) HttpSessionAttributeListener - 监听HttpSession的保存作用域的改动(add,remove,replace)
    6) ServletRequestAttributeListener - 监听ServletRequest的保存作用域的改动(add,remove,replace)

    7) HttpSessionBindingListener - 监听某个对象在Session域中的创建与移除
    8) HttpSessionActivationListener - 监听某个对象在Session域中的序列化和反序列化

4. ServletContextListener的应用 - ContextLoaderListener













