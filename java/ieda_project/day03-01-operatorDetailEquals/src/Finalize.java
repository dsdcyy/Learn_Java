public class Finalize {
    public static void main(String[] args) {
        Car bm = new Car("宝马");
        // 将指向自空，新建的对象会被垃圾回收器回收
        bm = null;
//        System.gc(); // 主动调用垃圾回收器
        System.out.println("程序退出了...");
    }
}
class Car{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(String name) {
        setName(name);
    }

//    @Override
//    protected void finalize() throws Throwable {
////        super.finalize();
//        System.out.println("我们销毁了汽车 "+getName());
//    }
}