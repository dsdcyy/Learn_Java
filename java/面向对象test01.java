public class 面向对象test01 {
    public static void main(String[] args) {
        AA a = new AA();
        Boolean res = a.isOdd(14);
        if (res) {
            System.out.println("是奇数");
        } else {
            System.out.println("是偶数");

        }
        a.print(5, 5,'*');
    }
}

class AA {
    public Boolean isOdd(int n) {

        return n % 2 != 0;
    }

    public void print(int row, int column,char c) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}