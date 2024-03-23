package IOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) throws IOException {
        //文件拷贝：将Text文件夹下的图片拷贝到File
        //创建文件输入流，将文件读入到程序
        //创建文件输出流，将读取到的文件数据写入到指定的文件

        String srcFilePath = "src/Text/01.jpeg";
        String destFilePath = "src/Text/02.jpeg";
        FileInputStream stream1 = null;
        FileOutputStream stream2 = null;

        try {
            stream1 = new FileInputStream(srcFilePath);
            stream2 = new FileOutputStream(destFilePath);
            //定义一个字节数组，提高读取效率
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = stream1.read(buf)) != -1){
                //边读边写
                stream2.write(buf,0,readLen);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (stream1 != null){
                stream1.close();
            }
            if (stream2 != null){
                stream2.close();
            }
        }
    }
}
