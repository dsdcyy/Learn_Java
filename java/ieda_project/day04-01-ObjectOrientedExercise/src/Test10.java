public class Test10 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("jack", "driver", 23, '男', 10000);
        Doctor doctor2 = new Doctor("jack", "driver", 23, '男', 20000);
        System.out.println(doctor.equals(doctor2));
    }
}

class Doctor {
    private String name, job;
    private int age;
    private char gender;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Doctor(String name, String job, int age, char gender, double salary) {
        setName(name);
        setAge(age);
        setJob(job);
        setGender(gender);
        setSalary(salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Doctor)) {
            return false;
        }
        // 向下转型
        Doctor doctor = (Doctor) obj;
        return this.name.equals(doctor.name) && this.age == doctor.age && this.salary == doctor.salary
                && this.job.equals(doctor.job) && this.gender == doctor.gender;
    }
}