function test_regexp_(){
    var regexp = new RegExp("abc");
    var str = 'abcdefg';
    var flag = regexp.test(str);
    console.log(flag);
}
function test_regexp_2(){
    var regexp = /o/; // 只匹配一次
    var str = "aoceojo";
    str = str.replace(regexp,"b");
    console.log(str);
}
function test_regexp_3(){
    var regexp = /o/g; // 全文匹配
    var str = "aoceojobO";
    str = str.replace(regexp,"b");
    console.log(str);
}
function test_regexp_4(){
    var regexp = /o/gi; // 全文匹配，忽略大小写
    var str = "aoceojobO";
    str = str.replace(regexp,"b");
    console.log(str);
}
function test_regexp_5(){
    //目标字符串1
    var targetStr01 = 'Hello\nWorld!';
//目标字符串2
    var targetStr02 = 'Hello';

//匹配以'Hello'结尾的正则表达式，没有使用多行匹配
    var reg = /Hello$/m;
    console.log(reg.test(targetStr01));//false

    console.log(reg.test(targetStr02));//true
}
function test_email(){
    var emailReg = /[a-zA-Z1-9]\w*@(\w+.)+\w+/;
    var email = "1870672903iii@gmail.com";
    var b = emailReg.test(email);
    console.log(b);
}
function test_regexp_8(){
    var reg = /.{8,}/;
    var str = '12345678';
    console.log(reg.test(str)) ;
}
// test_regexp_();
// test_regexp_2();
// test_regexp_3();
// test_regexp_4();
// test_regexp_5();
test_email();
test_regexp_8()