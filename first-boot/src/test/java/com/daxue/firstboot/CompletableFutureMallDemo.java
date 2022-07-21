package com.daxue.firstboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Test;
import sun.nio.ch.Net;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author daxue0929
 * @date 2022/7/21
 */

public class CompletableFutureMallDemo {

    @Test
    public void chainTest() {
        final Student student = new Student();
        student.setId(1).setName("大雪").setMajor("计算机科学");
    }

    @Test
    public void getJoinTest() {
        final ExecutorService threadPool = Executors.newFixedThreadPool(5);
        final CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            return "hello 1234";
        }, threadPool);
//        1. get() 会在编译阶段抛出异常，必须处理。
//        try {
//            completableFuture.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        //join() 不会在编译阶段抛出异常。其他和get()几乎是一样的。
        completableFuture.join();
    }



    // 案例测试
    List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("淘宝")
    );

    @Test
    public void main() {
        //1. step by step
        long startTime = System.currentTimeMillis();
        List<String> result = getPriceListWithStep(list, "mysql");
        for (String item: result) {
            System.out.println(item);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("花费的时间是: " + (endTime-startTime));
        System.out.println("----------------------------分割线--------------------------------------");
    }


    @Test
    public void main2() {
        long startTime = System.currentTimeMillis();
        List<String> result = getPriceWithCompletableFuture(list, "mysql");
        for (String item: result) {
            System.out.println(item);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("花费的时间是: " + (endTime-startTime));
    }


    List<String> getPriceWithCompletableFuture(List<NetMall> list, String projectName) {
        final List<String> secondList = list.stream().map(netMall -> CompletableFuture.supplyAsync(
                () -> String.format(projectName + " in %s price is %.2f",
                        netMall.getNetMallName(),
                        netMall.calcPrice(projectName)))
        ).collect(Collectors.toList()).stream().map(s -> s.join()).collect(Collectors.toList());
        for (String item: secondList) {
            System.out.println(item);
        }
        return secondList;
    }

    public List<String> getPriceListWithStep(List<NetMall> list, String projectName) {
        final List<String> result = list.stream().map(netMall ->
                String.format(projectName + " in %s price is %.2f", netMall.getNetMallName(), netMall.calcPrice(projectName)))
                .collect(Collectors.toList());
        return result;
    }
}


@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
class NetMall {

    @Getter
    public String netMallName;

    public double calcPrice(String projectName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + projectName.charAt(0);
    }

}


@AllArgsConstructor
@NoArgsConstructor
@Data
//链式调用
@Accessors(chain = true)
class Student {
    private Integer id;
    private String name;
    private String major;
}