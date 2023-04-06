// // 定义变量 var let const
// let str = "hello world!";
// // 弹窗提示 alert
// alert(typeof str);
// str = 9999;
// alert(typeof str);
// // 创建对象 new Object() ,{}
// const person = {};
// person.name = "张无忌";
// person.pid = 'p001';
// alert(person.pid + '-' + person.name);
// // 方法
// function hello(name){
//     return "hello to " + name;
// }
// function hello2(num1,num2){
//     if(num1>num2){
//         return hello("ljw")
//     }else {
//         alert("hello")
//     }
// }
// console.log(hello2(3,4))
let a = 0;

function showBGColor() {
    // if (a!==0){
    //     return;
    // }
    // // event 当前发生的事件
    // // event.srcElement:事件源
    // alert(window.event.srcElement);
    // alert(window.event.srcElement.tagName);
    // a++;
    if (event && event.srcElement && event.srcElement.tagName === "DIV") {
        // 获取操作的元素 event.srcElement
        var div = event.srcElement;
        // 修改其背景颜色 元素.style.backgroundColor
        div.style.backgroundColor = "green";
        // 获取其父级元素
        // var div2 = div.parentElement;

    }
}
function recoverShow(){
    if (event && event.srcElement && event.srcElement.tagName === "DIV") {
        var div = event.srcElement;
        div.style.backgroundColor = "azure";
    }
}