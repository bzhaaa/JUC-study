package org.bzh.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Thread.sleep;

/**
 * join限时等待
 */
public class Join2 {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Join2.class);
        Thread t1 = new Thread(() -> {
            logger.info("t1 start");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            logger.info("t1 end");
        }, "t1");
        t1.start();
        t1.join(1000);
        logger.info("main is done");

    }
}
