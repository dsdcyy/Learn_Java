package com.ljw.polymorphism;

public class PloyParameter {
    public static void main(String[] args) {
        GeneralStaff zs = new GeneralStaff("张三", 3000);
        Manager ljw = new Manager("Ljw", 20000, 80000);
        System.out.println(showEmpAnnal(zs));
        System.out.println(showEmpAnnal(ljw));
        testWork(zs);
        testWork(ljw);

    }

    // 获取年工资
    public static double showEmpAnnal(Employee e) {
        return e.getAnnual();
    }

    // 判断员工所属工作类型
    public static void testWork(Employee e) {
        if (e instanceof GeneralStaff) {
            ((GeneralStaff) e).work();
        } else if (e instanceof Manager) {
            ((Manager) e).manager(); // 向下转型
        } else {
            System.out.println(e.getName() + "不是我们公司的员工...");
        }
    }
}

class Employee {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, double salary) {
        setName(name);
        setSalary(salary);
    }

    public double getAnnual() {
        return getSalary() * 12;
    }
}

class GeneralStaff extends Employee {
    public void work() {
        System.out.println("员工" + getName() + "正在努力工作...");
    }

    public GeneralStaff(String name, double salary) {
        super(name, salary);
    }

    public double getAnnual() {
        return super.getAnnual();
    }
}

class Manager extends Employee {
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        setBonus(bonus);
    }

    public void manager() {
        System.out.println("经理" + getName() + "管理着团队...");
    }

    public double getAnnual() {
        return super.getAnnual() + getBonus();
    }
}
