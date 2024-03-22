package HouseRent.Service;

import HouseRent.domain.House;

public class HouseService {
    private House[] houses;
    private int houseNums = 1;  //记录当前有多少个房屋对象
    private int idCounter = 1;
    //构造器
    public HouseService(int size){
        houses = new House[size];  //当创建HOuseService对象，指定数组的大小
        houses[0] = new House(1,"jack","112","晋中市",2000,"未出租");

    }

    //find方法，返回house对象
    public House findById(int findId){
        for (int i = 0;i < houseNums;i++){
            if (findId == houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }

    //del方法，删除一个房屋信息
    public boolean del(int delId){
        int index = -1;
        for (int i = 0;i < houseNums;i++){
            if (delId == houses[i].getId()){
                index = i;
            }
        }
        if (index == -1){
            return false;
        }
        for (int i = index;i < houseNums - 1;i++){
            houses[i] = houses[i+1];
        }
        houses[--houseNums] = null;
        return true;
    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newHouse){
        //判断是否可以继续添加
        if (houseNums >= houses.length){
            System.out.println("数组已满，不能继续添加");
            return false;
        }
        houses[houseNums] = newHouse;
        houseNums++;
        //id自增长机制,更新id
        idCounter++;
        newHouse.setId(idCounter);
        return true;
    }

    //list方法返回houses数组

    public House[] list() {
        return houses;
    }
}
