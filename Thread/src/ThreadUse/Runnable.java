package ThreadUse;
import java.lang.Thread;

/**
 * 通过实现接口Runnable来开发线程
 */
public class Runnable {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //这里不能直接调用start方法
        Thread thread = new Thread(dog);
        thread.start();
    }
}
@SuppressWarnings({"all"})
class Dog implements java.lang.Runnable{
    private int count = 0;

    @Override
    public void run() {
        while (true){
            System.out.println("werwer~");
            ++count;

            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if (count == 5){
                break;
            }
        }
    }
}

//模拟Thread类
class TreadProxy implements java.lang.Runnable{

    private java.lang.Runnable target = null;
    @Override
    public void run() {
        if (target != null){
            target.run();
        }
    }

    public TreadProxy(java.lang.Runnable target) {
        this.target = target;
    }

    public void start(){
        start0(); //此方法是真正实现多线程的方法
    }
    public void start0(){
        run();
    }
}