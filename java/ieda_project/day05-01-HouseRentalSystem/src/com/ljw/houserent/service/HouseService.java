package com.ljw.houserent.service;

import com.ljw.houserent.domain.House;

public class HouseService {
    private House[] houses; // 保存House对象
    private int houseCount = 1;

    public HouseService(int size) {
        houses = new House[size];
        houses[0] = new House(0, 2000, "Jack", "1897922233", "海淀区", "未出租");
    }

    // 返回houses信息
    public House[] list() {
        return houses;
    }

    // 添加房屋信息
    public boolean add(House house) {
        if (houseCount == houses.length) {
            House[] newHouses = new House[houses.length + 1];
            for (int i = 0; i < houses.length; i++) {
                newHouses[i] = houses[i];
            }
            newHouses[houses.length] = house;
            houses = newHouses;
            houseCount++;
            return true;
        }
        houses[houseCount++] = house;
        return true;
    }

    // 删除房屋信息
    public boolean delHouse(int delId) {
        int index = -1;
        for (int i = 0; i < houseCount; i++) {
            if (delId == houses[i].getId()) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("没有找到该房屋...");
            return false;
        }
        for (int i = index; i < houseCount; i++) {
            houses[i] = houses[i + 1];
        }
        // 把房屋信息的最后一个置空
        houses[--houseCount] = null;
        return true;
    }

    public House findById(int findId) {
        for (int i = 0; i < houseCount; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }
        return null;
    }
}
