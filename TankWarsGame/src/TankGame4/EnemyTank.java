package TankGame4;

import java.io.IOException;
import java.util.Vector;

@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable{

    //在敌人坦克类使用Vactor保存多个shot
    Vector<Shot> shots = new Vector<>();

    //增加成员，EnemyTank可以得到敌人坦克的Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();

    boolean isLive = true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public void die() throws IOException {
        isLive = false;
            Recorder.addAllEnemyTankNum();
            Recorder.keepRecord();

    }

    //判断当前敌人坦克是否和enemyTanks中其他坦克发生碰撞
    public boolean isTouch(){
        switch (this.getDirection()){
            case 0:
                //让当前坦克和其他所有敌人坦克比较(不和自己比较)
                for (int i = 0;i < enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this){
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0;i < enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this){
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0;i < enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this){
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() + 60>= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60){
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 40
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                            if (this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40){
                                return true;
                            }
                            if (this.getX() + 40 >= enemyTank.getX()
                                    && this.getX() + 40 <= enemyTank.getX() + 60
                                    && this.getY() + 60 >= enemyTank.getY()
                                    && this.getY() + 60 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0;i < enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this){
                        if (enemyTank.getDirection() == 0 || enemyTank.getDirection() == 2){
                            if (this.getX() + 60>= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60){
                                return true;
                            }
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 40
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() +40 <= enemyTank.getY() + 60){
                                return true;
                            }
                        }
                        if (enemyTank.getDirection() == 1 || enemyTank.getDirection() == 3){
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40){
                                return true;
                            }
                            if (this.getX() + 60 >= enemyTank.getX()
                                    && this.getX() + 60 <= enemyTank.getX() + 60
                                    && this.getY() + 40 >= enemyTank.getY()
                                    && this.getY() + 40 <= enemyTank.getY() + 40){
                                return true;
                            }
                        }
                    }
                }
                break;

        }
        return false;
    }

    @Override
    public void run() {
        while (true){
            Shot s =null;
            if (isLive && shots.size() == 0){
                switch (getDirection()){
                    case 0:
                        s = new Shot(getX() + 20,getY(),0,3);
                        break;
                    case 1:
                        s = new Shot(getX(),getY() + 20,1,3);
                        break;
                    case 2:
                        s = new Shot(getX() + 20,getY() + 60,2,3);
                        break;
                    case 3:
                        s = new Shot(getX() + 60,getY() + 20,3,3);
                        break;
                }
                shots.add(s);
                new Thread(s).start();
            }

            //根据坦克方向来继续移动，随机改变坦克方向
            switch (getDirection()){
                case 0:
                    //让坦克保持此方向走30像素
                    for (int i = 0;i < 30 ;i++){
                        if (getY() > 0 && !isTouch()) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0;i < 30 ;i++){
                        if (getX() > 0 && !isTouch()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0;i < 30 ;i++){
                        if (getY() + 60 < 750 && !isTouch()) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0;i < 30 ;i++){
                        if (getX() + 60 < 1000 && !isTouch()) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //随机改变坦克方向0-3
            setDirection((int)(Math.random()*4));
            if (!isLive){
                break;
            }
        }
    }
}
