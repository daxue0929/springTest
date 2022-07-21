package com.daxue.firstboot;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author daxue0929
 * @date 2022/7/21
 */


public class ThreadTest {


    @Test
    public void completableFutureBuildTest() throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName());
                //暂停几秒钟线程
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable, threadPool);
        System.out.println(completableFuture.get());
    }

    @Test
    public void test01() throws ExecutionException, InterruptedException {
        final ExecutorService threadPool = Executors.newFixedThreadPool(3);
        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                //暂停几秒钟线程
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "有返回值";
        }, threadPool);
        String s = completableFuture.get();
        System.out.println(s);

    }
}
