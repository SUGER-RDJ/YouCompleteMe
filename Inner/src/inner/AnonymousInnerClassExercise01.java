package inner;

public class AnonymousInnerClassExercise01 {
    //匿名内部类使用场景：1.当做实参传递，简洁高效
    public static void main(String[] args) {
        f1(new IL() {
            @Override
            public void show() {
                System.out.println("展示");
            }
        }); //整个匿名内部类被当做一个实参传递（匿名内部类本质也是一个对象）
    }

    public static void f1(IL il){
        il.show();
    }
}

interface IL{
    void show();
}
