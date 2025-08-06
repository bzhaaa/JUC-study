package org.bzh.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * interrupt()方法打断阻塞线程（sleep、join、wait）时，打断标记interrupted会被清空。置成fasle
 */
public class Interrupt1 {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Interrupt1.class);

        Thread t1 = new Thread(() -> {
            logger.info("t1 sleep...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
        logger.info("t1 interrupted..");
        logger.info("t1 isInterrupted:{}", t1.isInterrupted());
    }
}
