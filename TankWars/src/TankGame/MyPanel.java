package TankGame;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    Hero hero = null;
    public MyPanel(){
        hero = new Hero(100,100);//初始化己方坦克初始位置

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750); //填充矩形默认黑色

        //绘制坦克-封装方法
        drawTank(hero.getX(),hero.getY(),g,0,0);
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
        switch(direction){
            case 0:
                g.fill3DRect(x,y,10,60,false);  //左侧
                g.fill3DRect(x + 30,y,10,60,false);  //右侧
                g.fill3DRect(x + 10,y + 10,20,40,false);  //中部
                g.fillOval(x + 10,y + 20,20,20);
                g.drawLine(x + 20,y + 30,x + 20,y);
                break;
            default:
        }
    }
}
