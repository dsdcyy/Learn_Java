/**
 * @author ljw
 * @version 1.0
 */
public class TryCatchDetail02 {
    public static void main(String[] args) {
        try {
            Person person = new Person();
            person = null;
            System.out.println(person.getName()); // NullPointerException
            int n1 = 10;
            int n2 = 0;
            int res = n1 / n2; // div 0
            // 4.可以有多个catch语句，捕获不同的异常（进行不同的业务处理)，
            //        * 要求父类异常在后，子类异常在前，比如(Exception在后，
            //        * NullPointerException在前，如果发生异常，只会匹配一个catch
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e ) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
class Person {
    private String name;

    public String getName() {
        return name;
    }
}