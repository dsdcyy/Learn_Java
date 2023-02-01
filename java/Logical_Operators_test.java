public class Logical_Operators_test {
    public static void main(String[] args){
        int x = 5;
        System.out.println(x++==6);
        boolean a = true;
        boolean b = false;
        short c = 46;
        if((c++==46) && (b=true)){
            c++;
        }
        if((a=false) || (++c==49)){
            c++;
        }
        System.out.println(c);
    }
}
