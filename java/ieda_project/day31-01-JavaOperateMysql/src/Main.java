import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * @author ljw
 * @version 1.0
 * 体会通过Java操作Mysql
 * 1.创建数据库goods db
 * 2.创建一个商品goods表，选用适当的数据类型
 * 3.添加2条数据
 * 4.删除表goods
 * 目的：体会通过Java发送SQL操作数据库、表
 */
public class Main {
    public static void main(String[] args) {
        // 1.CHARACTER SET:指定数据库采用的字符集，如果不指定字符集，默认utf8
        // 2.COLLATE:指定数据库字符集的校对规则（常用的utf8_bin[区分大小写］、
        // utf8_general_ci不区分大小写］注意默认是utf8_general_ci）[举例说明database.sql文件]
        // 备份数据库(终端执行)
        //mysqldump -u root -p -B hw > d:\\hw.sql
        //# 恢复数据库备份（MySql命令行执行）
        //source d:\\hw.sql
        // 备份恢复数据库的表
        // 备份库的表
        //mysqldump -u  用户名 -p 密码 数据库 表1 表2 表n >d:\\文件名.sql

        // 创建表
        /*
        * CREATE TABLE table name(
            field1 datatype,
            field2 datatype,
            field3 datatype,
        ) character set 字符集
            collate 校对规则
            engine 引擎
            field：指定列名
            datatype：指定列类型（字段类型)
            character set：如不指定则为所在数据库字符集
            collate：如不指定则为所在数据库校对规则
            engine :引擎(这个涉及内容较多，后面单独讲解)
        * */
        // 注意：创建表时，要根据需保存的数据创建相应的列，并根据数据的类型定义相应的列类型。
        // create tablet10(id tinyint）；//默认是有符号的
        //create table t11 (d tinyint unsigned）；// 无符号的
        // 1.基本使用
        // create table t05(
        //(num bit(8));
        //insert into t05(1,3):
        //insert into t05 values(2,65);
        /*
        * 细节说明
        bit.sql
        bit字段显示时，按照位的方式显示查询的时候仍然可以用使用添加的数值如果一个值只有0，
        * 1可以考使用bit(1），可以节约空间位类型。
        * M指定位数，默认值1，范围1-64使用不多。
        * */

        // 字符串的基本使用
        /*
        * CHAR(size)
        固定长度字符串最大255字符
        VARCHAR(size)
        可变长度字符串最大65532字节
        [utf8编码最大21844字符1-3个字节用于记录大小】
        * */
        // 表操作练习
        /*
        * ■员工表emp的上增加一个image列，varchar类型(要求在resume后面）。
        * ■修改job列，使其长度为60。
        * ■删除sex列。
        * ■表名改为employee，修改表的字符集为utf8
        * ■列名name修改为user_name
        * */
        /*
        * alter table emp add image varchar(255) not null ;
        * alter table emp modify job varchar(60) not null ;
        * alter table emp drop sex;
        * rename table emp to employee;
        * alter table employee charset utf8;
        * alter table employee change name  user_name varchar(255);
        * select * from employee;
        * */
        System.out.println("Hello world!");
        Haha haha = new Haha(){
            @Override
            public int get_integer(String s) {
                return Integer.parseInt(s);
            }
        };
        System.out.println(haha.get_integer("3"));
        Haha haha1 = s->{
            return Integer.parseInt(s);
        };
        Haha haha2 = Integer::parseInt;
        System.out.println(haha2.get_integer("34"));


    }
}
interface Haha{
    int get_integer(String s);
}