public class Test05 {
    public static void main(String[] args) {
        Worker jack = new Worker("jack", 300);
        getSalary(jack);
        Teacher05 mary = new Teacher05("mary", 300, 100);
        getSalary(mary);
        Scientist tom = new Scientist("tom", 1000, 200000);
        getSalary(tom);

    }

    public static void getSalary(Emp05 emp) {
        if (emp instanceof Worker) {
            System.out.println(((Worker) emp).printSalary());
        } else if (emp instanceof Farmer) {
            System.out.println(((Farmer) emp).printSalary());
        } else if (emp instanceof Waiter) {
            System.out.println(((Waiter) emp).printSalary());
        } else if (emp instanceof Teacher05) {
            System.out.println(((Teacher05) emp).printSalary());
        } else if (emp instanceof Scientist) {
            System.out.println(((Scientist) emp).printSalary());
        } else {
            System.out.println("您传入的员工类无效...");
        }
    }
}

class Emp05 {
    String name;
    double basicWage;

    public Emp05(String name, double basicWage) {
        this.name = name;
        this.basicWage = basicWage;
    }

    public String printSalary() {
        return name + " 的年工资为: " + basicWage * 365;
    }
}

class Worker extends Emp05 {
    public Worker(String name, double basicWage) {
        super(name, basicWage);
    }

    @Override
    public String printSalary() {
        return "工人 " + super.printSalary();
    }
}

class Farmer extends Emp05 {
    public Farmer(String name, double basicWage) {
        super(name, basicWage);
    }

    @Override
    public String printSalary() {
        return "农名 " + super.printSalary();
    }
}

class Waiter extends Emp05 {
    public Waiter(String name, double basicWage) {
        super(name, basicWage);
    }

    @Override
    public String printSalary() {
        return "服务员 " + super.printSalary();
    }
}

class Teacher05 extends Emp05 {
    double remuneration;

    public Teacher05(String name, double basicWage, double remuneration) {
        super(name, basicWage);
        this.remuneration = remuneration;
    }

    @Override
    public String printSalary() {
        return "老师 " + name + "年工资为: " + (remuneration + basicWage) * 365;
    }
}

class Scientist
        extends Emp05 {
    double bonus;

    public Scientist(String name, double basicWage, double bonus) {
        super(name, basicWage);
        this.bonus = bonus;
    }

    @Override
    public String printSalary() {
        return "教授 " + name + "年工资为: " + (basicWage * 365 + bonus);
    }
}