package HouseRent.View;

import HouseRent.Service.HouseService;
import HouseRent.domain.House;
import HouseRent.utils.Utility;

public class HouseView {
    //显示页面
    //接受用户的输入
    //调用HouseService完成对房屋信息的各种操作

    private boolean loop = true; //控制显示菜单
    private char key = ' '; //接受用户选择
    private HouseService houseService = new HouseService(10);  //设置数组大小为10

    //根据id修改房屋信息
    public void update(){
        System.out.println("修改房屋信息");
        System.out.println("请选择待修改房屋编号：（-1表示退出）");
        int updateId = Utility.readInt();
        if (updateId == -1){
            System.out.println("放弃修改");
            return;
        }


        House house = houseService.findById(updateId);
        if (house == null){
            System.out.println("要修改的房屋信息不存在");
            return;
        }

        System.out.println("姓名（" + house.getName() + "):");
        String name = Utility.readString(8,"");
        if (!"".equals(name)){
            house.setName(name);
        }
        System.out.println("电话（" + house.getPhone() + "):");
        String phone = Utility.readString(12);
        if (!"".equals(phone)){
            house.setPhone(phone);
        }
        System.out.println("地址（" + house.getAddress() + "):");
        String address = Utility.readString(18);
        if (!"".equals(address)){
            house.setAddress(address);
        }
        System.out.println("租金（" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1){
            house.setRent(rent);
        }
        System.out.println("状态（" + house.getState() + "):");
        String state = Utility.readString(3);
        if (!"".equals(state)){
            house.setState(state);
        }
    }

    //根据id查找房屋信息
    public void findHouse(){
        System.out.println("查找房屋信息");
        System.out.println("请输入要查找的id：");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house != null){
            System.out.println(house);
        }else{
            System.out.println("未查找到相应信息");
        }
    }

    //编写deleteHouse方法，接受输入的id
    public void delHouse(){
        System.out.println("删除房屋信息");
        System.out.println("输入待删除房屋的编号：（-1表示退出）");
        int delId = Utility.readInt();
        if (delId == -1){
            return;
        }
        char choice = Utility.readConfirmSelection();  //该方法本身包含循环逻辑
        if (choice == 'Y'){
            if (houseService.del(delId)){
                System.out.println("删除成功");
            }else {
                System.out.println("房屋编号不存在，删除失败");
            }
        }else {
            System.out.println("放弃删除");
        }

    }

    //编写addHouse方法，创建House对象，调用add方法
    public void addHouse(){
        System.out.println("添加房屋");
        System.out.println("姓名：");
        String name = Utility.readString(6);
        System.out.println("电话：");
        String phone = Utility.readString(12);
        System.out.println("地址：");
        String address = Utility.readString(16);
        System.out.println("月租：");
        int rent = Utility.readInt();
        System.out.println("状态：");
        String state = Utility.readString(3);
        //创建一个新的House对象，id是系统自动分配的，按自增长分配
        House house = new House(0,name,phone,address,rent,state);
        if (houseService.add(house)){
            System.out.println("添加房屋成功");
        }else {
            System.out.println("添加房屋失败");
        }
    }

    //编写list列表，显示房屋信息
    public void listHouses(){
        System.out.println("房屋列表");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态");
        House[] houses = houseService.list();  //得到所有房屋信息
        for (int i = 0;i < houses.length;i++){
            if (houses[i]==null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("列表显示完毕");
    }

    public void mainMenu(){
        do {
            System.out.println("房屋出租系统菜单");
            System.out.println("\t\t\t1.新增房源");
            System.out.println("\t\t\t2.查找房屋");
            System.out.println("\t\t\t3.删除房屋信息");
            System.out.println("\t\t\t4.修改房屋信息");
            System.out.println("\t\t\t5.显示房屋信息");
            System.out.println("\t\t\t6.退出");
            System.out.println("\t\t\t请输入选择（1-6）");
            key = Utility.readChar();
            switch (key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    char c = Utility.readConfirmSelection();
                    if (c == 'Y'){
                        loop = false;
                    }
                    loop = false;
                    break;
            }
        }while(loop);

        }
        }


