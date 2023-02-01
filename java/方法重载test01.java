public class 方法重载test01 {
    public static void main(String[] args) {
        Methods methods = new Methods();
        System.out.println(methods.m(3));
        System.out.println(methods.m(3, 4));
        System.out.println(methods.m("Hello, world!"));
        System.out.println(methods.max(1, 3));
        System.out.println(methods.max(1.2, 0.8));
        System.out.println(methods.max(0.2, 0.8, 1.0));

    }
}

class Methods {
    public int m(int n) {
        return n * n;
    }

    public int m(int n, int m) {
        return n * m;
    }

    public String m(String s) {
        return s;
    }

    public int max(int n, int m) {
        return n > m ? n : m;
    }

    public double max(double n, double m) {
        return n > m ? n : m;
    }

    public double max(double n, double m, double o) {
        // 0.2, 0.3, 0.1
        double max1 = n > m ? n : m;
        return max1 > o ? max1 : o;
        // double max_val = n;
        // if (max_val < m) {
        // max_val = m;
        // }
        // if (max_val < o) {
        // max_val = o;
        // }
        // return max_val;
        // if(n>=m){
        // if(m>=o){
        // return n;
        // }else {
        // if(n>=o){
        // return n;
        // }else{
        // return o;
        // }
        // }
        // }else{
        // if(m<=o){
        // return o;
        // }else{
        // return m;
        // }
        // }
    }
}