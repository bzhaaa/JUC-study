package org.bzh.thread;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 被打断的线程会抛出InterruptedException
 */
public class Sleep {

    public static void main(String[] args) throws InterruptedException {

        Logger logger = LoggerFactory.getLogger(Sleep.class);
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    logger.info("t1 enter sleep");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    logger.info("t1 wake up");
                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
