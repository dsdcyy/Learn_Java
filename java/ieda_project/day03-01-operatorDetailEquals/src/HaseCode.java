public class HaseCode {
    public static void main(String[] args) {
        AA aa = new AA();
        AA bb = new AA();
        AA cc = aa;
        // 不同对象hashcode值不一样
        System.out.println("aa.hashCode()= " + aa.hashCode());
        System.out.println("bb.hashCode()= " + bb.hashCode());
        System.out.println("cc.hashCode()= " + cc.hashCode());

    }
}

class AA {

}