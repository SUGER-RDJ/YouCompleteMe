package Buffered_;

import java.io.*;

/**
 * 完成图片，音乐，视频等的拷贝
 * 使用Buffered字节处理流
 * 字节流可以操作二进制文件也可以操作文本文件
 *
 */
public class BufferedCopy02 {
    public static void main(String[] args) throws IOException {
        String srcFilePath = "src/Text/01.jpeg";
        String destFilePath = "src/Text/03.jpeg";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            //FileInputStream是InputStream子类
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

            byte[] buff = new byte[1024];
            int readLen = 0;
            while ((readLen = bis.read(buff)) != -1){  //返回-1表示文件读取完毕
                bos.write(buff,0,readLen);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (bis != null){
                bis.close();
            }
            if (bos != null){
                bos.close();
            }
        }
    }
}
