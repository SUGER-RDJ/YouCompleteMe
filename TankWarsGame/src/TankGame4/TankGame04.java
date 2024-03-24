package TankGame4;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class TankGame04 extends JFrame {

    MyPanel mp = null;

    public static void main(String[] args) {

        TankGame04 game1 = new TankGame04();
        game1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public TankGame04(){
        mp = new MyPanel();
        //将mp放入到Thread并启动
        Thread thread = new Thread(mp);
        thread.start();
        this.add(mp); //加入面板（即游戏绘图区域）
        this.setSize(1300,950);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //在JFrame中增加关闭窗口处理
        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Recorder.keepRecord();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.exit(0);
            }
        });
    }
}
