package ThreadMethod;

public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo1 demo1 = new ThreadDemo1();
        demo1.setName("线程1");
        demo1.setPriority(Thread.MIN_PRIORITY); //setPriority设置优先级
        demo1.start();

        for (int i = 0;i < 5;i++){
            Thread.sleep(1000);
            System.out.println("hhh");
        }
        System.out.println(demo1.getName() + "线程的优先级：" + demo1.getPriority());
        demo1.interrupt();  //中断线程的休眠
        //中断线程不是终止线程
    }
}

class ThreadDemo1 extends Thread{
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "运行中");
            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
        }
    }
}
