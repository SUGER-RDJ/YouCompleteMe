package ExtendsVSInterface;

public class ExtendsVSInterface {
    public static void main(String[] args) {
        LittleMonkey mon = new LittleMonkey("Mon");
        mon.climbing();
        mon.swimming();
        mon.fly();
        //当子类继承了父类，就自动拥有了父类的功能
        //如果子类需要扩展功能，可以通过接口实现，相当于克服了单继承的缺陷
        //接口比继承更加灵活，继承满足is-a关系，接口是like-a关系
    }
}

class Monkey{
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public void climbing(){
        System.out.println(name + "会爬树");
    }

    public String getName() {
        return name;
    }
}

//接口
interface Fish{
    void swimming();
}
interface Bird{
    void fly();
}

class LittleMonkey extends Monkey implements Fish,Bird{

    public LittleMonkey(String name) {
        super(name);
    }

    @Override
    public void swimming() {
        System.out.println(getName() + "学会了游泳");
    }

    @Override
    public void fly() {
        System.out.println(getName() + "学会了飞翔");
    }
}