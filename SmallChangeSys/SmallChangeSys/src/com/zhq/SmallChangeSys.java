package com.zhq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    //完成显示菜单并且可以选择
    public static void main(String[] args) {

        //定义相关变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //完成零钱通明细
        //1.可以把收益入账和消费保存到数组（需考虑动态增长问题）2.可以使用对象 3.可以使用String拼接

        String details = "====零钱通明细====";

        //完成收益入账
        //定义新变量完成收入、时间、余额等
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //用于日期格式化

        //消费功能实现
        String note = "";


        do {
            System.out.println("\n====零钱通菜单====");
            System.out.println("\t\t\t1.零钱通明细");
            System.out.println("\t\t\t2.收益入账");
            System.out.println("\t\t\t3.消费情况");
            System.out.println("\t\t\t4.退出系统");

            System.out.println("请选择1-4…");
            key = scanner.next();

            //使用switch分治控制
            switch (key){
                case  "1" :
                    System.out.println(details);
                    break;
                case  "2" :
                    System.out.println("本次收益入账金额：");
                    money = scanner.nextDouble();

                    balance += money;  //拼接收益入账到details
                    date = new Date();  //获取当前的日期
                    details += "\n收益入账\t" + money + "\t" + sdf.format(date) + "\t" + balance;

                    break;
                case  "3" :
                    System.out.println("本次消费金额：");
                    money = scanner.nextDouble();
                    System.out.println("消费说明：");
                    note = scanner.next();
                    balance -= money;

                    date = new Date();
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;

                    break;
                case  "4" :
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

                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }

        }while(loop);

        System.out.println("零钱通系统已退出");

        scanner.close();

    }
}
