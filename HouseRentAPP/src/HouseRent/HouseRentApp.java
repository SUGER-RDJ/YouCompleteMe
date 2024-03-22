package HouseRent;

import HouseRent.View.HouseView;
import HouseRent.utils.Utility;

public class HouseRentApp {
    public static void main(String[] args) {
        //创建HouseView对象，并且显示主菜单，是整个程序的入口
        new HouseView().mainMenu();
        System.out.println("已退出");
    }
}
