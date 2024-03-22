package Syn;

/**
 * 线程同步机制
 */
public class synchron {
    public static void main(String[] args) {
        SellTicketSy sy = new SellTicketSy();
        new Thread(sy).start();
        new Thread(sy).start();
        new Thread(sy).start();
    }
}

class SellTicketSy implements Runnable{
    private static int ticketnum = 50;
    private static boolean loop = true;

    public synchronized void method(){  //同步方法，在同一时刻只能有一个线程来执行method方法
        if (ticketnum <= 0){
            System.out.println("已售完");
            loop = false;
            return;
        }


        System.out.println("窗口" + Thread.currentThread().getName() + "剩余" + (--ticketnum) + "张票");
    }

    @Override
    public void run() {
        while (loop){
            try {  //try-catch快捷键option+command+t
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            method();
        }
    }
}