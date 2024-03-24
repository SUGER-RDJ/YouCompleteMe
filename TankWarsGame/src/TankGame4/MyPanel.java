package TankGame4;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
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

    //定义一个Vector用于存放炸弹
    Vector<Boom> booms = new Vector<>();
    //定义两张爆炸图片，显示爆炸效果
    Image image1 = null;
    Image image2 = null;

    public MyPanel(){
        //初始化己方坦克
        hero = new Hero(500,300);
        hero.setSpeed(4);
        //初始化敌方坦克
        for (int i = 0;i < EnemyTankSize;i++){
            EnemyTank enemy = new EnemyTank((100 * (i + 1)), 0);
            enemy.setEnemyTanks(enemyTanks);
            enemy.setDirection(2);
            new Thread(enemy).start();

            //给enemy加入子弹
            Shot shot = new Shot(enemy.getX() + 20,enemy.getY() + 60,enemy.getDirection(),3);
            //加入enemy的vector成员
            enemy.shots.add(shot);
            new Thread(shot).start();

            enemyTanks.add(enemy);


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                image1 = ImageIO.read(new File("out/production/TankWarsGame/1.png"));
                image2 = ImageIO.read(new File("out/production/TankWarsGame/2.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
//            //初始化图片对象
//            image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/1.png"));
//            image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/2.png"));
        }
    }


    //添加方法，显示我方击毁敌方坦克信息
    public void showInfo(Graphics g){

        g.setColor(Color.BLACK);
        Font font = new Font("宋体",Font.BOLD,25);
        g.setFont(font);

        g.drawString("您累计击毁敌方坦克",1020,30);
        drawTank(1020,60,g,0,1);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllEnemyTanksNum() + "",1080,100);

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750); //填充矩形默认黑色
        showInfo(g);

        //绘制己方坦克-封装方法
        if (hero != null && hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirection(), 0);
        }
//        //绘制己方子弹
//        if (hero.shot != null && hero.shot.isLive == true){
//            //g.fill3DRect(hero.shot.x,hero.shot.y,1,1,false);
//            g.draw3DRect(hero.shot.x,hero.shot.y,2,2,false);
//        }
        //将hero的子弹集合遍历取出
        for (int i = 0;i < hero.shots.size();i++){
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.isLive == true){
                g.draw3DRect(shot.x,shot.y,2,2,false);
            }else {
                hero.shots.remove(shot);
            }
        }

        //如果booms集合中有对象就画出
        Iterator<Boom> boomIterator = booms.iterator();
        while (boomIterator.hasNext()){
            Boom boom = boomIterator.next();
            if (boom.life > 3){
                g.drawImage(image1,boom.x,boom.y,60,60,this);
            }else {
                g.drawImage(image2,boom.x,boom.y,60,60,this);
            }
            boom.lifeDown();
            //让炸弹生命值减少，如果life为0，就从集合中删除
            if (boom.life == 0) {
                booms.remove(boom);
            }
        }

        //绘制敌方坦克，遍历vector
        Iterator<EnemyTank> iterator = enemyTanks.iterator();
        while (iterator.hasNext()){
            EnemyTank enemy = iterator.next();

            //判断当前坦克是否还存活,判断为真才绘制
            if (enemy.isLive) {
                drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirection(), 1);
            }
            //画出enemy的所有子弹
            for (int j = 0;j < enemy.shots.size();j++){
                //取出子弹
                Shot shot = enemy.shots.get(j);
                //绘制子弹
               if (shot.isLive){
                   g.draw3DRect(shot.x, shot.y, 2,2,false);
               }else {
                   //从Vector移除
                   enemy.shots.remove(shot);
               }
            }
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


    //如果发射多颗子弹，在判断是否击中时需要把我方集合中所有子弹都取出和敌方所有坦克进行判断
    public void hitEnemyTank(){
        for (int j = 0;j < hero.shots.size();j++){
            Shot shot = hero.shots.get(j);
            if (shot != null && shot.isLive){

                for (int i = 0;i < enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank.isLive){
                    hitTank(shot,enemyTank);
                    }
                }
            }
        }
    }


    public void hitHero(){
        for (int i = 0;i < enemyTanks.size();i++){
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0;j < enemyTank.shots.size();j++){
                Shot shot = enemyTank.shots.get(j);
                if (hero.isLive && shot.isLive){
                    hitTank(shot,hero);
                }
            }
        }
    }


    //判断己方子弹是否击中敌方坦克
    public void hitTank(Shot s,Tank tank){
        switch (tank.getDirection()){
            case 0:
            case 2:
                if(s.x > tank.getX() && s.x < tank.getX() + 40 && s.y > tank.getY() && s.y < tank.getY() + 60){
                    s.isLive = false;
                    tank.isLive = false;
                    if (tank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    //创建一个Boom对象，加入到booms集合中
                    Boom boom = new Boom(tank.getX(), tank.getY());
                    booms.add(boom);
                    enemyTanks.remove(tank);
                }
                break;
            case 1:
            case 3:
                if(s.x > tank.getX() && s.x < tank.getX() + 60 && s.y > tank.getY() && s.y < tank.getY() + 40){
                    s.isLive = false;
                    tank.isLive = false;
                    if (tank instanceof EnemyTank){
                        Recorder.addAllEnemyTankNum();
                    }
                    Boom boom = new Boom(tank.getX(), tank.getY());
                    booms.add(boom);
                    enemyTanks.remove(tank);
                }
                break;
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
            if (hero.getY() > 0) {
                hero.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirection(1);
            if (hero.getX() > 0) {
                hero.moveLeft();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirection(2);
            if (hero.getY() + 60 < 750) {
                hero.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirection(3);
            if (hero.getX() + 60 < 1000) {
                hero.moveRight();
            }
        }

        //如果用户键入J，让子弹发射
        if (e.getKeyCode() == KeyEvent.VK_J){
//            //判断hero子弹是否消亡(一颗子弹的情况)
//            if (hero.shot == null || !hero.shot.isLive){
//                hero.shouEnemyTank();
//            }
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

//            //判断是否击中敌人坦克
//            if (hero.shot != null && hero.shot.isLive){
//                //子弹若还存活，遍历敌人所有坦克
//                for (int i = 0;i < enemyTanks.size();i++){
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    hitTank(hero.shot,enemyTank);
//                }
//            }

            //判断敌方坦克是否存活，死亡则从Vector中删除，以免尸体影响子弹判断
            Iterator<EnemyTank> enemyTankIterator = enemyTanks.iterator();
            while (enemyTankIterator.hasNext()){
                EnemyTank enemyTank = enemyTankIterator.next();
                if (!enemyTank.isLive){
                    enemyTankIterator.remove();
                }
            }

            hitHero();
            hitEnemyTank();
            this.repaint();
        }

    }
}
