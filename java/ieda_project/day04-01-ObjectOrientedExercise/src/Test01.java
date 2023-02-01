public class Test01 {
    public static void main(String[] args) {
        Person[] peoples = new Person[3];
        peoples[0] = new Person("jack", 23, "teacher");
        peoples[1] = new Person("tom", 20, "student");
        peoples[2] = new Person("alice", 18, "farmers");
        for (int i = 0; i < peoples.length; i++) {
            for (int j = i + 1; j < peoples.length; j++) {
                if (peoples[i].age < peoples[j].age) {
                    Person tmp = peoples[i];
                    peoples[i] = peoples[j];
                    peoples[j] = tmp;


                }
            }
        }
        for (Person people : peoples) {
            System.out.println(people);
        }

    }
}

class Person {
    String name;
    int age;
    String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}