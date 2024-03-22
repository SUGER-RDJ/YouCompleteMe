package TankGame2;

import javax.swing.*;

public class TankGame02 extends JFrame {

    MyPanel mp = null;
    public static void main(String[] args) {

        TankGame02 game1 = new TankGame02();

    }
    public TankGame02(){
        mp = new MyPanel();
        this.add(mp); //加入面板（即游戏绘图区域）
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
