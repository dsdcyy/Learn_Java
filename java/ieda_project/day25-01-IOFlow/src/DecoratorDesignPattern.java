import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ljw
 * @version 1.0
 * 模拟修饰器设计模式
 */
public abstract class DecoratorDesignPattern {
    public  abstract void read();

}

class FileReader01 extends DecoratorDesignPattern {
    @Override
    public void read() {
        System.out.println("读取文件...");
    }

}

class StringReader01 extends DecoratorDesignPattern {
    @Override
    public void read() {
        System.out.println("读取字符串...");
    }
}

// 处理流
class BuffReader01 extends DecoratorDesignPattern {
    private DecoratorDesignPattern reader_; //

    public BuffReader01(DecoratorDesignPattern reader_) {
        this.reader_ = reader_;
    }

    public DecoratorDesignPattern getReader_() {
        return reader_;
    }

    public void setReader_(DecoratorDesignPattern reader_) {
        this.reader_ = reader_;
    }
    // 多次处理

    @Override
    public void read() {
        reader_.read();
    }
}