public class Test04 {
    public static void main(String[] args) {
        Manger manger = new Manger("校长", 400, 18);
        GeneralStaff xiaobai = new GeneralStaff("小白", 300, 22);
        manger.printSalary();
        xiaobai.printSalary();


    }
}

class Emp {
    String name;
    double dailyWages;
    double workDays;

    public Emp(String name, double dailyWages, double workDays) {
        this.name = name;
        this.dailyWages = dailyWages;
        this.workDays = workDays;
    }

    public void printSalary() {
        System.out.println("员工 " + name + " 工作了" + workDays + "天，应发工资 " + workDays * dailyWages);
    }
}

class Manger extends Emp {
    public Manger(String name, double dailyWages, double workDays) {
        super(name, dailyWages, workDays);
    }

    @Override
    public void printSalary() {
        System.out.println("经理 " + name + " 工作了" + workDays + "天，应发工资 " + (1000 + workDays * dailyWages * 1.2));

    }
}

class GeneralStaff extends Emp {
    public GeneralStaff(String name, double dailyWages, double workDays) {
        super(name, dailyWages, workDays);
    }

}