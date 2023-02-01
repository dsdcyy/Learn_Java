package com.ljw.inherit;

public class Test03 {
    public static void main(String[] args) {
        Pc pc = new Pc("I9 13900K", "镁光6400", "PM981A", "联想");
        NotePad notePad = new NotePad("AMD 7950x", "海盗船3200", "三星980Pro", "白色");
        pc.getInfo();
        notePad.getInfo();
    }
}

class Computer {
    private String cpu;
    private String memory;
    private String disk;

    public Computer(String cpu, String memory, String disk) {
        setCpu(cpu);
        setMemory(memory);
        setDisk(disk);
    }

    public String getDetails() {
        return "电脑详细信息\nCpu: " + getCpu() + "\nMemory: " + getMemory() + "\nDisk: " + getDisk();
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }
}

class Pc extends Computer {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Pc(String cpu, String memory, String disk, String brand) {
        super(cpu, memory, disk);
        setBrand(brand);
    }

    public void getInfo() {
        System.out.println(getDetails() + "\nBrand: " + getBrand());
    }
}

class NotePad extends Computer {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public NotePad(String cpu, String memory, String disk, String color) {
        super(cpu, memory, disk);
        setColor(color);
    }

    public void getInfo() {
        System.out.println(getDetails() + "\nColor : " + getColor());
    }
}