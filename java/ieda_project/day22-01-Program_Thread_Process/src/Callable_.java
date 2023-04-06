import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ljw
 * @version 1.0
 * 第三种创建线程方式 实现Callable接口
 */
public class Callable_ {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        // 将实现了Callable接口的对象传入FutureTask对象
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);
        // 最后将FutureTask对象给Thread对象并启动
        new Thread(futureTask).start();
        try {
            // FutureTask.get对象用于获得call方法的返回值
            System.out.println(futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}

class NumThread implements Callable<Integer> {
    // 实现call方法，有返回值
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}