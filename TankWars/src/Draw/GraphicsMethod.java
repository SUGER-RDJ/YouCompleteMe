package Draw;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"all"})
public class GraphicsMethod extends JFrame {

    private Panel panel = null;
    public static void main(String[] args) {
        new GraphicsMethod();
    }

    public GraphicsMethod(){
        //初始化面板
        panel = new Panel();
        //把面板放入到窗口
        this.add(panel);
        //设置窗口大小
        this.setSize(300,250);
        //当点击退出窗口时，程序完全退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置可显示
        this.setVisible(true);
    }
}

class Panel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //1.直线(起点xy，终点xy)
        g.drawLine(10,10,100,100);
        //2.矩形边框
        g.drawRect(10,10,100,100);
        //3.椭圆边框
        //g.drawOval();
        //4.填充矩形
        g.setColor(Color.GRAY);
        g.fillRect(20,20,50,50);
        //5.填充椭圆
        g.setColor(Color.blue);
        g.fillOval(30,30,20,20);
        //6.图片
        //1)加载图片，图片放在out下的TankWars下
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/text.jpeg"));
        g.drawImage(image,100,10,100,70,this);
        //7.字符串
        g.setColor(Color.MAGENTA);
        g.setFont(new Font("隶书",Font.BOLD,50));
        //这里设置的100，170是字符串的左下角，其他的方法对应的是左上角
        g.drawString("LilHan",100,170);
    }
}
