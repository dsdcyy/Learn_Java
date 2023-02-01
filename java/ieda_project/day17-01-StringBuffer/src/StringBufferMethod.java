/**
 * @author ljw
 * @version 1.0
 */
public class StringBufferMethod {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world");
        stringBuffer.append(",").append(true).append(10.5);
        // 增 append
        System.out.println(stringBuffer);
        //删 delete (start,end)
        stringBuffer.delete(1,5);
        System.out.println(stringBuffer);
        // 改 replace(start,end,string)//将start----end间的内容替换掉，不含end
        stringBuffer.replace(9,12,"周芷若");
        System.out.println(stringBuffer);
        // 查 indexOf//查找子串在字符串第1次出现的索引.如果找不到返回-1
        System.out.println(stringBuffer.indexOf("周芷若"));
        // 插 insert
        stringBuffer.insert(9, "赵敏");
        System.out.println(stringBuffer);
        // 获取长度length
        System.out.println(stringBuffer.length());


    }
}
