package com.tl.scheduling.schedule.util;

import java.util.concurrent.*;

/**
 * @author :MysticalYcc
 * @date :15:30 2019/3/1
 */
public class ExecutorServiceUtil {
    /**
     * 等待子线程超时时间
     */
    private static final int AWAIT_TIME = 500;
    /**
     * 设置线程数量
     */
    private static final int THREAD_NUM = Runtime.getRuntime().availableProcessors() * 2;

    private static Object obj = new Object();

    private static ExecutorService executor = null;

    private ExecutorServiceUtil() {

    }

    /**
     * 获得一个固定线程池对象executor </br> 线程池数量设定 {@link ExecutorServiceUtil#THREAD_NUM}
     *
     * @return ExecutorService
     */
    public static ExecutorService getExecutorServiceInstance() {
        if (executor == null) {
            synchronized (obj) {
                if (executor == null) {
                    ThreadFactory threadFactory = new CustomThreadFactoryBuilder().setNamePrefix("Schedule-Thread").setDaemon(false)
                            .setPriority(Thread.MAX_PRIORITY).build();
                    executor = new ThreadPoolExecutor(4,
                            10,
                            0,
                            TimeUnit.SECONDS,
                            new ArrayBlockingQueue<Runnable>(100),
                            threadFactory
                    );
                }
            }
        }
        return executor;
    }

    /**
     * 重置线程池
     */
    public static void restartExecutor() {
        executor = null;
        getExecutorServiceInstance();
    }

    /**
     * 关闭并等待子线程在指定时间内来完成处理</br> 时间设定 {@link ExecutorServiceUtil#AWAIT_TIME} </br> 超时强制关闭子线程</br>
     *
     * @throws RuntimeException 异常会强制立即关闭子线程 抛出异常
     */
    public static void shutDown() {
        executor.shutdown();
        try {
            executor.awaitTermination(AWAIT_TIME, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            shutDownNowAndRestart();
            throw new RuntimeException("SP-SERVICE-ExecutorServiceUtil.shutDown", e);
        }
    }

    /**
     * 立即关闭子线程并重置线程池
     */
    public static void shutDownNowAndRestart() {
        executor.shutdownNow();
        restartExecutor();
    }
}
