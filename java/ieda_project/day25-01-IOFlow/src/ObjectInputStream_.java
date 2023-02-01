import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author ljw
 * @version 1.0
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "/home/Ljw/Desktop/java/ieda_project/day25-01-IOFlow/src/data.dat";
        // 实例化ObjectInputStream对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        // 读取
        /*
        * 1.读取(反序列化)的顺序需要和保存数据(序列化)数据时一致
        * 2.否则会异常
        * */
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object o = ois.readObject();
        System.out.println(o.getClass());
        ois.close();
    }
}
