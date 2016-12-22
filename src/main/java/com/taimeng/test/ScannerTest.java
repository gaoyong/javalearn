package com.taimeng.test;

import java.util.Scanner;

/**
 * Created by gaoyong on 2016/12/20.
 */
public class ScannerTest {

    public static void customShow(String str){
        for(int i = 0;i < str.length();i++){
            System.out.print(str.charAt(i));
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String [] args){



        Scanner scanner = new Scanner(System.in);
        System.out.println("     _______.___________.    ___      .______         \n" +
                "    /       |           |   /   \\     |   _  \\        \n" +
                "   |   (----`---|  |----`  /  ^  \\    |  |_)  |       \n" +
                "    \\   \\       |  |      /  /_\\  \\   |      /        \n" +
                ".----)   |      |  |     /  _____  \\  |  |\\  \\----.   \n" +
                "|_______/       |__|    /__/     \\__\\ | _| `._____|   \n" +
                "                                                    ");
        System.out.println("****************|^^|庆祝大灰狼和小红帽相识整一个月|^^|***********************");
        System.out.println("please input some words ,Little Red Riding Hood");
        System.out.println("请输入下列词语之一，大灰狼 | 小红帽 | 小王子 | 小狐狸");
        System.out.println("输入 exit 离开");
        while (true){
            String input = scanner.nextLine();
            switch (input){
                case "exit":
                    System.out.println("bye bye ,Little Red Riding Hood");
                    //TODO 待优化
                    System.exit(0);
                    break;
                case "小红帽":
                    customShow("在爱的灰烬中不断重生");
                    System.out.println("_______.__         ____         __    .___________.  .___________.  .___________.\n" +
                            "    /       |\\ \\       / /\\ \\       / /   / /---------/  / /---------/  /------------/\n" +
                            "   |   (----` \\ \\     / /  \\ \\     / /   / /_________.  / /_________.       / /\n" +
                            "    \\   \\      \\ \\   / /    \\ \\   / /   / /---------/  / /---------/       / /\n" +
                            ".----)   |      \\ \\ / /      \\ \\ / /   / /__________  / /__________       / /     *\n" +
                            "|_______/        \\_\\_/        \\_\\_/   /_/__________/ /_/__________/      /_/");
                    break;
                case "大灰狼":
                    customShow("\"爱一种危险的自我打开\"");
                    customShow("我给你我的寂寞,");
                    customShow("我的黑暗、我心的饥渴,");
                    customShow("我在试图打动你，");
                    customShow("用无常，用危险，用失败。");
                    break;
                case "小王子":
                    customShow("你要是驯养了我，我俩就彼此需要对方了。");
                    break;
                case "小狐狸":
                    customShow("对你驯养过的东西，你永远负有责任。你必须对你的玫瑰负责");
                    break;
                default:
                    System.out.println("小红帽输入有误，输入以下下列词语之一，大灰狼 | 小红帽 | 小王子 | 小狐狸");
            }

        }
    }
}
