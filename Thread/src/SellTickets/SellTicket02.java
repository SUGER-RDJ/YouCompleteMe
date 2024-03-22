package SellTickets;

/**
 * 实现Runnable接口解决售票问题
 */
public class SellTicket02 {
    public static void main(String[] args) {
        Sell02 sell02 = new Sell02();
        new Thread(sell02).start();
        new Thread(sell02).start();
        new Thread(sell02).start();

    }
}

class Sell02 implements Runnable{
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
