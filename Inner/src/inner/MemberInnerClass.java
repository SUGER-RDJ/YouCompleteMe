package inner;

/*
* 成员内部类：
* 定义在外部的成员位置，并且没有static修饰*/
public class MemberInnerClass {
    public static void main(String[] args) {
        Outer06 outer06 = new Outer06();
        outer06.t1();
    }
}

class Outer06{
    private int n1 = 125;
    public String name = "史猪猪";
    //成员内部类可以添加任意的访问修饰符，因为他的位置就是一个成员
    public class Inner06{  //成员内部类
        public void say(){
            System.out.println(name + "有足足" + n1 + "斤");
        }
    }
    public void t1(){  //外部类要访问成员内部类：创建内部类的对象，然后使用相关方法
        Inner06 inner06 = new Inner06();
        inner06.say();
    }
}
