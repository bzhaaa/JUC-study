package org.bzh.juc.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 守护线程会在其它非守护线程结束后强行结束自己（不会等自己的线程处理完再结束）
 */
public class Daemon {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Daemon.class);

        Thread t1 = new Thread(() -> {
            logger.info("t1 start...");
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
        }, "t1");
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(2000);
        logger.info("main thread exit...");
    }
}
