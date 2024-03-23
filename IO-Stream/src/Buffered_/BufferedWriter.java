package Buffered_;

import java.io.FileWriter;

/**
 * BufferedWriter案例演示
 * BufferedReader和BufferedWriter是按字符操作，不要读取二进制文件（图片，视频，音频等）可能造成文件损坏
 */
public class BufferedWriter {
    public static void main(String[] args) throws Exception{

//        new FileWriter(filePath,true);表示以追加方式插入
//        new FileWriter(filePath); 表示以覆盖方式插入
        String filePath = "src/Text/hello.txt";
        java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new FileWriter(filePath));
        bufferedWriter.write("赵牛逼超屌编程");
        //通常插入一个换行符,根据系统决定换行符类型
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
