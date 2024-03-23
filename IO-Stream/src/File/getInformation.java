package File;
import java.io.File;

public class getInformation {
    public static void main(String[] args) {

    }

    //获取文件信息
    public void info(){
        File file = new File("Desktop:\\PIGGY");

        System.out.println("文件名" + file.getName());
        System.out.println("绝对路径" + file.getAbsolutePath());
        System.out.println("父级目录" + file.getParent());
        System.out.println("文件大小（字节）" + file.length());
        System.out.println("是否存在" + file.exists());
        System.out.println("是否为一个文件" + file.isFile());
        System.out.println("是否是一个目录" + file.isDirectory());

    }
}
