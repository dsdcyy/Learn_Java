public class TemplateDesignPattern {
    public static void main(String[] args) {
        AA aa = new AA();
        aa.calculateTime(1000000);
        BB bb = new BB();
        bb.calculateTime(1000000);
    }

}

abstract class Template {
    public void calculateTime(long n) {
        // System.currentTimeMillis() 获取当前时间
        long start = System.currentTimeMillis();
        job(n);
        long end = System.currentTimeMillis();
        System.out.println("执行时间: " + (end - start) + "毫秒!");
    }

    abstract public void job(long n);
}

class AA extends Template {
    public void job(long n) {
        long num = 0;
        for (int i = 0; i < n; i++) {
            num += i;
        }
    }
}

class BB extends Template {
    public void job(long n) {
        long num = 0;
        for (int i = 0; i < n; i++) {
            num += i;
        }
    }
}
