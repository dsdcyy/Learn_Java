public class InnerClassTest02 {
    public static void main(String[] args) {
        CallPhone callPhone = new CallPhone();
        callPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了...");
            }
        });
        callPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了...");
            }
        });
    }
}
interface Bell{
    void ring();
}

class CallPhone {
    public void alarmClock(Bell bell){
        bell.ring();
    }
}