package com.ljw.houserent.view;

import com.ljw.houserent.domain.House;
import com.ljw.houserent.service.HouseService;
import com.ljw.houserent.utils.Utility;

import java.util.Scanner;

/*
 * 1.显示界面
 * 2.接收用户输入
 * 3.调用HouseService完成对房屋信息的各种操作
 */
public class HouseView {
    private boolean loop = true;
    private int id = 1;
    private final HouseService houseService = new HouseService(1);

    private void listHouse() {
        System.out.println("----------------房屋列表------------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] list = houseService.list();
        for (House house : list) {
            if (house == null) {
                continue;
            }
            System.out.println(house);
        }
    }

    private void addHouse() {
        System.out.println("----------------添加房屋------------------");
        System.out.print("姓名: ");
        String name = Utility.readString(8);
        System.out.print("电话: ");
        String phone = Utility.readString(11);
        System.out.print("地址: ");
        String address = Utility.readString(50);
        System.out.print("月租: ");
        int rent = Utility.readInt();
        System.out.print("状态: ");
        String state = Utility.readString(3);
        House house = new House(id++, rent, name, phone, address, state);
        if (houseService.add(house)) {
            System.out.println("----------------添加房屋成功------------------");
        } else {
            System.out.println("----------------添加房屋失败------------------");

        }

    }

    private void deleteHouse() {
        System.out.println("----------------删除房屋信息------------------");
        System.out.println("请输入待删除房屋的编号(-1退出删除)");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("----------------放弃删除房屋信息------------------");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.delHouse(delId)) {
                System.out.println("删除成功...");
                id--;
            } else {
                System.out.println("删除失败...");
            }
        } else {
            System.out.println("----------------放弃删除房屋信息------------------");

        }
    }

    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }

    public void findHouse() {
        System.out.println("----------------查找房屋信息------------------");
        System.out.println("请输入查找房屋的id:");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house == null) {
            System.out.println("未查找到该id所对应的房屋信息");
            return;
        }
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        System.out.println(house);
    }

    public void update() {
        System.out.println("----------------修改房屋信息------------------");
        System.out.println("请输入待修改的房屋id(-1退出)");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("----------------你放弃了修改房屋信息------------------");
            return;
        }
        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("----------------该id所对应的房屋信息不存在------------------");
            return;
        }
//        "++" ++内可以写变量名
        System.out.print("姓名(" + house.getName() + ")：");
        String name = Utility.readString(8, house.getName());
        house.setName(name);
        System.out.print("电话(" + house.getPhone() + ")：");
        String phone = Utility.readString(11, house.getPhone());
        house.setPhone(phone);
        System.out.print("地址(" + house.getAddress() + ")：");
        String address = Utility.readString(50, house.getAddress());
        house.setAddress(address);
        System.out.print("月租(" + house.getRent() + ")：");
        int rent = Utility.readInt(house.getRent());
        house.setRent(rent);
        System.out.print("状态(" + house.getState() + ")：");
        String state = Utility.readString(3, house.getState());
        house.setState(state);
        System.out.println("----------------信息修改成功------------------");
    }

    public void mean() {
        String limiter = "\t\t\t\t";
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----------------房屋出租系统------------------");
            System.out.println(limiter + "1 新增房源");
            System.out.println(limiter + "2 查找房屋");
            System.out.println(limiter + "3 删除房屋");
            System.out.println(limiter + "4 修改房屋信息");
            System.out.println(limiter + "5 房屋列表");
            System.out.println(limiter + "6 退出");
            System.out.print("请选择功能(1-6): ");
            char key = scanner.next().charAt(0);
            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    deleteHouse();
                    System.out.println(limiter + "删除房屋");
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
                default:
                    System.out.println("选择的功能不存在！");
            }
        } while (loop);

//        int choice =  scanner.nextInt();
//        switch (choice){
//            case 1:
//
//        }
    }
}
