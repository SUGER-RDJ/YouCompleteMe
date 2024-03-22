package Draw;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"all"})
//Java绘图机制
public class DrawCircle extends JFrame{  //JFrame对应一个窗口,可以理解为一个画框

    //定义一个面板
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口
        this.add(mp);
        //设置窗口大小
        this.setSize(400,300);
        //当点击退出窗口时，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可显示
        this.setVisible(true);
    }
}


//先定义一个面板MyPanel，继承JPanel的类
/**
 * 绘图原理：
 * Component类提供了两个和绘图相关的重要方法
 * 1.paint（Graphics g）绘制组建的外观
 * 2.repaint（）刷新组建的外观
 * 当组件第一次在屏幕上显示的时候，程序会自动的调用paint（）方法来绘制组件
 * 在以下情况下paint会被调用：
 * 1.窗口最小化，再最大化
 * 2.窗口大小发生变化
 * 3.repaint函数被调用*/
class MyPanel extends JPanel{
    //1.MyPanel对象就是一个画板
    //2.Graphics g ，g相当于画笔，Graphics提供了多个方法
    @Override
    public void paint(Graphics g) {
        super.paint(g); //调用父类的方法完成初始化
        System.out.println("paint方法调用");
        //画一个圆形
        g.drawOval(10,10,100,100);
    }
}
