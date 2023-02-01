public class Main {
    public static void main(String[] args) {
        // 快捷键
        /*
        ctrl + d 重复当前行或选取区
        alt + / 快速填充代码
        ctrl + / 注释当前行或选区
        alt + enter 导入该行所需要的类 快速添加变量名 需要先配置auto import 设置，编辑器，常规，自动导入 勾选对应功能
        ctrl + alt +l 快速格式化代码
        需要设置 alt + r 运行代码 需要在按键映射里自定义run的快捷键
        alt + insert 生成构造器 提高开发效率 按住ctrl多选
        ctrl + h 查看类的层级关系
        ctrl + b | ctrl + 单击左键 可以快速定位到该方法
        new Scanner(System.in).var 快速分配变量名 同alt + enter
        */
        // 模板
        /*
        main+tab 快速输出main函数
        public static void main(String[] args) {}
        sout 快速输出打印方法
        System.out.println();
        fori 快速输出for循环
         for (int i = 0; i < ; i++) {

        }

        */
        SortingAlgorithm p1 = new SortingAlgorithm();
        int[] arr1 = {1, 3, 7, 3, 64, 32, 464, 32, 30, 44, 43, 5,10,6,3,6,7};
        p1.bubbleSort(arr1);
//        p1.selectionSort(arr1);

    }

}

class SortingAlgorithm {
    public void bubbleSort(int[] arr) {
        int temp = 0, flag = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag++;
                }
            }

        }
        // 增强for
        for (int j : arr) {
            System.out.print(j + "  ");
        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + "  ");
//        }
        System.out.println("共进行了" + flag + "次交换。");

    }

    public void selectionSort(int[] arr) {
        int flag = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[0]) {
                int temp = arr[i];
                arr[0] = arr[i];
                arr[i] = temp;
                flag++;

            } else {
                if (arr[i] < arr[i - 1]) {
                    for (int j = 0; j < i; j++) {
                        if (arr[j] > arr[i]) {
                            int temp = arr[j];
                            arr[j] = arr[i];
                            arr[i] = temp;
                            flag++;

                        }
                    }
                }
            }
        }
        for (int j : arr) {
            System.out.print(j + "  ");
        }
        System.out.println("共进行了" + flag + "次交换。");

    }
}
class Person{
    String name;
    int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}