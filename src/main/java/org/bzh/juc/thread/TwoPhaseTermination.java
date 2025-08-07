package org.bzh.juc.thread;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * 两阶段终止模式
 */

public class TwoPhaseTermination {
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        monitor.start();
        Thread.sleep(5000);
        monitor.stop();
    }

    public static class Monitor {
        Logger logger = LoggerFactory.getLogger(Monitor.class);

        private Thread monitor;

        public void start() {
            monitor = new Thread(() -> {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        logger.info("monitor thread interrupted.. 处理后事");
                        break;
                    } else {
                        try {
                            Thread.sleep(1000);
                            logger.info("monitor thread running..");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            });
            monitor.start();
        }

        public void stop() {
            monitor.interrupt();
        }
    }
}
