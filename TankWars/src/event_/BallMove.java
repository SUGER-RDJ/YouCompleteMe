package event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 演示小球通过键盘控制移动——>Java事件控制
 */
public class BallMove extends JFrame{

    MyPanel mp = null;
    public static void main(String[] args) {
        BallMove ballMove = new BallMove();
    }

    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(400,300);
        //窗口JFrame对象可以监听键盘事件，即可以监听到面板发生的键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//KeyListener是一个键盘监听器，可以监听键盘事件
class MyPanel extends JPanel implements KeyListener {

    //为了让小球可以移动，将左上角的坐标设置成变量
    int x = 10;
    int y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,20,20);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //有字符输入会被此方法监听
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //当某个键按下，该方法触发
        System.out.println((char) e.getKeyCode() + "被按下");
        //根据用户按下的不同键，来处理小球的移动（上下左右的键）
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            //KeyEvent.VK_DOWN就是向下的键对应的code值
            //在Java中会给每个键分配一个值
            y++;
        }else if (e.getKeyCode() == KeyEvent.VK_UP){
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        //主动触发repaint方法，让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //当某个键释放，该方法释放
    }
}
