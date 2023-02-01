/**
 * @author ljw
 * @version 1.0
 */
public class CpuNumber {
    public static void main(String[] args) {
        // 获取Runtime对象
        Runtime runtime = Runtime.getRuntime();
        // 获取可用cpu数量
        int cpuNums = runtime.availableProcessors();
        System.out.println("cpuNums: " + cpuNums);
    }
}
