package PolyParamenter;

public class Phone implements Usb{
    //Phone 类需要实现Usb接口声明的方法

    @Override
    public void start() {
        System.out.println("手机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("手机停止工作");
    }
}
