package TankGame4;

public class Shot implements Runnable{
    int x;
    int y;
    int direct = 0;
    int speed = 3;
    boolean isLive = true;

    public Shot(int x, int y, int direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(50);  //休眠50毫秒，使子弹显示运动轨迹
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //根据方向改变x，y
            switch (direct){
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x -= speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x += speed;
                    break;
            }
            if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)){
                isLive = false;
                break;
            }
        }
    }
}
