package org.bzh.thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class CreateThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Logger logger = LoggerFactory.getLogger(CreateThread.class);

        FutureTask<Integer> futureTask = new FutureTask<Integer>(
                () -> {
                    logger.info("t1 is running");
                    return 1;
                }
        );
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();
        logger.info("Main........");
        logger.info("futureTask.get()" + "=================" + futureTask.get());
    }
}
