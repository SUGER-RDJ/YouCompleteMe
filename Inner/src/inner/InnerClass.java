package inner;

public class InnerClass {  //外部其他类
    public static void main(String[] args) {

    }
}

class Outer{  //外部类
    public Outer(int n1) {//构造器
        this.n1 = n1;
    }

    private int n1 = 100;  //属性
    public void m1(int n1){  //方法
        this.n1 = n1;
    }
    {
        System.out.println("代码块。。。");
    }
    class inner{
        //内部类，在Outer的内部
        /*
        * 定义在外部类局部位置上：局部内部类（有类名），匿名内部类（没有类名）
        * 定义在外部类的成员位置上：成员内部类（无static），静态内部类（static）*/
    }
}