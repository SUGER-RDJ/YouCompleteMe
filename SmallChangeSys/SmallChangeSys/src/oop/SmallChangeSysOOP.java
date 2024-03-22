package oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSysOOP {
    //完成各个功能
    //属性
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    String details = "====零钱通明细====";

    double money = 0;
    double balance = 0;
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //用于日期格式化

    String note = "";

    public void mainMenu(){  //显示零钱通菜单
        do {
            System.out.println("\n====选择零钱通菜单(OOP)====");
            System.out.println("\t\t\t1.零钱通明细");
            System.out.println("\t\t\t2.收益入账");
            System.out.println("\t\t\t3.消费情况");
            System.out.println("\t\t\t4.退出系统");

            System.out.println("请选择1-4…");
            key = scanner.next();

            //使用switch分治控制
            switch (key){
                case  "1" :
                    this.details();
                    break;
                case  "2" :
                    this.income();
                    break;
                case  "3" :
                    this.pay();
                    break;
                case  "4" :
                    this.exit();
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }

        }while(loop);
    }

    public void details(){   //完成零钱通明细
        System.out.println(details);
    }

    public void income(){
        System.out.println("本次收益入账金额：");
        money = scanner.nextDouble();

        balance += money;  //拼接收益入账到details
        date = new Date();  //获取当前的日期
        details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    public void pay(){
        System.out.println("本次消费金额：");
        money = scanner.nextDouble();
        System.out.println("消费说明：");
        note = scanner.next();
        balance -= money;

        date = new Date();
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
    }

    public void exit(){
        String choice = "";
        while (true){
            System.out.println("确定退出？ y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)){
                break;
            }
        }
        if(choice.equals("y")){
            loop = false;
        }

    }

}
