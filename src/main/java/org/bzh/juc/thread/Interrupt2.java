package org.bzh.juc.thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * interrupt打断正常线程，正常线程不会受影响，只是打断标记会变成 true，可以利用打断标记来处理线程
 */
public class Interrupt2 {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Interrupt2.class);

        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    logger.info("t1 interrupted..");
                    break;
                }
            }
        }, "t1");
        t1.start();
        logger.info("t1 start..");
        Thread.sleep(2000);
        logger.info("interrupt t1....");
        t1.interrupt();
    }
}
