/**
 * @author ljw
 * @version 1.0
 */
public class TesDecoratorDesignPattern {
    public static void main(String[] args) {
        BuffReader01 buffReader01 = new BuffReader01(new FileReader01());
        BuffReader01 buffReader02 = new BuffReader01(new StringReader01());
        buffReader01.read();
        buffReader02.read();

    }
}
