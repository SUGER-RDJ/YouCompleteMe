package exit;

public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {

        Thr thr = new Thr();
        thr.start();

        //希望主线程控制线程的终止
        Thread.sleep(10*1000);
        thr.setLoop(false);
    }
}

class Thr extends Thread{
    int count = 0;
    //设置一个控制变量
    private boolean loop = true;
    @Override
    public void run() {
        while (loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("运行中..." + (++count));
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
