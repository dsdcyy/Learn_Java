public class for_test {
    public static void main(String args[]) {
        int s = 0;
        int i;
    
        for (i = 0; i < 1000000; i = i + 1)
            s += i;
        System.out.println(s);   
      }
      
}
