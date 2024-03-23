package File;

import java.io.File;

public class Directory {

    public static void main(String[] args) {

    }

    public void m1(){
        //判断桌面news1.txt是否存在，存在则删除
        String filePath = "Desktop:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()){
            file.delete();  //delete方法返回布尔值
        }else {
            System.out.println("该文件不存在");
        }
    }

    public void m2(){
        //在Java编程中目录也被当做是文件
        String direcotoryPath = "Desktop:\\PIGGY\\a\\b\\c";
        File file = new File(direcotoryPath);
        if (file.exists()){
            file.delete();  //delete方法返回布尔值
        }else {
            System.out.println("该目录不存在，创建该目录");
            file.mkdirs(); //mkdir是创建一级目录，mkdirs是创建多级目录
        }
    }
}

