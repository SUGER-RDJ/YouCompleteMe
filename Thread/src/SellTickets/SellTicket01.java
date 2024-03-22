package SellTickets;

/**
 * 售票系统
 * 模拟三个售票窗口售票100
 * 1.使用Thread继承
 */
public class SellTicket01 {
    public static void main(String[] args) {
        Sell01 sell01 = new Sell01();
        Sell01 sell02 = new Sell01();
        Sell01 sell03 = new Sell01();
        //使用Thread可能会出现互斥同步，票数超卖的问题
        sell01.start();
        sell02.start();
        sell03.start();

    }
}

class Sell01 extends Thread {
    private static int ticketnum = 100;
    @Override
    public void run() {
        while (true){
            if (ticketnum <= 0){
                System.out.println("已售完");
                break;
            }

            try {  //try-catch快捷键option+command+t
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("窗口" + Thread.currentThread().getName() + "剩余" + (--ticketnum) + "张票");
        }
    }
}