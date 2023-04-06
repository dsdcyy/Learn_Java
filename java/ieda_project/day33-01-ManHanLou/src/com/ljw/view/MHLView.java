package com.ljw.view;


import com.ljw.domain.*;
import com.ljw.service.BillService;
import com.ljw.service.DiningTableService;
import com.ljw.service.EmployeeService;
import com.ljw.service.MenuService;
import com.ljw.utils.Utility;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author ljw
 * @version 1.0
 */
public class MHLView {
    private boolean loop = true;
    private final EmployeeService employeeService = new EmployeeService();

    private final DiningTableService diningTableService = new DiningTableService();

    private final MenuService menuService = new MenuService();
    private final BillService billService = new BillService();


    // 显示主菜单
    public void mainView() {
        while (loop) {
            System.out.println("=============欢迎来到满汉楼=============");
            System.out.println("\t\t1 登入满汉楼");
            System.out.println("\t\t2 退出满汉楼");
            System.out.print("请输入你的选择: ");
            String s = Utility.readString(1);
            switch (s) {
                case "1":
                    checkView();
                    break;
                case "2":
                    System.out.println("2 退出满汉楼");
                    loop = false;
                    break;
                default:
                    System.out.println("选择错误,请重新选择...");
            }
        }

    }

    private void checkView() {
        System.out.print("请输入员工ID: ");
        String id = Utility.readString(50);
        System.out.print("请输入密码: ");
        String pwd = Utility.readString(50);
        Employee employee = employeeService.getEmployee(id, pwd);
        if (employee == null) {
            System.out.println("验证失败...");
            return;
        }
        System.out.println("验证成功...");
        secondaryMenu(employee);
    }

    private void secondaryMenu(Employee employee) {
        while (loop) {
            System.out.println("=============满汉楼(二级菜单)=============");
            System.out.println("=============" + employee.getName() + "(" + employee.getJob() + ")" + "=============");
            System.out.println("\t\t1 查看餐桌状态");
            System.out.println("\t\t2 预订餐桌");
            System.out.println("\t\t3 显示所有菜品");
            System.out.println("\t\t4 点餐服务");
            System.out.println("\t\t5 查看账单");
            System.out.println("\t\t6 结帐");
            System.out.println("\t\t9 退出满汉楼");
            System.out.print("请输入你的选择: ");
            String s = Utility.readString(1);
            switch (s) {
                case "1":
                    listTables();
                    break;
                case "2":
                    orderTable();
                    break;
                case "3":
                    MenuList();
                    break;
                case "4":
                    if (!orderMenu()) {
                        System.out.println("点餐失败...");
                        break;
                    }
                    System.out.println("点餐成功...");
                    break;
                case "5":
                    listBill();
                    break;
                case "6":
                    checkout();
                    break;
                case "9":
                    System.out.println("\t\t9 退出满汉楼");
                    loop = false;
                    break;
                default:
                    System.out.println("选择错误,请重新选择...");
                    break;
            }

        }

    }

    private void listTables() {
        List<DiningTable> diningTables = diningTableService.getDiningTables();
        System.out.println("=============查看餐桌状态=============");
        System.out.println("餐桌编号\t\t餐桌状态\t\t订餐人\t\t电话\t");
        for (DiningTable diningTable : diningTables) {
            String formatInfo = diningTable.getNums() + "\t\t\t" + diningTable.getStatus() + "\t\t\t" +
                    diningTable.getOrderName() + "\t\t\t" + diningTable.getOrderTel();
            System.out.println(formatInfo);
        }
    }

    private void orderTable() {
        System.out.println("=============预订餐桌=============");
        System.out.print("请输入需要预订的餐桌编号(-1退出预订): ");
        Integer id = Utility.readInt();
        if (id == -1) {
            System.out.println("退出预订...");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTable(id);
        if (diningTable == null) {
            System.out.println("餐桌编号不存在...");
            return;
        }
        if (!("空闲".equals(diningTable.getStatus()))) {
            System.out.println("该餐桌已被预订...");
            return;
        }
        String key;
        while (true) {
            System.out.print("是否预订(Y/N): ");
            key = Utility.readString(1);
            if ("n".equalsIgnoreCase(key)) {
                System.out.println("取消预订...");
                return;
            }
            if ("Y".equalsIgnoreCase(key)) {
                System.out.print("预订人姓名: ");
                String name = Utility.readString(50);
                System.out.print("预订人联系电话: ");
                String phone = Utility.readString(20);
                if (!diningTableService.checkOrderTable(id, name, phone)) {
                    System.out.println("预订失败,请稍后重试...");
                    return;
                }
                break;
            }
            System.out.println("请输入正确的选择...");
        }
        System.out.println("预订成功...");
    }

    private void MenuList() {
        System.out.println("=============菜单=============");
        List<Menu> menuList = menuService.getMenuList();
        System.out.println("菜品编号\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu : menuList) {
            String formatInfo = menu.getId() + "\t\t\t" + menu.getName() + "\t\t" +
                    menu.getType() + "\t\t" + menu.getPrice();
            System.out.println(formatInfo);
        }
    }

    private boolean orderMenu() {
        System.out.println("=============开始点餐=============");
        System.out.print("请选择餐桌号(-1退出): ");
        int i = Utility.readInt();
        if (i == -1) {
            return false;
        }
        DiningTable diningTable = diningTableService.getDiningTable(i);
        if (diningTable == null) {
            System.out.println("餐桌不存在...");
            return false;
        }
        if ("空闲".equals(diningTable.getStatus())) {
            System.out.println("该餐桌空闲，需要预订...");
            return false;
        }
        System.out.print("请输入菜品编号(-1退出): ");
        int i2 = Utility.readInt();
        if (i2 == -1) {
            return false;
        }
        Menu menu = menuService.getMenu(i2);
        if (menu == null) {
            System.out.println("菜品编号不存在...");
            return false;
        }
        System.out.print("请输入菜品数量(-1退出): ");
        int i3 = Utility.readInt();
        if (i3 == -1) {
            return false;
        }
        return billService.orderMenu(i2, i3, i);
    }

    private void listBill() {
        System.out.println("=============账单信息=============");
        List<MultiplyBean> multiplyBean = billService.getMultiplyBean();
        System.out.println("编号\t\t\t\t\t\t菜品编号\t\t菜品名\t\t单价\t\t数量\t\t总金额\t\t桌号\t\t日期\t\t\t\t\t\t\t\t状态");
        for (MultiplyBean bill : multiplyBean) {
            System.out.println(bill.getBill_id() + "\t\t\t\t" + bill.getMenu_id() + "\t\t" + bill.getName() + "\t\t" + bill.getPrice() +
                    "\t\t" + bill.getNums() + "\t\t" + bill.getMoney() + "\t\t" + bill.getDiningTableId() +
                    "\t\t" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E").format(bill.getBill_date()) +
                    "\t\t\t\t\t\t\t" + bill.getStatus());
        }
    }

    private void checkout() {
        System.out.println("=============结帐=============");
        System.out.print("请选择结帐的餐桌编号(-1退出结帐): ");
        int i = Utility.readInt();
        if (i == -1) {
            System.out.println("暂不结帐...");
        }
        DiningTable diningTable = diningTableService.getDiningTable(i);
        if (diningTable == null) {
            System.out.println("该餐桌编号不存在...");
            return;
        }
        if ("空闲".equals(diningTable.getStatus())) {
            System.out.println("该餐桌编号空闲，无需支付账单...");
            return;
        }
        BigDecimal notCheckedOutBillList = billService.getNotCheckedOutBillList(i);
        if (notCheckedOutBillList.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println("您可能预订了餐桌号但并没有点餐");
            String key = "";
            while (true) {
                System.out.print("需要先点餐吗?(Y/N)");
                key = Utility.readString(1);
                if ("Y".equalsIgnoreCase(key)) {
                    System.out.println("选择4进行点餐哦...");
                    return;
                }
                if ("N".equalsIgnoreCase(key)) {
                    System.out.println("继续结帐...");
                    break;
                }
                System.out.println("选择有误，请重新选择...");
            }
        }
        System.out.println("该餐需支付: " + notCheckedOutBillList + "元");
        System.out.print("请输入结帐方式(现金/支付宝/微信/信用卡/银行卡)：");
        String pay_type = Utility.readString(30);
        String key;
        while (true) {
            System.out.print("确认是否结帐(Y/N)");
            key = Utility.readString(1);
            if ("Y".equalsIgnoreCase(key)) {
                if (!diningTableService.checkOutUpdate(i)) {
                    System.out.println("结帐失败,请稍后重试...");
                    return;
                }
                break;
            }
            if ("N".equalsIgnoreCase(key)) {
                return;
            }
        }
        if (!billService.updateStatus(i, pay_type)) {
            System.out.println("结帐失败...");
        }
        System.out.println("结帐成功...");

    }
}
