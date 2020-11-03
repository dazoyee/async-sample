package com.github.ioridazo.asyncsample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class AsyncService {

    @Async("Thread")
    public CompletableFuture<Void> executeFirst() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("executeFirst");
        return null;
    }

    @Async
    public CompletableFuture<Void> executeSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("executeSecond");
        return null;
    }

    @Async("ThreadTester")
    public CompletableFuture<Void> executeOther() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("executeOther");
        return null;
    }

//    @Async("Thread")
    public void executeLast() {
        log.info("executeLast");
    }
}
