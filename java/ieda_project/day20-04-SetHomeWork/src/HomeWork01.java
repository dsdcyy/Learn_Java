import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork01 {
    /*按要求实现：
    （1）封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString方法，打印对象
    时只打印标题；
    ·（2）只提供一个带参数的构造器，实例化对象时，只初始化标题；并且实例化两个对象
    新闻一：新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧
    新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生
    （3）将新闻对象添加到ArrayList集合中，并且进行倒序遍历；
    （4）在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前15个，然后在后边加"..."
    （5）在控制台打印遍历出经过处理的新闻标题
    */
    public static void main(String[] args) {
        List<News> list = new ArrayList<>();
        list.add(new News("新闻一：新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧"));
        list.add(new News("新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));
        list.add(new News("新闻一：新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧"));
        list.add(new News("新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));
        list.add(new News("新闻二：男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));
        reverse(list);
        for (int i = list.size()-1; i >= 0; i--){
            News news = list.get(i);
            if (news.getTitle() != null && news.getTitle().length() > 15){
                news.setTitle(news.getTitle().substring(0, 15) + "...");
            }
            System.out.println(news);
        }
        System.out.println(list);

    }

    public static void reverse(List<News> list) {
        for (int i = 0; i < list.size() >> 1; i++) {
            News news = list.get(i);
            News news2 = list.get(list.size() - 1 - i);
            list.set(i, news2);
            list.set(list.size() - 1 - i, news);
        }
    }
    public static ArrayList<Object> reverse2(List<Object> list) {
        ArrayList<Object> new_list = new ArrayList<>();
        int lastIndex = list.size() - 1;
        for (int i = lastIndex; i >= 0; i--) {
            new_list.add(list.get(i));
        }
        return new_list;
    }
}

class News {
    String title;
    String content;

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}' + "\n";
    }
}