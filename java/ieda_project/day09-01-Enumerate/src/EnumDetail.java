/**
 * @author ljw
 * @version 1.0
 */
public class EnumDetail {
    public static void main(String[] args) {
        AA.CLASSICAL.playing();

    }
}
class A{

}

interface Music{
    void playing();
}

enum AA implements Music{
    CLASSICAL;

    @Override
    public void playing() {
        System.out.println("播放好听的音乐...");
    }
}