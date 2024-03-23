package File;

import java.io.File;
import java.io.IOException;

/**
 * 创建新文件
 */
public class createFile {
    public static void main(String[] args) {

    }

    //方式1:
    public void create01(){
        String filePath = "Desktop:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //方式2:
    public void create02(){
        File parentFile = new File("Desktop:\\");
        String fileName = "news2.txt";
        //这里的file对象在Java程序中只是一个对象，只有执行了createNewFile方法才会真正在磁盘中创建该文件
        File file = new File(parentFile,fileName);
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //方式3
    public void create03(){
        String parentPath = "Desktop:\\"; //两个反斜杠中有一个为转义符
        String fileName = "news3.txt";
        File file = new File(parentPath,fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
