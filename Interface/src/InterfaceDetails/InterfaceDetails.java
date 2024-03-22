package InterfaceDetails;

public class InterfaceDetails {
    public static void main(String[] args) {
        //new IA();  错误，接口不能被实例化，接口本身是抽象的一种延伸，希望别的类来实现它
    }
}

interface IA{
    void say();  //实际上是public abstract void say(); 接口中所有的方法是public方法，可以不用abstract修饰
    void hi();
}

class Cat implements IA{
    @java.lang.Override
    public void say() {

    }

    @java.lang.Override
    public void hi() {

    }
    //一个普通类实现接口，就必须将该接口中所有方法都实现，快捷键option+enter
}
abstract class Tiger implements IA{
    //抽象类实现接口时，可以不实现接口的方法
}

interface IB{
    int n1 = 10; //等价于public static final int n1 = 10;接口中的属性只能说final的
    void hi();
}

class Pig implements IA,IB{ //一个类可以同时实现多个接口
    @Override
    public void say() {

    }

    @Override
    public void hi() {

    }
}

interface IC extends IA,IB{
    //接口不能继承其他的类，但是可以继承多个别的接口
    //接口的修饰符只能是public和默认，这点和类修饰符规则一样
}