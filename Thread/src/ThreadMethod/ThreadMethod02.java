package ThreadMethod;

/**
 * 线程常用方法
 * yield：线程的礼让，让出cpu，但礼让时间不确定，也可能礼让不成功
 * join：线程的插队，线程的插队一旦成功，则肯定先执行完插入的线程的所有任务
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {

        ThreadDemo2 demo2 = new ThreadDemo2();
        demo2.start();
        for (int i = 1;i <= 20;i++){
            Thread.sleep(1000);
            System.out.println("主线程运行" + i + "次");
            if (i == 5){
                System.out.println("子线程插队运行");
                demo2.join(); //相当于让demo2先全部完成
            }
        }
    }
}

class ThreadDemo2 extends Thread{
    @Override
    public void run() {
        for (int i = 1;i <= 20;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("子线程运行第" + i + "次");
        }
    }
}
