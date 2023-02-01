public class Test13 {
    public static void main(String[] args) {
        Person13[] people13s = new Person13[4];
        people13s[0] = new Student13_2("王飞", '男', 20, 1);
        people13s[1] = new Student13_2("小明", '男', 20, 2);
        people13s[2] = new Teacher13_2("小红", '女', 25, 2);
        people13s[3] = new Teacher13_2("小丽", '女', 24, 1);
        for (int i = 0; i < people13s.length; i++) {
            for (int j = i + 1; j < people13s.length; j++) {
                if (people13s[i].getAge() < people13s[j].getAge()) {
                    Person13 tmp = people13s[i];
                    people13s[i] = people13s[j];
                    people13s[j] = tmp;
                }
            }
        }
        for (Person13 people13 : people13s) {
            info(people13);
        }


    }

    public static void info(Person13 person) {
        if (person instanceof Student13_2) {
            System.out.println((Student13_2) person);
        } else if (person instanceof Teacher13_2) {
            System.out.println((Teacher13_2) person);
        }
    }
}

class Student13 {
    private String name;
    private char sex;
    private int age, stu_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public Student13(String name, char sex, int age, int stu_id) {
        setName(name);
        setAge(age);
        setSex(sex);
        setStu_id(stu_id);
    }
}

class Teacher13 {
    private String name;
    private char sex;
    private int age, work_age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public Teacher13(String name, char sex, int age, int work_age) {
        setName(name);
        setAge(age);
        setSex(sex);
        setWork_age(work_age);
    }
}

class Person13 {
    private String name;
    private char sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person13(String name, char sex, int age) {
        setName(name);
        setAge(age);
        setSex(sex);
    }

    public String play() {
        return name + "爱玩";
    }

    @Override
    public String toString() {
        return "\n姓名: " + getName() + "\n年龄; " + getAge() + "\n性别: " + getSex();
    }
}

class Student13_2 extends Person13 {
    private int stu_id;

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public Student13_2(String name, char sex, int age, int stu_id) {
        super(name, sex, age);
        setStu_id(stu_id);
    }

    public String study() {
        return "我承诺，我会好好学习";
    }

    public String play() {
        return super.play() + "足球...";
    }

    @Override
    public String toString() {
        return "学生信息" + super.toString() + "\n学号 :" + stu_id + "\n" +
                study() + "\n" + play() + "\n" + "------------------------";
    }
}

class Teacher13_2 extends Person13 {
    private int work_age;

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public Teacher13_2(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        setWork_age(work_age);
    }

    public String teach() {
        return "我承诺，我会认真教学";
    }

    public String play() {
        return super.play() + "象棋...";
    }

    @Override
    public String toString() {
        return "老师信息" + super.toString() + "\n工龄 :" + work_age + "\n" +
                teach() + "\n" + play() + "\n" + "------------------------";

    }
}