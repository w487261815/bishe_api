package cn.pji.shuzu;

import java.util.Scanner;

class Work1 {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Game g = new Game();
        g.initial();// 调用初始化方法
        g.startGame();// 调用开始游戏的方法
    }

}

class User {
    static String userName;// 用户名
    int score;// 积分

    public int showFirst() {
        System.out.print(User.userName + "（请出拳:1：剪刀2：石头3：布）:");
        Scanner sc = new Scanner(System.in);
        int choice=0 ;
        for (int i = 0;i<5; i++) {
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(User.userName + "出的是：剪刀");
                    break;
                case 2:
                    System.out.println(User.userName + "出的是：石头");
                    break;
                case 3:
                    System.out.println(User.userName + "出的是：布");
                    break;
                default:
                    System.out.println("请输入1-3的数字");
                    continue;
            }
        }
        return choice;
    }
}

class Computer {
    String computerName;// 电脑名
    int score;// 电脑积分

    public int chuQuan() {
        int random = (int) (Math.random() * 3) + 1;
        switch (random) {
            case 1:
                System.out.println(computerName + "出的是：剪刀");
                break;
            case 2:
                System.out.println(computerName + "出的是：石头");
                break;
            case 3:
                System.out.println(computerName + "出的是：布");
                break;
            default:
                System.out.println("请输入1-3的数字");
                break;
        }
        return random;
    }
}

class Game {
    Scanner sc = new Scanner(System.in);
    User User;// 用户玩家
    Computer Computer;// 电脑玩家
    int count;// 对战次数
    int score;// 分数
    int gamescore;

    //游戏类的初始化方法
    public void initial() {
        // 创建用户对象
        User = new User();
        // 创建电脑对象
        Computer = new Computer();
        // 初始化对战次数为0
        count = 0;
    }

    //开始游戏的方法
    public void startGame() {
        System.out.println("---------------------欢迎进入游戏世界---------------------\n\n");
        System.out.print("*********");
        System.out.print("\t猜\t拳\t开\t始\t ");
        System.out.println("*********");
        System.out.println("出拳规则：1.剪刀 2.石头 3.布");
        System.out.print("请选着对方角色(1:深蓝 2:银河 3:天河)");
        int choose01 = sc.nextInt();// 接收用户选择的角色
        switch (choose01) {
            case 1:
                Computer.computerName = "深蓝";// 把值赋给电脑类的name
                break;
            case 2:
                Computer.computerName = "银河";
                break;
            case 3:
                Computer.computerName = "天河";
                break;
            default:
                System.out.println("请输入1-3的数字");
                break;
        }
        System.out.print("请选着对方角色(1:刘备 2:孙权 3:曹操)");
        int choose02 = sc.nextInt();// 接收用户选择的角色
        switch (choose02) {
            case 1:
                User.userName = "刘备";// 把值赋给电脑类的name
                break;
            case 2:
                User.userName = "孙权";
                break;
            case 3:
                User.userName = "曹操";
                break;
            default:
                System.out.println("请输入1-3的数字");
                break;
        }
        System.out.println("游戏开始....");
        String con;
        int perFist;// 用户出的拳
        int comFist;// 计算机出的拳
        do {
            // 出拳
            perFist = User.showFirst();// 调用用户类的方法
            comFist = Computer.chuQuan();// 调用电脑类的方法
            // 裁决
            if ((perFist == 1 && comFist == 1) || (perFist == 2 && comFist == 2) || (perFist == 3 && comFist == 3)) {
                System.out.println("和局" + User.userName + "加油啊！");
                gamescore++;// 平局
            } else if ((perFist == 1 && comFist == 3) || (perFist == 2 && comFist == 1)
                    || (perFist == 3 && comFist == 2)) {
                System.out.println(Computer.computerName + "赢了！");
                Computer.score++;// 记录电脑赢的分数
            } else {
                System.out.println("恭喜" + User.userName + "，你赢了！");
                User.score++;// 记录用户赢的分数
            }
            count++;// 对战次数依次加一
            System.out.print("是否要继续玩（yes/no）:");
            con = sc.next();
        } while (con.equals("yes"));
        // 如果结束 则显示最后的结果
        showResult();
    }

    // 显示最后的输出结果
    public void showResult() {
        System.out.println("*******************************************");
        System.out.println(User.userName + "\tVS\t" + Computer.computerName);
        System.out.println("对战次数：" + count);
        System.out.println(User.userName + "赢次数：\t" + User.score);
        System.out.println(Computer.computerName + "赢次数：\t" + Computer.score);
        System.out.println("和局赢次数：\t" + gamescore);
        if (User.score > Computer.score) {// 如果用户的分数大于电脑的分数 则用户赢
            System.out.println("本次对战赢家是【" + User.userName + "】");
        } else if (User.score < Computer.score) {
            System.out.println("本次对战赢家是【" + Computer.computerName + "】");
        } else {
            System.out.println("本次对战，没有分出胜负下次再战");
        }
        System.out.println("*******************************************");
    }
}