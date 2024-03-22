package TankGame;

import javax.swing.*;

public class TankGame1 extends JFrame {

    MyPanel mp = null;
    public static void main(String[] args) {

        TankGame1 game1 = new TankGame1();

    }
    public TankGame1(){
        mp = new MyPanel();
        this.add(mp); //加入面板（即游戏绘图区域）
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
