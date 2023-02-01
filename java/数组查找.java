import java.util.Scanner;

public class 数组查找 {
    public static void main(String[] args) {
        String[] name = { "白眉鹰王", "金毛狮王", "紫衫龙王", "青翼福王" };
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入名字");
        String find_name = scanner.next();
        Boolean is_find = false;
        for (int i = 0; i < name.length; i++) {
            if (name[i].equals(find_name)) {
                System.out.println("恭喜你找到了:" + find_name);
                System.out.println("下标为:" + i);
                is_find = true;
                break;
            }
        }
        if (!is_find) {
            System.out.println("没有找到");
        }
    }
}
