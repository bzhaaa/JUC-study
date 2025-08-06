package org.bzh.thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 1.run()方法会在主线程中执行，start()方法会在t1线程中执行
 * 2.new玩一个线程，线程处于NEW状态，调用start()方法，线程进入RUNNABLE状态
 */

public class StartVsRun {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(StartVsRun.class);

        Thread t1 = new Thread( () -> {
            logger.info("running.......");
        }, "t1");

 //       t1.run();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
    }
}
