package com.ljw.polymorphism;

public class Main {
    public static void main(String[] args) {
        // 多态

        // 引出问题 LeadToProblemsPoly.java
        // 代码复用性不高，且不利于代码维护

        // 基本介绍
        //方法或对象具有多种形态，是面向对象的第三大特征，多态是建立在封装和继承基础之上的。

        // 具体表现
        /*
        * 1.方法的多态  案例 PloyMethod.java
        * 重写和重载就体现多态
        * 2.对象的多态
        * （1）一个对象的编译类型和运行类型可以不一致
        *  (2）编译类型在定义对象时，就确定了不能被改变
        *  (3) 运行类型是可以变化的
        *  (4) 编译类型看定义时 =号 的 左边，运行类型看 =号 的 右边
        *  案例 PolyObject.java
        * */

        // 解决前面引出的问题 LeadToProblemsPoly.java
        // 多态解决方法 给什么动物喂什么食物
        // Animal编译类型可以指向Animal不同子类的对象，Food同理
        /*
            public void feed(Animal animal, Food food) {
            System.out.println("主人" + getName() + "正在给" + animal.getName() + "吃" + food.getName());
        }*/

        // 多态注意事项和细节讨论 PolyDetail.java
        // 多态的前提是:两个对象(类)存在继承关系

        // 多态的向上转型
        /*
        * 1.本质：父类的引用指向了子类的对象
        * 2.语法：父类类型 引用名 = new 子类类型();
        * 3.特点：编译类型看左边，运行类型看右边。
        * 可以调用父类中的所有成员(需遵守访问权限),能够调用哪些成员由编译类型决定
        * 不能调用子类中的特有成员,
        * 最终运行效果看子类的具体实现
        * */

        // 多态的向下转型
        /*
        * 1.语法 子类类型 引用名 = (子类类型) 父类引用
        * 2.只能强转父类的引用，不能强转父类的对象
        * 3.要求父类的引用类型必须指向的是当前目标类型的对象
        * 4.当向下转型后，可以调用子类类型中的所有成员
        * */

        //属性没有重写之说！属性的值看编译类型,方法看运行类型
        // instanceOf 比较操作符，用于判断对象的运行类型是否为xx类型或xx类型的子类型

        //java的动态绑定机制  //DynamicBinding.java
        /*
        * 1.当调用对象的方法时候，该方法会和该对象的内存地址/运行类型绑定
        * 2.当调用对象属性时，没有动态绑定机制，哪里声明，哪里使用
        * */

        // 多态的应用 PloyArray.java
        // 1.多态数组
        // 数组的定义类型为父类类型，里面保存的实际元素为子类类型
        // 2.多态参数 示例1 LeadToProblemsPoly.java 示例2 PloyParameter.java
        // 方法定义的形参为父类类型，实参类型允许为子类类型
    }
}
