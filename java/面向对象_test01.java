public class 面向对象_test01 {
    public static void main(String[] args) {
        // 1
        double[] arr = { 1.1, 2.3, 1.5, 6, 4.2, 0.8 };
        A01 a = new A01();
        Double max_value = a.max(arr);
        if (max_value != null) {
            System.out.println(max_value);
        } else {
            System.out.println("传入的是空数组，并没有最大值！");

        }

        // 2
        String[] str_arr = { "hw", "hello", "world", "haha" };

        System.out.println(a.find(str_arr, "haha"));

        // 3
        Book book = new Book(130);
        book.updatePrice();
        System.out.println(book.price);

        // 4
        double[] new_arr = a.copyArr(arr);
        for (int i = 0; i < new_arr.length; i++) {
            System.out.print(new_arr[i] + "\t");
        }
        // 5
        Circle c = new Circle(5);
        System.out.println("\n周长为: " + c.getPerimeter());
        System.out.println("面积为: " + c.getArea());
        // 6
        Cale cale = new Cale(6, 10);
        System.out.println("加: " + cale.sum());
        System.out.println("减: " + cale.sub());
        System.out.println("乘: " + cale.take());
        if(cale.div() != null){
            System.out.println("除: " + cale.div());
        }


    }
}

class A01 {
    // 1.返回数组最大值
    public Double max(double[] arr) {
        if (arr != null && arr.length > 0) {
            double max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        } else {
            return null;
        }

    }

    // 2. 查询一个字符串是否存在于一个数组，存在返回下标，不存在返回-1
    public int find(String[] arr, String name) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (name.equals(arr[i])) {
                System.out.println("找到了，索引为" + i);
                return i;
            }
        }
        if (index == -1) {
            System.out.println("没有找到" + name);

        }
        return index;
    }

    // 4.传入一个数组返回一个和传入数组元素一致的新数组
    public double[] copyArr(double[] arr) {
        double[] new_arr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[i];
        }
        return new_arr;
    }
}

class Book {
    double price;

    public Book(double price) {
        this.price = price;
    }

    // 3.更新书本价格，大于150价格为150,大于100为100
    public void updatePrice() {
        if (price > 150) {
            price = 150;
        } else if (price > 100) {
            price = 100;
        }
    }

}

// 5. 求圆面积和周长
class Circle {
    double redius;

    public Circle(double redius) {
        this.redius = redius;
    }

    public double getPerimeter() {
        return redius * 2 * Math.PI;
    }

    public double getArea() {
        return redius * redius * Math.PI;
    }
}

// 6.定义两个操作数，进行加减乘除，如果除数为0,给出提示
class Cale {
    double n;
    double m;

    public Cale(double n, double m) {
        this.n = n;
        this.m = m;
    }

    public double sum() {
        return n + m;
    }

    public double sub() {
        return n - m;
    }

    public double take() {
        return n * m;
    }

    public Double div() {
        if (m == 0) {
            System.out.println("除数不能为0！");
            return null;
        }
        return n / m;
    }
}