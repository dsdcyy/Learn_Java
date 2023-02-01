import java.util.Scanner;

/**
 * @author ljw
 * @version 1.0
 */
public class HomeWork08 {
    public static void main(String[] args) {
        Color color = Color.GREEN;
        switch (color){
            case RED:
                System.out.println("红色");
                Color.RED.show();
                break;
            case BLUE:
                System.out.println("蓝色");
                Color.BLUE.show();
                break;
            case GREEN:
                System.out.println("绿色");
                Color.GREEN.show();
                break;
        }


    }
}
enum Color implements Test {
    RED(255,0,0),
    BLUE(0,0,255),
    Black(0,0,0),
    YELLOW(255,255,0),
    GREEN(0,255,0);
    private int readValue;
    private int greenValue;
    private int blueValue;

    public int getReadValue() {
        return readValue;
    }

    public void setReadValue(int readValue) {
        this.readValue = readValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public void setGreenValue(int greenValue) {
        this.greenValue = greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }

    public void setBlueValue(int blueValue) {
        this.blueValue = blueValue;
    }

    Color(int readValue, int greenValue, int blueValue) {
       setBlueValue(blueValue);
       setGreenValue(greenValue);
       setReadValue(readValue);
    }

    @java.lang.Override
    public void show() {
        System.out.println("readValue: " + readValue + " greenValue: " + greenValue + " blueValue: " + blueValue);
    }
}

interface Test {
    void show();
}
