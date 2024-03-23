package ReaderAndWriter;

import java.io.IOException;

public class FileWriter {
    public static void main(String[] args) throws IOException {

        String filePath = "src/Text/TXT02.txt";
        java.io.FileWriter fileWriter = null;
        char[] chars = {'a','b','c'};

        try {

            fileWriter = new java.io.FileWriter(filePath,true);
            fileWriter.write('H'); //写入单个字符
            fileWriter.write(chars); //写入指定数组
            fileWriter.write("赵牛逼超屌编程".toCharArray(),0,3);  //写入指定数组的指定部分

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            //对应FileWriter一定要关闭流或者false才能真正将数据写入文件
            fileWriter.close();
        }

    }
}
