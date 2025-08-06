package org.bzh.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

/**
 * 主线程等待Join的线程结束后才会继续向下执行
 */
public class Join1 {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Join1.class);

        Thread t1 = new Thread(() -> {
            logger.info("t1  running.......");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            logger.info("t2  running.......");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
        long start = System.currentTimeMillis();
        t1.join();
        logger.info("t1 is done");
        t2.join();
        logger.info("t2 is done");
        long end = System.currentTimeMillis();
        logger.info("t1 and t2 are done, cost:{}", end - start);
    }


}
