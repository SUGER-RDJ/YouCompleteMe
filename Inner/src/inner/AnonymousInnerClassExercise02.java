package inner;

public class AnonymousInnerClassExercise02 {
    //匿名内部类使用场景：2.灵活变更运行类型
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小猪起床了");
            }
        });

        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小猪哼哼的爬了起来");
            }
        });
    }
}

interface Bell{
    void ring();
}
class CellPhone{
    public void alarmClock(Bell bell){
        bell.ring();
    }
}
