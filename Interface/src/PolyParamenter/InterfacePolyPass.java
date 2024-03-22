package PolyParamenter;

public class InterfacePolyPass {
    public static void main(String[] args) {
        //接口类型变量可以指向实现了该接口的类的对象实例
        IG ig = new Teacher();
        IH ih = new Teacher(); //继承后可以指向，多态传递现象
    }
}

interface IH{
    void hi();
}
interface IG extends IH{}
class Teacher implements IG{

    @Override
    public void hi() {
        //继承后，IH中的方法也需要实现
    }
}
