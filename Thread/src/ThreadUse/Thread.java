package ThreadUse;

/**
 * 演示通过继承Thread类创建线程
 */
public class Thread {
    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.start();
    }
}

class Cat extends java.lang.Thread {

    private int times = 0;
    @Override
    public void run() {
        //重写run，实现自己的业务逻辑
        //当一个类继承了Thread类，就可以当做线程使用
        //run Thread类实现了Runnable接口的run方法

        while (true) {
            System.out.println("werwer~");
            ++times;
            try {
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 20){
                break;
            }
        }
    }
}
