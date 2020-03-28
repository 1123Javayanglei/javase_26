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
        Seller seller = new Seller();
        seller.setName("武大郎");
        seller.bakedWheatCake = bakedWheatCake;

        Seller seller1 = new Seller();
        seller1.setName("武二郎");
        seller1.bakedWheatCake=bakedWheatCake;

        Buyer buyer = new Buyer();
        buyer.setName("西门庆");
        buyer.bakedWheatCake = bakedWheatCake;

        Buyer buyer1 = new Buyer();
        buyer1.setName("东门庆");
        buyer1.bakedWheatCake = bakedWheatCake;

        seller.start();
        seller1.start();
        buyer.start();
        buyer1.start();



    }
}

class BakedWheatCake {
    /**
     * @date: 2020/3/28 6:28 下午
     * @description: TODO 记录烧饼
     */
    int number;
    // 记录烧饼的数量
    boolean b = false;
    // 记录烧饼的状态，是否有烧饼
}

class Seller extends Thread {
    /**
     * 卖家 seller
     */
    BakedWheatCake bakedWheatCake;

    @Override
    public void run() {
        while (true) {
            synchronized (bakedWheatCake) {
                if (!bakedWheatCake.b) {
                    // 如果没有烧饼，做烧饼
                    System.out.println(Thread.currentThread().getName() + "开始做烧饼 " + (bakedWheatCake.number + 1));
                    bakedWheatCake.number++;
                    System.out.println(Thread.currentThread().getName() + " 烧饼制作完成编号 " + bakedWheatCake.number);
                    bakedWheatCake.b = true;
                    // 做好了之后改变烧饼的状态
                    bakedWheatCake.notify();
                    // 唤醒
                    try {
                        bakedWheatCake.wait();
                        // 等待
                    } catch (Exception ignored) {

                    }
                }
            }
        }
    }
}

class Buyer extends Thread {
    /**
     * 买家
     */
    BakedWheatCake bakedWheatCake;

    @Override
    public void run() {
        while (true) {
            synchronized (bakedWheatCake) {
                if (bakedWheatCake.b) {
                    // 有烧饼
                    System.out.println(Thread.currentThread().getName() + " 开始吃烧饼 " + (bakedWheatCake.number));
                    System.out.println(Thread.currentThread().getName() + " 吃完烧饼 " + (bakedWheatCake.number));
                    bakedWheatCake.b = false;
                    // 改变烧饼的状态
                    bakedWheatCake.notify();
                    // 唤醒对方
                    try {
                        bakedWheatCake.wait();
                        // 等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }

    }
}

