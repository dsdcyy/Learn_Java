import java.util.Random;

// 递归重要规则
/*
 * 1.执行一个方法时就创建一个新的受保护的独立空间(栈空间)
 * 2.方法的局部变量是独立的，不会受影响
 * 3.如果方法中使用的是引用类型变量，则会共享该引用类型的数据
 * 4.递归必须向退出的递归条件逼近，否则就是无限递归，出现StackOverflowError
 * 5.当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用就将结果返回给谁，同时方法执行结束获取返回时，该方法也就执行完毕了
 */

public class 方法递归调用 {
    public static void main(String[] args) {
        Recursion fbnq = new Recursion();
        // for (int i = 0; i < 10; i++) {
        // int res = fbnq.fbnq(i);
        // System.out.print(res + "\t");
        // }
        // System.out.print(fbnq.sum(100) + "\t");
        // fbnq.test(4);
        // System.out.print(fbnq.factorial(5) + "\t");
        // System.out.print(fbnq.monkey_eating_peach(15) + "\t");
        // fbnq.ball_out_of_the_maze();
        // 迷宫问题
        int row = 8;
        int col = 7;
        int[][] maze = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == 0 || j == 0 || i == row - 1 || j == col - 1) {
                    maze[i][j] = 1;
                }
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();

        }
        maze[4][1] = 1;
        maze[1][4] = 1;
        maze[3][2] = 1;
        fbnq.map(maze, 1, 1);

        System.out.println("-------选路后的结果-------");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + "  ");
            }
            System.out.println();

        }
        // 汉诺塔问题
        fbnq.move(2, 'A', 'B', 'C');
    }
}

class Recursion {
    // 菲波那挈问题
    public int fbnq(int n) {
        if (n < 2) {
            return n;
        } else {
            return fbnq(n - 1) + fbnq(n - 2);
        }
    }

    // 求和
    public int sum(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        } else {
            return sum(n - 1) + n;
        }
    }

    public void test(int n) {
        if (n > 2) {
            test(n - 1);

        }
        System.out.print("n=" + n + "\t");
    }

    // 阶乘计算
    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    // 猴子吃桃问题
    public int monkey_eating_peach(int n) {
        if (n == 1) {
            return n;
        } else {
            if (n > 0) {
                return (monkey_eating_peach(n - 1) + 1) * 2;
            } else {
                return -1;
            }
        }
    }

    // 老鼠出迷宫问题
    // 0表示可以走 1表示障碍物 2 表示走过 3 表示 走过是死路
    // 当map[6][5] = 2 就说明找到通路
    public Boolean map(int[][] ma, int i, int j) {
        // 即出口位置为2时探测成功
        if (ma[ma.length - 2][ma[ma.length - 2].length - 2] == 2) {
            return true;
        } else {
            // 判断老鼠所在坐标是否为0，如果是将坐标设为2
            if (ma[i][j] == 0) {
                ma[i][j] = 2;
                // 进行四个方向的探测，设置好探测点为2
                if (map(ma, i, j + 1)) {
                    return true;
                } else if (map(ma, i + 1, j)) {
                    return true;
                } else if (map(ma, i, j - 1)) {
                    return true;
                } else if (map(ma, i - 1, j)) {
                    return true;
                    // 四个方向均无法通过时将本点设置为3
                } else {
                    ma[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    // 汉诺塔问题
    // num表示移动的个数 a,b,c 代表A，B，C塔
    public void move(int num, char a, char b, char c) {
        // 只有一个盘时，直接输出a盘移动到c盘
        if (num == 1) {
            System.out.println(a + " ---> " + c);
        } else {
            // 如果有多个盘，则最下面的为一个盘，其余的当作一个盘
            // 移动a除底部的一个盘，将上面所有的盘移动到c借助于b
            move(num - 1, a, c, b);
            // 移动a底部的一个盘，移动到c
            System.out.println(a + " ---> " + c);
            // 再把b塔上的所有盘移动到c，借助a
            move(num - 1, b, a, c);

        }
    }

}