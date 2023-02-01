import java.util.Arrays;

/**
 * @author ljw
 * @version 1.0
 */
public class SystemMethod {
    public static void main(String[] args) {
        // exit 退出当前程序
        System.out.println("ok1");
        // 正常退出
//        System.exit(0);
        System.out.println("ok2");
        // arraycopy
        int[] array = {1, 2, 3, 4, 5};
        int[] arrayCopy = new int[array.length];
        // 源数组 原数组开始索引位置 目标数组 目标数组位置 拷贝数量
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        System.out.println(Arrays.toString(arrayCopy));
        // 3.currentTimeMillis：返回当前时间距离1970-1-1的毫秒数
        //
    }
}
