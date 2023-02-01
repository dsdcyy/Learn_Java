public class EqualsTest01 {
    public static void main(String[] args) {
        Person p1 = new Person("小明", 30,'男');
        Person p2 = new Person("小红", 20,'女');
        Person p3 = new Person("小红", 20,'女');
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
    }
}

class Person {
    private String name;
    private int age;
    private char gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Person(String name, int age, char gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o instanceof Person) {
            Person p = (Person) o;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender;

        }
        return false;
    }
}