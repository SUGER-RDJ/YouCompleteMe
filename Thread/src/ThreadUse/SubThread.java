package ThreadUse;
import java.lang.Thread;

/**
 * main线程启动多个子线程
 */
public class SubThread {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
    }
}

@SuppressWarnings({"all"})
class T1 implements java.lang.Runnable{  //每隔一秒输出

    private int i = 0;
    @Override
    public void run() {

        while (true) {
            System.out.println("嗷呜～");
            try {
                Thread.sleep(1000);
                ++i;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 10){
                break;
            }
        }

    }
}

@SuppressWarnings({"all"})
class T2 implements java.lang.Runnable{  //每隔一秒输出
    private int i = 0;
    @Override
    public void run() {

        while (true) {
            System.out.println("wer～");
            try {
                Thread.sleep(1000);
                ++i;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i == 20){
                break;
            }
        }

    }
}
