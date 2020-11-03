package com.github.ioridazo.asyncsample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {

    @Bean("Thread")
    public Executor executor(){
        final var executor = new ThreadPoolTaskExecutor();
        // コアスレッド数
        executor.setCorePoolSize(10);
        // コアスレッドが上限になると、キューイングする数
        executor.setQueueCapacity(10);
        // キューイング数の上限を超えると、退避する数
        executor.setMaxPoolSize(100);
        executor.setThreadNamePrefix("Thread--");
        executor.initialize();
        return executor;
    }

    @Bean("ThreadTester")
    public Executor testExecutor(){
        final var executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setQueueCapacity(1000);
        executor.setMaxPoolSize(100);
        executor.setThreadNamePrefix("Test--");
        executor.initialize();
        return executor;
    }
}
