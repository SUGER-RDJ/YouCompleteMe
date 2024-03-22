package TankGame3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

@SuppressWarnings({"all"})
//为了监听键盘事件，需要实现KeyListener
//为了让Panel不停的重绘子弹需要将MYPanel实现Runnable接口，当做一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义己方坦克
    Hero hero = null;

    //定义敌方坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int EnemyTankSize = 3;

    public MyPanel(){
        //初始化己方坦克
        hero = new Hero(100,100);
        hero.setSpeed(4);
        //初始化敌方坦克
        for (int i = 0;i < EnemyTankSize;i++){
            EnemyTank enemy = new EnemyTank((100 * (i + 1)), 0);
            enemy.setDirection(2);
            enemyTanks.add(enemy);
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750); //填充矩形默认黑色

        //绘制己方坦克-封装方法
        drawTank(hero.getX(),hero.getY(),g,hero.getDirection(),0);
        //绘制己方子弹
        if (hero.shot != null && hero.shot.isLive == true){
            //g.fill3DRect(hero.shot.x,hero.shot.y,1,1,false);
            g.draw3DRect(hero.shot.x,hero.shot.y,2,2,false);
        }

        //绘制敌方坦克，遍历vector
        for (int i = 0;i < enemyTanks.size();i++){
            EnemyTank enemy = enemyTanks.get(i);
            drawTank(enemy.getX(),enemy.getY(),g,enemy.getDirection(),1);
        }
    }

    /**
     *
     * @param x 坦克的左上角横坐标
     * @param y 左上角纵坐标
     * @param g 画笔
     * @param direction 坦克方向
     * @param type 坦克类型
     */
    public void drawTank(int x,int y,Graphics g,int direction,int type){

        switch(type){
            case 0: //己方坦克
                g.setColor(Color.CYAN);
                break;
            case 1: //敌方坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克不同方向来绘制坦克
        //direction表示方向（0:上 1:左 2:下 3:右）
        switch(direction){
            case 0:
                g.fill3DRect(x,y,10,60,false);  //左侧
                g.fill3DRect(x + 30,y,10,60,false);  //右侧
                g.fill3DRect(x + 10,y + 10,20,40,false);  //中部
                g.fillOval(x + 10,y + 20,20,20); //车盖
                g.drawLine(x + 20,y + 30,x + 20,y); //炮筒
                break;
            case 1:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,20,false);
                g.fillOval(x + 20,y + 10,20,20);
                g.drawLine(x + 30,y + 20,x,y + 20);
                break;
            case 2:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x + 30,y,10,60,false);
                g.fill3DRect(x + 10,y + 10,20,40,false);
                g.fillOval(x + 10,y + 20,20,20);
                g.drawLine(x + 20,y + 30,x + 20,y + 60);
                break;
            case 3:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fill3DRect(x + 10,y + 10,40,20,false);
                g.fillOval(x + 20,y + 10,20,20);
                g.drawLine(x + 30,y + 20,x + 60,y + 20);
                break;
            default:
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //处理wasd按下时的情况
        if (e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirection(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(1);
            hero.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(3);
            hero.moveRight();
        }

        //如果用户键入J，让子弹发射
        if (e.getKeyCode() == KeyEvent.VK_J){
            hero.shouEnemyTank();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { //每隔一定时间自动重绘
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.repaint();
        }

    }
}
