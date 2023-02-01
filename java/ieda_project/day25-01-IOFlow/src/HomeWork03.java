import java.io.*;
import java.util.Properties;

/**
 * @author ljw
 * @version 1.0
 * （1）要编写一个dog.properties
 * age=5
 * name=tom
 * color=red
 * （2)编写Dog类（name,age,color)
 * 创建一个dog对象，读取dog.properties用相应的内容完成属性初始化，并输出
 * （3）将dog序列化
 */
public class HomeWork03 {
    public static void main(String[] args) throws IOException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/dog.properties";
        Properties properties = new Properties();
        properties.setProperty("age","5");
        properties.setProperty("name","tom");
        properties.setProperty("color","red");
        properties.store(new FileWriter(file),"Dog class");
        properties.load(new FileReader(file));
        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");
        Dog03 dog = new Dog03(name, age, color);
        System.out.println(dog);
        file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/dog.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(dog);
        oos.close();
    }
}

class Dog03 implements Serializable{
    private String name;
    private int age;
    private String color;
    private static final long serialVersionUID = 1L;

    public Dog03(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog03{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}