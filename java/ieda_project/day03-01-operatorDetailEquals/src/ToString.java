public class ToString {
    public static void main(String[] args) {
        // toString 源码
        /*
        public String toString() {
            return this.getClass().getName() + "@" + Integer.toHexString(this.hashCode());
        }
    */

        Monster monster = new Monster("小妖怪", "巡山", 2000);
        System.out.println(monster.toString());
        // 输出对象默认会调用toString方法
        System.out.println(monster);

    }
}
class Monster {
    private String name;
    private String job;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Monster(String name, String job, double salary) {
        setName(name);
        setJob(job);
        setSalary(salary);
    }
    // 重写toString方法
    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}