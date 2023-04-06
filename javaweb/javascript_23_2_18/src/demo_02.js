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
// window 当前窗口对象 window.onload窗口加载时执行一个匿名函数
window.onload = function () {
    updateAllXj();
    const submit = $('submit');
    submit.onclick = addRows;
    // 页面记载完绑定事件
    // 根据className获取元素
    const main = $("tb1");
    // 获取所有行
    const rows = main.rows;
    for (let i = 0; i < rows.length - 1; i++) {
        // 某一行
        let tr = rows[i];
        trBindEvent(tr);

    }
}

function $(id) {
    return document.getElementById(id);
}

// 给tr鼠标绑定鼠标事件
function trBindEvent(tr) {
    // 绑定鼠标悬浮时事件
    tr.onmouseover = showBGColor;
    // 鼠标离开时绑定事件
    tr.onmouseout = recoverShow;
    // 获取该行的所有单元格
    let cells = tr.cells;
    // 单价行元素
    let priceId = cells[1];
    // 鼠标点击时进行编辑
    priceId.onclick = editPrice;
    let td = tr.cells[4];
    if (td && td.tagName === "TD") {
        td.onclick = delFruit;
    }
}

// 点击添加按钮添加tr
function addRows() {
    const tb1 = $('tb1');
    let tr = tb1.insertRow(tb1.rows.length - 1);
    let cell1 = tr.insertCell(0);
    cell1.innerText = $('name').value;
    let cell2 = tr.insertCell(1);
    let price = $('price').value;
    cell2.innerText = price;
    let cell3 = tr.insertCell(2);
    let nums = $('nums').value;
    cell3.innerText = nums;
    let cell4 = tr.insertCell(3);
    cell4.innerText = parseInt(price) * parseInt(nums) + "";
    let cell5 = tr.insertCell(4);
    cell5.innerText = 'x';
    trBindEvent(tr);
    updateAllXj();

}

// 检验键盘摁下值的方法
function ckInput() {
    let kc = event.keyCode;
    console.log(kc);
    // backspace:8
    // enter 13
    // 0-9 48-57
    // 除了输入数字 enter 退格键 其它都无法输入值
    if (!((kc >= 48 && kc <= 57) || kc === 8 || kc === 13)) {
        event.returnValue = false;
    }
    if (kc === 13) {
        event.srcElement.onblur();
    }
}

function delFruit() {
    // 弹出对话框
    if (!window.confirm("Are you sure you want to delete？")) {
        return;
    }

    if (event && event.srcElement && event.srcElement.tagName === "TD") {
        let td = event.srcElement;
        let tr = td.parentElement;
        // 删除该行
        tr.remove();
        // let table = $("tb1");
        // tr.rowIndex 获取tr的index table.deleteRow 删除该行
        // table.deleteRow(tr.rowIndex);
        updateAllXj();
    }
}

function editPrice() {
    if (event && event.srcElement && event.srcElement.tagName === "TD") {
        let priceId = event.srcElement;
        let input = priceId.firstChild;
        // 判断子节点是否存在且为文本节点 innerText 3 innerHtml 1
        if (input && input.nodeType === 3) {
            let oldPrice = priceId.innerText;
            // innerHTML 设置当前节点的内部html代码
            priceId.innerHTML = "<input type='text' size='8px' placeholder='仅能输入数字'/>";
            // firstChild 第一个字节点
            input = priceId.firstChild;
            if (input.tagName === "INPUT") {
                input.value = oldPrice;
                input.onblur = updatePrice;
                // 输入框绑定键盘摁下事件，我需要保证用户输入的是数字
                input.onkeydown = ckInput;
            }
        }

    }

}

function updatePrice() {
    if (event && event.srcElement && event.srcElement.tagName === "INPUT") {
        // 获取输入框元素
        let input = event.srcElement;
        // 获取输入框的值
        let newPrice = input.value;
        // 获取td节点
        let td = input.parentElement;
        // 将td节点的文本内容修改为新价格
        td.innerText = newPrice;
        updateXj(td.parentElement);
        updateAllXj();
    }
}

function updateAllXj() {
    // 获取table元素
    let table = $("tb1");
    // rows 获取tr集合
    const rows = table.rows;
    let sum = 0;
    for (let i = 1; i < rows.length - 1; i++) {
        let tr = rows[i];
        // 获取tr第四各文本内容
        let xj = parseInt(tr.cells[3].innerText);
        sum += xj;
    }
    rows[rows.length - 1].cells[1].innerText = sum + "";

}

function updateXj(tr) {
    if (tr && tr.tagName === "TR") {
        let tds = tr.cells;
        // innerText获取到的是字符串 需要使用转换parseInt为number类型
        let price = parseInt(tds[1].innerText);
        let count = parseInt(tds[2].innerText);
        tds[3].innerText = price * count + "";

    }
}

function showBGColor() {
    // if (a!==0){
    //     return;
    // }
    // // event 当前发生的事件
    // // event.srcElement:事件源
    // alert(window.event.srcElement);
    // alert(window.event.srcElement.tagName);
    // a++;
    if (event && event.srcElement && event.srcElement.tagName === "TD") {
        // 获取操作的元素 event.srcElement
        var td = event.srcElement;
        // 获取td的父级元素tr
        var tr = td.parentElement;
        // 更改其背景色
        tr.style.backgroundColor = 'orange';

        // 获取其父级元素

        // var div2 = div.parentElement;

    }
}

function recoverShow() {
    if (event && event.srcElement && event.srcElement.tagName === "TD") {
        var td = event.srcElement;
        var tr = td.parentElement;
        tr.style.backgroundColor = 'transparent';

    }
}