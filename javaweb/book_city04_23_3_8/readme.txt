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



