import java.io.*;

/**
 * @author ljw
 * @version 1.0
 */
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/data.dat";
        // 实例化ObjectOutputStream对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        // 序列化数据
        oos.writeInt(100); // int --->integer(实现了Serializable)
        oos.writeBoolean(true); // boolean --->Boolean(实现了Serializable)
        oos.writeChar('a'); // char --->Character(实现了Serializable)
        oos.writeDouble(1.0); // double --->Double(实现了Serializable)
        oos.writeUTF("ljw"); // String(实现了Serializable)
        // 保存Dog对象
        oos.writeObject(new Dog("旺财",5,"黑色"));
        oos.close();
        System.out.println("序列化保存成功...");
    }
}

// 如果需要序列化某个对象需要实现Serializable接口
class Dog implements Serializable {
    String name;
    int age;
    // serialVersionUID 序列化的版本号，可以提高兼容性
    private static final long serialVersionUID = 1L;
    // static或transient修饰的成员不会被序列化
    transient String Color;
    static String natural;
    
    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        Color = color;
    }
}