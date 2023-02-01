import java.util.ArrayList;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class GenericExtends {
    public static void main(String[] args) {
        // 泛型不具备继承性
        // List<Object> list = new ArrayList<String>(); // F
        // <?> 支持任意泛型类型
        List<?> list2 = new ArrayList<String>();
        // <? extends A> 支持A类以及A类的子类，规定了泛型的上限
        List<? extends Object> list3 = new ArrayList<String>();
        // <? super A>：支持A类以及A类的父类，不限于直接父类，规定了泛型的下限
        List<? super String> list4 = new ArrayList<Object>();
    }
}
