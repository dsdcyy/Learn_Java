import java.util.concurrent.*;

/**
 * @author ljw
 * @version 1.0
 * 创建线程池的方式四：使用线程池
 */
public class Thread_Pool_ {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Executors.newFixedThreadPool
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        // 实现类进行属性设置
        ThreadPoolExecutor executorService2 = (ThreadPoolExecutor) executorService;
        // 线程池数量
        executorService2.setCorePoolSize(6);
        FutureTask<Integer> integerFutureTask = new FutureTask<>(new NumThread2()); //Runnable
        executorService.execute(integerFutureTask);
        FutureTask<Integer> integerFutureTask2 = new FutureTask<>(new NumThread2());
        Future<?> submit = executorService.submit(integerFutureTask2);// Callable
        Object o = submit.get();
        System.out.println(o);
        // 结束线程
        executorService.shutdown();
    }
}

class NumThread2 implements Callable<Integer> {
    // 实现call方法，有返回值
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 101; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        // pool-1-thread-1
        System.out.println(Thread.currentThread().getName() + "执行结束了...");
        return sum;
    }
}