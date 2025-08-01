package org.bzh.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    log.info("t1 enter sleep");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.info("t1 wake up");
                }
            }
        };
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
