package inner;

//静态内部类
public class StaticInnerClass {
    public static void main(String[] args) {
        Outer07 outer07 = new Outer07();
        outer07.m1();
    }
}

class Outer07{
    private int ni = 10;
    private static String name = "史猪猪";
    static class Inner07{
        //Inner07就是一个静态内部类：
        //1.放在外部类的成员位置
        //2.使用了static修饰
        //3.不能访问非静态成员,只能访问静态成员
        //4.可以添加任意访问修饰符
        public void say(){
            System.out.println(name);
        }
    }
    public void m1(){
        Inner07 inner07 = new Inner07();
        inner07.say();
    }
}