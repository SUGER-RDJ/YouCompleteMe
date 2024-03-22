package PolyParamenter;

public class InterfacePolyParameter {
    //接口多态特性
    public static void main(String[] args) {
        //创建手机，相机对象
        Camera camera = new Camera();
        Phone phone = new Phone();
        //创建计算机
        Computer computer = new Computer();
        computer.work(phone);
        computer.work(camera);
        //接口类型的变量可以指向实现了IF接口的对象实例
        IF if01 = new Monster();
        if01 = new Car();

        //继承体现的多态
        //父类类型的变量a可以指向继承了AAA的子类对象实例
        AAA a = new BBB();
        a = new CCC();

        //多态数组
        Usb[] usbs = new Usb[2];
        usbs[0] = new Phone();
        usbs[1] = new Camera();
        for (int i = 0;i < usbs.length;i++){
            usbs[i].start();
        }
    }
}

interface IF{}
class Monster implements IF{}
class Car implements IF{}

class AAA{}
class BBB extends AAA{}
class CCC extends AAA{}