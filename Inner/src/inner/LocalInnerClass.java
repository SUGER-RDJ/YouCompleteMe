package inner;

/*
* 演示局部内部类
* */
public class LocalInnerClass {
    public static void main(String[] args) {
        Outer02 outer02 = new Outer02();
        outer02.m1();
    }
}

class Outer02{
    private int n1 = 100;
    private void m2(){
        System.out.println("Outer02 m2()");
    } //私有方法
    public void m1(){
        //局部内部类定义在外部类的局部位置，通常在方法中
        class Inner02{  //不能添加访问修饰符，但可以用final修饰（表示不能再继承）
            //局部内部类可以直接访问外部类的所有成员包括私有
            private int n1 = 800;
            public void f1(){

                //如果外部类和局部内部类成员重名，默认遵循就近原则，如果想访问外部类的成员，使用 外部类名.this.成员 去访问
                System.out.println("n1=" + n1);
                System.out.println("OUTERn1=" + Outer02.this.n1);
                m2();
            }
        }
        class Inner03 extends Inner02{ }
            //若Inner02用final修饰则不能继承
        //作用域：仅在定义他的方法或代码块中

        //外部类在方法中可以创建Inner02对象，然后调用方法即可
        Inner02 inner02 = new Inner02();
        inner02.f1();
    }
}
