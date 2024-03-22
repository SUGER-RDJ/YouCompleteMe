package TankGame3;

import javax.swing.*;

public class TankGame03 extends JFrame {

    MyPanel mp = null;
    public static void main(String[] args) {

        TankGame03 game1 = new TankGame03();

    }
    public TankGame03(){
        mp = new MyPanel();
        //将mp放入到Thread并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp); //加入面板（即游戏绘图区域）
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
