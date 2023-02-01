public class CodeBlock01 {
    public static void main(String[] args) {
        Movie xyj = new Movie("西游记");
        Movie movie = new Movie("唐探3", 200, "陈思城");

    }
}

class Movie {
    private String name;
    private double price;
    private String director;

    // 不管调用哪个构造器实例化对象，都能执行下面的代码块
    {
        System.out.println("电影屏幕打开...");
        System.out.println("广告开始...");
        System.out.println("电影正式开始...");
    }

    // 构造器有相同的语句冗余
    public Movie(String name) {
//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影正式开始...");
        System.out.println("Movie(String name)被调用...");
        this.name = name;
    }

    public Movie(double price, String director) {

//        System.out.println("电影屏幕打开...");
//        System.out.println("广告开始...");
//        System.out.println("电影正式开始...");
        this.price = price;
        this.director = director;
    }

    public Movie(String name, double price, String director) {


        this(price, director);
        System.out.println("Movie(String name, double price, String director)被调用...");

        this.name = name;
    }
}