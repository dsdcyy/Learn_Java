import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ljw
 * @version 1.0
 */
public class HashSetIncrement {
    public static void main(String[] args) {
        HashSet<A> hashSet = new HashSet<>();
        for (int i = 1; i < 13; i++) {
            hashSet.add(new A(i));
        }
    }
}
class A {
    int value;

    public A(int value) {
        this.value = value;
    }
    // 重写hashCode()方法，让计算的值为一个固定的值，此时会在table的固定形成链表
    @Override
    public int hashCode() {
        return 100;
    }
}