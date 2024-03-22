package inner;

/**
 * 匿名内部类使用演示*/
public class AnonymousInnerClass {
    public static void main(String[] args) {
        /*
        * 使用匿名内部类来简化开发
        * 适用于该类只使用一次的场景，新建一个类显得冗余
        * tiger的编译类型 IA 运行类型 匿名内部类（Outer04$1）名字实际为外部类加一个$1，由系统自动分配
        * 在底层 class Outer04$1 implements IA{
        *           @Override
        *           public void cry(){
        *               System.out.println("老虎叫");
        *           }
        *       }
        * jdk底层，在创建了匿名内部类后立马就创建了Outer04$1实例，并且把地址返回给tiger
        * 匿名内部类使用一次后就不能在使用了（tiger是对象，可以多次调用）
        * */

        //基于方法的匿名内部类
        IA tiger = new IA(){
            @Override
            public void cry(){
                System.out.println("老虎叫");
            }
        }; //最后的分号不能省略
        tiger.cry();
        tiger.cry();//匿名内部类使用一次后就不能再使用，但tiger可以多次调用

        //演示基于类的匿名内部类
        /*
        * father编译类型 Father 运行类型 Outer04$2(按顺序赋值)
        * 同时也直接返回了对象*/
        Father father = new Father("jack"){
            @Override
            public void test() {
                System.out.println("匿名内部类重写了test方法");
            }
        };
        father.test();

        Outer05 outer05 = new Outer05();
        outer05.f1();
    }
}

class Outer04{
    private int n1 = 10;
    public void method(){
    }
}

interface IA{
    public void cry();
}
class Father{
    public Father(String name) {
        super();
    }
    public void test(){

    }
}
/**
 * 匿名内部类既是一个类的定义，同时它本身也是一个对象，因此从语法上看，它既有类的特征，也有创建对象的特征
 * 调用匿名内部类的方法有两种*/

class Outer05{
   public void f1(){
       //调用方法1:重写方法
       Person person = new Person(){
           @Override
           public void hi() {
               System.out.println("匿名内部类重写了方法");
               //因为运行类型实际是Outer05$1,所以实际输出汉字
               //如果没有重写，则输出Person hi
           }
       };
       person.hi(); //动态绑定

       //调用方法2:直接调用
       new Person(){
           @Override
           public void hi() {
               System.out.println("重写方法2");
           }
       }.hi();
   }
}
class Person{
    public void hi(){
        System.out.println("Person hi()");
    }
}//还可以实现抽象类接口等。。。