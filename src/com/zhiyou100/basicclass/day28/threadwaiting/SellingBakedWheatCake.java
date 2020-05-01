package com.zhiyou100.basicclass.day28.threadwaiting;

/**
 * @packageName: javase_26
 * @className: SellingBakedWheatCake
 * @Description: TODO 卖烧饼，一个线程卖烧饼，一个线程买烧饼：实现现做现卖
 * @author: YangLei
 * @date: 2020/3/28 6:26 下午
 */
public class SellingBakedWheatCake {
    public static void main(String[] args) {
        BakedWheatCake bakedWheatCake = new BakedWheatCake();
        // 创建烧饼类
        Seller seller = new Seller();
        seller.setName("武大郎");
        seller.bakedWheatCake = bakedWheatCake;
        // 创建卖烧饼的类，取个名字为武大郎，把烧饼赋值给卖方

        Seller seller1 = new Seller();
        seller1.setName("武二郎");
        seller1.bakedWheatCake = bakedWheatCake;
        // 创建卖烧饼的类，取个名字为武二郎，把烧饼赋值给卖方


        Buyer buyer = new Buyer();
        buyer.setName("西门庆");
        buyer.bakedWheatCake = bakedWheatCake;
        // 创建买烧饼的类，取个名字为西门庆，把烧饼赋值给买方


        Buyer buyer1 = new Buyer();
        buyer1.setName("东门庆");
        buyer1.bakedWheatCake = bakedWheatCake;
        // 创建买烧饼的类，取个名字为东门庆，把烧饼赋值给买方


        seller.start();
        seller1.start();
        buyer.start();
        buyer1.start();
        // 开启线程


    }
}

class BakedWheatCake {
    /**
     * @date: 2020/3/28 6:28 下午
     * @description: TODO 烧饼类，记录烧饼的数量和状态
     */
    int number;
    /**
     * 记录烧饼的数量
     */
    boolean b = false;
    // 记录烧饼的状态，是否有烧饼，默认是没有烧饼
}

class Seller extends Thread {
    /**
     * @date: 2020/4/8 11:40 下午
     * @description: TODO 卖家 seller
     */

    BakedWheatCake bakedWheatCake;

    /**
     * 定一个烧饼的引用接收烧饼
     */

    @Override
    public void run() {
        /*
         * @name: run
         * @date: 2020/4/8 11:41 下午
         * @description: TODO 卖烧饼
         */
        while (true) {
            synchronized (bakedWheatCake) {
                // 使用烧饼类的引用作为线程锁🔒
                if (!bakedWheatCake.b) {
                    // 如果没有烧饼，做烧饼
                    System.out.println(Thread.currentThread().getName() + "开始做烧饼 " + (bakedWheatCake.number + 1));
                    bakedWheatCake.number++;
                    // 烧饼数+1
                    System.out.println(Thread.currentThread().getName() + " 烧饼制作完成编号 " + bakedWheatCake.number);
                    bakedWheatCake.b = true;
                    // 做好了之后改变烧饼的状态
                    bakedWheatCake.notify();
                    // 唤醒吃烧饼的线程
                    try {
                        bakedWheatCake.wait();
                        // 当前线程停止
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Buyer extends Thread {
    /**
     * @description: TODO  买烧饼
     */
    BakedWheatCake bakedWheatCake;

    /**
     * 定义一个烧饼类型的引用用来接收烧饼
     */
    @Override
    public void run() {
        while (true) {
            synchronized (bakedWheatCake) {
                // 用烧饼作为线程🔒
                if (bakedWheatCake.b) {
                    // 有烧饼
                    System.out.println(Thread.currentThread().getName() + " 开始吃烧饼 " + (bakedWheatCake.number));
                    System.out.println(Thread.currentThread().getName() + " 吃完烧饼 " + (bakedWheatCake.number));
                    bakedWheatCake.b = false;
                    // 改变烧饼的状态
                    bakedWheatCake.notify();
                    // 唤醒做烧饼的线程
                    try {
                        bakedWheatCake.wait();
                        // 当前线程等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }

    }
}

