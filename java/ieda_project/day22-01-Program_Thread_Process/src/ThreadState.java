/**
 * @author ljw
 * @version 1.0
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        State_ state = new State_();
        // new状态
        System.out.println(state.getName() + "状态: " + state.getState());
        state.start();
        while (Thread.State.TERMINATED != state.getState()){
            System.out.println(state.getName() + "状态: " + state.getState());
            // TIMED_WAITING
            Thread.sleep(500);
        }
        // TERMINATED 终止状态
        System.out.println(state.getName() + "状态: " + state.getState());

    }
}

class State_ extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i <10;i++){
                System.out.println("hi" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            break;
        }

    }
}