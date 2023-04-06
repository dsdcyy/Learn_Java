01
1. 需求分析
2. 数据库设计
 1） 实体分析
    - 图书                Book
    - 用户                User
    - 订单                OrderBean
    - 订单详情             OrderItem
    - 购物车项             CartItem
 2） 实体属性分析
    - 图书 : 书名、作者、价格、销量、库存、封面、状态
    - 用户 : 用户名、密码、邮箱
    - 订单 : 订单编号、订单日期、订单金额、订单数量、订单状态、用户
    - 订单详情 : 图书、数量、所属订单
    - 购物车项 : 图书、数量、所属用户

今日内容：
1. 显示主页面(index页面)
  - 新建BookDAO 、 BookDAOImpl ： getBookList()
  - 新建BookService 、 BookServiceImpl : getBookList()
  - 新建BookController : index()
  - 编辑index.html
2. 首页上登录成功之后显示欢迎语和购物车数量
3. 点击具体图书的添加到购物车按钮
4. 购物车详情
5. 结账
   1) 订单表添加一条记录
   2) 订单详情表添加7条记录
   3) 购物车项表中需要删除对应的7条记录
6. 关于订单信息中的订单数量问题
7. 编辑购物车
8. 关于金额的精度问题
9. 过滤器判断是否是合法用户：
   - 解决方法：新建SessionFilter ， 用来判断session中是否保存了currUser
   - 如果没有currUser，表明当前不是一个登录合法的用户，应该跳转到登录页面让其登录

   - 现在添加了过滤器之后，出现了如下错误：
   localhost 将您重定向的次数过多。
   尝试清除 Cookie.
   ERR_TOO_MANY_REDIRECTS


05
1. Cookie
   1. 创建Cookie对象
   2. 在客户端保存Cookie
   3. 设置Cookie的有效时长
      cookie.setMaxAge(60)  ， 设置cookie的有效时长是60秒
      cookie.setDomain(pattern);
      cookie.setPath(uri);
   4. Cookie的应用：
     4-1: 记住用户名和密码十天 setMaxAge(60 * 60 * 24 * 10)
     4-2: 十天免登录

2. Kaptcha
   1. 为什么需要验证码
   2. kaptcha如何使用:
      - 添加jar
      - 在web.xml文件中注册KaptchaServlet，并设置验证码图片的相关属性
      - 在html页面上编写一个img标签，然后设置src等于KaptchaServlet对应的url-pattern
   3. kaptcha验证码图片的各个属性在常量接口：Constants中
   4. KaptchaServlet在生成验证码图片时，会同时将验证码信息保存到session中
      因此，我们在注册请求时，首先将用户文本框中输入的验证码值和session中保存的值进行比较，相等，则进行注册

3. JS - Exp
   1)正则表达式的使用三步骤：
       1. 定义正则表达式对象
          正则表达式定义有两个方式：
          1) 对象形式
             var reg = new RegExp("abc")
          2) 直接量形式
             var reg = /abc/;
          3) 匹配模式：
           - g 全局匹配
           - i 忽略大小写匹配
           - m 多行匹配
           - gim这三个可以组合使用，不区分先后顺序
             例如： var reg = /abc/gim , var reg = new RegExp("abc","gim");
       2. 定义待校验的字符串
       3. 校验
   2)元字符
     . , \w , \W , \s , \S , \d , \D , \b , ^ , $

   3)[]表示集合
     [abc] 表示 a或者b或者c
     [^abc] 表示取反，只要不是a不是b不是c就匹配
     [a-c] 表示a到c这个范围匹配

   4) 出现的次数
     * 表示多次 （0 ~ n ）
     + 至少一次 ( >=1 )
     ? 最多一次 (0 ~ 1)
     {n} 出现n次
     {n,} 出现n次或者多次
     {n,m} 出现n到m次

昨日内容：：
  1. 在注册页面显示验证码
   1) 添加jar
   2) 在web.xml文件中配置KaptchaServlet，以及配置相关的属性
   3) 在页面上访问这个Servlet，然后这个Servlet做两件事情：
      - 在页面上显示验证码图片
      - 在session作用域中保存验证码信息，对应的key存储在Constans这个常量接口中
   4) 用户在注册页面中输入验证码发送给服务器，那么需要和session中保存的进行比较
  2. 注册功能实现
  3. js中的正则表达式
   1) 三步骤：定义正则表达式对象（两种方式）；定义待校验的字符串；校验
   2) 正则表达式的规则：
      g  i  m
      . , \w , \W , \d , \D , \b , \s , \S , ^ , $
      [] , [^] , [-]
      * , + , ? , {n} , {n,} , {n,m}
      |

今日内容：
  1. 注册页面表单验证
    1) <form>有一个事件 onsubmit ,
        onsubmit="return false" , 那么表单点击提交按钮时不会提交
        onsubmit="return true" ,  那么表单点击提交按钮时会提交

    2) 获取文档中某一个节点的方式：
        //DOM:Document
        //var unameTxt = document.getElementById("unameTxt");
        //BOM:Browser
        //document.forms[0].uname


  2. 原生的Ajax（了解）
    第一步： 客户端发送异步请求；并绑定对结果处理的回调函数
    1) <input type="text" name="uname" onblur="ckUname()"/>
    2) 定义ckUname方法：
       - 创建XMLHttpRequest对象
       - XMLHttpRequest对象操作步骤：
         - open("GET",url,true)
         - onreadyStateChange 设置回调
         - send() 发送请求
       - 在回调函数中需要判断XMLHttpRequest对象的状态:
         readyState(0-4) , status(200)
    第二步：服务器端做校验，然后将校验结果响应给客户端

1. 回顾：
    Ajax : 异步的JavaScript and XML
    目的： 用来发送异步的请求，然后当服务器给我响应的时候再进行回调操作
    好处： 提高用户体验；局部刷新：降低服务器负担、减轻浏览器压力、减轻网络带宽压力
    开发步骤：
      1) 创建XMLHttpRequest
      2) 调用open进行设置："GET" , URL , true
      3) 绑定状态改变时执行的回调函数 - onreadystatechange
      4) 发送请求 - send()
      5) 编写回调函数，在回调函数中，我们只对XMLHttpRequest的readystate为4的时候感兴趣
                                我们只对XMLHttpRequest的status为200的时候感兴趣

    0: (Uninitialized) the send( ) method has not yet been invoked.
    1: (Loading) the send( ) method has been invoked, request in progress.
    2: (Loaded) the send( ) method has completed, entire response received.
    3: (Interactive) the response is being parsed.
    4: (Completed) the response has been parsed, is ready for harvesting.

    0 － （未初始化）还没有调用send()方法
    1 － （载入）已调用send()方法，正在发送请求
    2 － （载入完成）send()方法执行完成，已经接收到全部响应内容
    3 － （交互）正在解析响应内容
    4 － （完成）响应内容解析完成，可以在客户端调用了

今天内容：
1. Vue
    1) {{}} - 相当于innerText
    2) v-bind:attr 绑定属性值。例如，v-bind:value - 绑定value值
       简写：    :value
    3) v-model 双向绑定
       v-model:value   , 简写  v-model
    4) v-if , v-else , v-show
       v-if和v-else之间不能有其他的节点
       v-show是通过样式表display来控制节点是否显示
    5) v-for 迭代
       v-for={fruit in fruitList}
    6) v-on 绑定事件
    7) 其他：
       - trim:去除首尾空格 , split() , join()
       - watch表示侦听属性
       - 生命周期

2. Axios
   Axios是Ajax的一个框架,简化Ajax操作
   Axios执行Ajax操作的步骤：
   1. 添加并引入axios的js文件

   2-1. 客户端向服务器端异步发送普通参数值
    - 基本格式： axios().then().catch()
    - 示例：
      axios({
        method:"POST",
        url:"....",
        params:{
            uname:"lina",
            pwd:"ok"
        }
      })
      .then(function(value){})          //成功响应时执行的回调        value.data可以获取到服务器响应内容
      .catch(function(reason){});       //有异常时执行的回调          reason.response.data可以获取到响应的内容

                                                                   reason.message / reason.stack 可以查看错误的信息

    2-2. 客户端向服务器发送JSON格式的数据
    - 什么是JSON
      JSON是一种数据格式
      XML也是一种数据格式
      XML格式表示两个学员信息的代码如下：
      <students>
        <student sid="s001">
            <sname>jim</sname>
            <age>18</age>
        </student>
        <student sid="s002">
            <sname>tom</sname>
            <age>19</age>
        </student>
      </students>
      JSON格式表示两个学员信息的代码如下：
      [{sid:"s001",age:18},{sid:"s002",age:19}]
    - JSON表达数据更简洁，更能够节约网络带宽
    - 客户端发送JSON格式的数据给服务器端
    1) 客户端中params需要修改成：  data:
    2) 服务器获取参数值不再是 request.getParameter()...
       而是：
       StringBuffer stringBuffer = new StringBuffer("");
       BufferedReader bufferedReader = request.getReader();
       String str = null ;
       while((str=bufferedReader.readLine())!=null){
           stringBuffer.append(str);
       }
       str = stringBuffer.toString() ;

    3) 我们会发现 str的内容如下：
       {"uname":"lina","pwd":"ok"}

    -  服务器端给客户端响应JSON格式的字符串，然后客户端需要将字符串转化成js Objects