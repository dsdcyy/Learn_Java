package com.ljw.encapsulation;

public class Main {
    public static void main(String[] args) {
        // 封装介绍
        /*
         * 封装就是把抽象出的数据[属性]和对数据的操作[方法]封装在一起，数据被保护在内部，
         * 程序的其它部分只有通过被授权的操作[方法],才能对数据进行操作*/
        // 封装的理解和好处
        /*
         * 1.隐藏实现细节
         * 2.可以对数据进行验证，保证安全合理
         */
        // 封装实现步骤
        /*
         * 1.将属性进行私有化private [不能直接修改属性]
         * 2.提供一个公共的set方法，用于对属性判断并赋值
         * public void setXxx(类型 xxx){
         *   加入数据验证的业务逻辑
         *   属性 = 参数名;
         * }
         * 3.提供一个公共的get方法，用于获取属性的值
         * public void getXxx(类型 xxx){
         *   加入数据验证的业务逻辑
         *   return xx;
         * }
         */
        // 案例 ：要求见images/案例1.png
        Person person = new Person();
        // 设置名字属性
        person.setName("jack");
        // 设置年龄属性
        person.setAge(20);
        person.setSalary(10000);
        person.setJob("网络工程师");
        System.out.println(person.info("123456"));
        // 课后练习 Account.java 要求 images/课后联系.png
        Account account = new Account("tony", 10, "12345");
        System.out.println(account.info());
    }
}

class Person {
    public String name;
    private int age;
    private double salary;
    private String job;

    public Person(String name, int age, double salary, String job) {
        // 构造器内部通过方法调用实现数据验证
        setName(name);
        setAge(age);
        setSalary(salary);
        setJob(job);
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // str.length 获得字符串长度
        if (name.length() > 1 && name.length() < 7) {
            this.name = name;

        } else {
            System.out.println("名字信息不符合要求(2-6)");
            this.name = "null";

        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;

        } else {
            System.out.println("年龄信息不符合要求(1-120)");
            this.age = -1;
        }
    }

    public double getSalary(String password) {
        if ("123456".equals(password)) {

            return salary;
        } else {
            return -1;
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob(String password) {
        if ("123456".equals(password)) {

            return job;
        } else {
            return "请输入正确的密码进行查看！";
        }
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String info(String password) {
        // 正确输入密码才能获得对应salary和job的详细信息
        if ("123456".equals(password)) {
            return "详细信息\n姓名: " + this.name + "\n年龄: " + this.age + "\n薪水: " + this.salary + "\n职位: " + this.job;

        } else {
            return "详细信息\n姓名: " + this.name + "\n年龄: " + this.age + "\n薪水: " + this.getSalary(password) + "\n职位: " + this.getJob(password);

        }
    }
}
