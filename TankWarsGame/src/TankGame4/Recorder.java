package TankGame4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Recorder {//用于记录相关信息，会和文件交互

    private static int allEnemyTanksNum = 0;
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    private static String recordFile = "src/TankGame4/myRecode.txt";

    //当游戏退出时，将进度保存在文件中
    public static void keepRecord() throws IOException {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(Integer.toString(allEnemyTanksNum));
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (bw != null){
                bw.close();
            }
        }
    }

    public static int getAllEnemyTanksNum() {
        return allEnemyTanksNum;
    }

    public static void setAllEnemyTanksNum(int allEnemyTanksNum) {
        Recorder.allEnemyTanksNum = allEnemyTanksNum;
    }

    public static void addAllEnemyTankNum(){
        Recorder.allEnemyTanksNum++;
    }
}
