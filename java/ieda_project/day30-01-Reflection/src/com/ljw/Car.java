package com.ljw;

/**
 * @author ljw
 * @version 1.0
 */
public class Car {
    public String color;
    private String name;
    private String description;
    public Car() {
    }
    public Car(String color, String name) {
        this.color = color;
        this.name = name;
    }
    public Car(String name){
        this.name = name;
    }
    private Car(String color, String name, String description){
        this.color = color;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
