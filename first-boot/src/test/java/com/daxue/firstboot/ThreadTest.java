package com.daxue.firstboot;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author daxue0929
 * @date 2022/7/21
 */


public class ThreadTest {

    /**
     * java8新引入了CompletableFuture，它是Future的功能增强版，减少阻塞和轮询。可以传入回调对象，
     * 当异步任务完成或者发生异常时，自动调用回调对象的回调方法。
     *
     * CompletableFuture优点：
     *  1. 异步任务结束后，会自动回调某个对象方法
     *  2. 主线程设置好回调后，不在关心异步任务的执行，  异步任务之间可以顺序执行。
     *  3. 异步任务出错时，会自动回调某个对象的方法。
     *
     *  Executor executor参数说明，没有指定Executor的方法，直接使用默认的ForkJoinPool.commonPool作为它的线程池。
     *  如果指定了线程池，就使用我们自定义的线程池或者特别指定的线程池执行异步代码。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */

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
        // 创建一个线程池
        final ExecutorService threadPool = Executors.newFixedThreadPool(3);
        final CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());

            //暂停几秒钟线程
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            int result = ThreadLocalRandom.current().nextInt(10);
            return result;
        }, threadPool).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("计算完成，更新系统任务状态。");
            }
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println("异常情况:" + e.getCause() + "\t" + e.getMessage());
            return null;
        });
        final Integer integer = completableFuture.get();
        System.out.println(integer);
    }

    //案例
    @Test
    public void caseCompletableFutureTest() {


    }
}
