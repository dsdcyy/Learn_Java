import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author ljw
 * @version 1.0
 */
public class Main {
    private final static int row = 8; // 棋盘横坐标
    private final static int cos = 8; // 棋盘纵坐标
    private final static int[][] chessboard = new int[row][cos]; // 棋盘
    private static final boolean[] visited = new boolean[row * cos]; // 结果
    private static boolean finished = false; // 是否遍历完棋盘

    public static void main(String[] args) {

        /*
         * 算法优化意义
         * 1.算法是程序的灵魂，为什么有些程序可以在海量数据计算时，依然保持高速计算？
         * 2.拿老韩实际工作经历来说，在Unix下开发服务器程序，功能是要支持上千万人同时在线，
         * 在上线前，做内测，一切Ok,可上线后，服务器就支撑不住了，公司的CTO对代码进行优化，
         * 再次上线，坚如磐石。那一瞬间，你就能感受到程序是有灵魂的，就是算法。
         * 3.编程中算法很多，比如八大排序算法(冒泡、选择、插入、快排、归并、
         * 希尔、基数、堆排序)、查找算法、分治算法、动态规划算法、KMP算法、贪心算法、普里姆算法、
         * 迪杰斯特拉算法、弗洛伊德算法
         * 4.老韩以骑士周游问题为例，让小伙伴体验用算法去优化程序的意义，让大家直观的感受到算法的威力
         * */

        /*
        * 经典算法面试题-骑士周游问题
        * 马踏棋盘算法介绍和游戏演示
        * 1.马踏棋盘算法也被称为骑士周游问题
        * 2.将马随机放在国际象棋的8x8棋盘Board[0~7][0~7]的某个方格中，马按走棋规则(马走日字)进行移动。
        * 要求每个方格只进入一次，走遍棋盘上全部64个方格
        3.
        游戏演示https://u.ali213.net/games/horsesun/index.html?game code=403
        4.会使用到图的遍历算法（DFS)+贪心算法优化
        * */

        /*
         * 1.马踏棋盘问题（骑士周游问题）实际上是图的深度优先搜索(DFS)的应用。
         * 2.如果使用回溯（就是深度优先搜索）来解决，假如马儿踏了53个点，如图：走到了第53个，坐标（1,0），
         * 发现已经走到尽头，没办法，那就只能回退了，查看其他的路径就在棋盘上不停的回溯......，思路分析+代码实现
         * 3.先用基本方式来解决，然后使用贪心算法（greedyalgorithm）进行优化。解决马踏棋盘问题，体会到不同的算法对程序效率的影响
         * 4.使用前面的游戏来验证算法是否正确
         * */
        horseCollapseChessboard();
    }

    public static void horseCollapseChessboard() {
        /*
        * 骑士周游问题的解决步骤和思路分析
        * 1.创建棋盘chessBoard,是二维数组
        * 2.将当前位置设置为已经访问,然后根据当前位置，计算马儿还能走哪些位置，
        * 并放入到一个集合中(ArrayList),最多有8个，每走一步，使用step+1
        3.遍历ArrayList中存放的所有位置，看看那个可以走，如果可以走通，就继续，走不通，就回溯
        4.判断马儿是否完成了任务，使用step 和应该走的步数比较，如果没有达到数量，则表示没有完成任务，将整个棋盘设置为0
        注意：马儿走的策略不同，则得到的结果也不一样，效率也不一样.
        * */
        /*
        * 对代码使用贪心算法，进行优化，提高速度
        * 分析
        * 1.我们现在走的下一个位置，是按照我们的顺时针
        * 来挑选位置，因此选择的这个点的下一个可以走的
        * 位置的个数是不确定的
        * 2.优化思路是：我们应该选择下一个的下一个可以
        * 走的位置较少的点，开始走，这样可以减少回溯的次数
        * 3.代码：对我们的ps集合按照可以走的下一个位置
        的次数进行排序，升序排序
        * */
        long start = System.currentTimeMillis();
        travelChessboard(chessboard, 3, 3, 1);
        long end = System.currentTimeMillis();
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step + "\t");
            }
            System.out.println();
        }
        if (finished) {
            System.out.println("走通了...");
        } else {
            System.out.println("没走通...");
        }
        System.out.println("执行时间: " + (end - start));
    }

    // 将可以走的下个点加入到ArrayList<Point>集合中
    private static ArrayList<Point> next(Point curPoint) {
        // 创建一个可以走点的集合
        ArrayList<Point> points = new ArrayList<>();
        // 创建一个新的点对象
        Point point = new Point();
        // 判断这个对象的x-2,y-1的点是否落在棋盘上 5 x-2,y-1
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point((point)));
        }
        // 6 x-1,y-2
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point((point)));
        }
        // 7 x+1,y-2
        if ((point.x = curPoint.x + 1) < row && (point.y = curPoint.y - 2) >= 0) {
            points.add(new Point((point)));
        }
        // 0 x+2,y-1
        if ((point.x = curPoint.x + 2) < row && (point.y = curPoint.y - 1) >= 0) {
            points.add(new Point((point)));
        }
        //  4 x-2,y+1
        if ((point.x = curPoint.x - 2) >= 0 && (point.y = curPoint.y + 1) < cos) {
            points.add(new Point((point)));
        }
        // 3 x-1,y+2
        if ((point.x = curPoint.x - 1) >= 0 && (point.y = curPoint.y + 2) < cos) {
            points.add(new Point((point)));
        }
        // 2 x+1,y+2
        if ((point.x = curPoint.x + 1) < row && (point.y = curPoint.y + 2) < cos) {
            points.add(new Point((point)));
        }
        // 1 x+2,y+1
        if ((point.x = curPoint.x + 2) < row && (point.y = curPoint.y + 1) < cos) {
            points.add(new Point((point)));
        }
        return points;
    }

    private static void sortedPoints(ArrayList<Point> points) {
//        points.sort(new Comparator<Point>(
//
//        ) {
//            @Override
//            public int compare(Point o1, Point o2) {
//                return next(o1).size() - next(o2).size();
//            }
//        });
//        points.sort((o1, o2) -> next(o1).size() - next(o2).size());
        points.sort(Comparator.comparingInt(o->next(o).size()));
    }

    public static void travelChessboard(int[][] chessboard, int x, int y, int step) {
        // 将当前步数写入到给棋盘的当前位置
        chessboard[x][y] = step;
        // 将本点位置设置为已走过
        visited[y * row + x] = true;
        // 获取下个点的集合
        ArrayList<Point> ps = next(new Point(x, y));
        sortedPoints(ps);
        // 判断列表是否为空，不为空一直循环
        while (!ps.isEmpty()) {
            // 拿到下个点的对象
            Point cur_p = ps.remove(0);
            // 判断下个点是否被走过，没有走过则继续该过程,步数+1
            if (!visited[cur_p.y * row + cur_p.x]) {
                travelChessboard(chessboard, cur_p.x, cur_p.y, step + 1);
            }
        }
        // 当退出while循环，判断是否遍历成功 条件1 步数 < row*cos 条件2 finished未完成
        if (step < row * cos && !finished) {
            // 满足条件重置上述修改
            chessboard[x][y] = 0;
            visited[y * row + x] = false;
        } else {
            // 不满足条件，则完成
            finished = true;
        }

    }

}