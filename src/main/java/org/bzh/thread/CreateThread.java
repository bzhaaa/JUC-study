package org.bzh.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class CreateThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(
                () -> {
                    log.info("t1 is running");
                    return 1;
                }
        );
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();
        log.info("Main........");
        log.info("futureTask.get()" + "=================" + futureTask.get());
    }
}
