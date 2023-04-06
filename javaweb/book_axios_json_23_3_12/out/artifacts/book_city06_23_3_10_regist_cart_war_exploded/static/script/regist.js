function $(id){
    return document.getElementById(id);
}
function preRegist(){
    // 密码的长度至少为8位
    return verifyUname() && verifyPwd() && verifyEmail() && verifyCode();
}

function verifyUname(){
    var uname = $("uname");
    // 用户名不为空且用户名应为6~16位数组和字母组成
    var unameReg = /[a-zA-Z]\w{5,15}/;
    var unameSpan = $("unameSpan");
    if (!unameReg.test(uname.value)){
        unameSpan.style.visibility="visible";
        return false;
    }
    unameSpan.style.visibility="hidden";
    return true;
}
function verifyPwd(){
    var pwdSpan = $("pwdSpan");
    var pwd = $("pwd");
    var pwdReg = /.{8,}/;
    var confirmPwd = $("confirmPwd");
    var confirmSpan = $("confirmSpan");
    // 密码不足8位
    if (!pwdReg.test(pwd.value)){
        pwdSpan.style.visibility="visible";
        return false;
    }
    pwdSpan.style.visibility="hidden";
    // 两次密码不一致
    if (!(pwd.value.toString()===confirmPwd.value.toString())){
        confirmSpan.style.visibility="visible";
        return false;
    }
    confirmSpan.style.visibility="hidden";
    return true;
}

function verifyEmail(){
    var email = $("email");
    var emailSpan = $("emailSpan")
    var regEmail = /[a-zA-Z1-9]\w*@(\w+.)+\w+/;
    if (!regEmail.test(email.value)){
        emailSpan.style.visibility = "visible";
        return false;
    }
    emailSpan.style.visibility = "hidden";
    return true;
}

function verifyCode(){
    var code = $("verifyCode");
    var codeSpan = $("codeSpan");
    if (code.value===""){
        codeSpan.style.visibility="visible";
        return false;
    }
    codeSpan.style.visibility="hidden";
    return true;
}

var xmlHttpRequest;

function createXmlHttpRequest(){
    if (window.XMLHttpRequest){
        // DOM 2 浏览器
        xmlHttpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        // IE浏览器
        try{
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");

        } catch (e){
            xmlHttpRequest = new ActiveXObject("Msxm12.XMLHTTP");
        }
    }

}

function ckUname(uname){
    createXmlHttpRequest();
    var url = "user.do?operate=ckUname&uname="+uname;
    xmlHttpRequest.open("GET",url,true);
    // 设置回调函数
    xmlHttpRequest.onreadystatechange = ckUnameCB;
    // 发送请求
    xmlHttpRequest.send();
}

function ckUnameCB(){
    if (xmlHttpRequest.readyState===4 && xmlHttpRequest.status===200){
        // 接收服务端的返回值
        if (xmlHttpRequest.responseText==="{'uname':'1'}"){
            alert("用户名已被注册!")
        }

    }
}