package BagPack;

public class Demo extends Father{
    String name = "Jack";
    Demo(){
        super();
        System.out.println("Demo");
    }
    Demo(String s){
        super(s);
    }
    public void test(){
        System.out.println(super.name);
        System.out.println(this.name);
    }
    public static void main(String[] args){  //父类子类传参机制
        new Demo().test();
        new Demo("Jhon").test();
    }
}
