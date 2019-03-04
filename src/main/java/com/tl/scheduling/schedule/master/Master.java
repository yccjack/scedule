package com.tl.scheduling.schedule.master;

import com.tl.scheduling.schedule.listener.Observer;
import com.tl.scheduling.schedule.task.AbstractTask;
import com.tl.scheduling.schedule.task.DefaultTask;
import com.tl.scheduling.schedule.util.ExecutorServiceUtil;
import com.tl.scheduling.schedule.woker.AbstractWorker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 持有任务队列的Master，并且同时是子任务的观察者，和Worker共同持有任务队列，结果集Map
 *
 * @author :MysticalYcc
 * @date :11:14 2019/2/27
 */


public class Master implements Observer {
    private AtomicInteger count = new AtomicInteger(0);
    /**
     * 1、承装任务的集合
     */
    private ConcurrentLinkedQueue<AbstractTask> workQueue = new ConcurrentLinkedQueue<>();
    /**
     * 2.使用hashMap装所有的worker对象；
     */
    private HashMap<String, Thread> workers = new HashMap<>(16);

    /**
     * 3、使用一个容器承装每一个worker并发执行结果
     */
    ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>(16);

    public Master(AbstractWorker worker, int workerCount) {
        // 每一個worker都需要有Master的引用用於任務的領取
        worker.setWorkQueue(this.workQueue);
        // 用於任務的提交
        worker.setResultMap(resultMap);
        for (int i = 0; i < workerCount; i++) {
            // key每一个worker的名字,value线程执行对象
            workers.put("子节点" + i, new Thread(worker));
        }
    }

    /**
     *
     * @param task
     */
    public void submit(AbstractTask task) {
        this.workQueue.add(task);
    }

    /**
     * 6、需要一个执行的方法(启动应用程序，让所有的worker工作)
     */
    public void execute() {
        for (Map.Entry<String, Thread> me : workers.entrySet()) {
            me.getValue().start();
        }
    }

    /**
     * 8、判断线程是否执行完毕
     *
     * @return
     */
    public boolean isComplete() {
        for (Map.Entry<String, Thread> me : workers.entrySet()) {
            if (me.getValue().getState() != Thread.State.TERMINATED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 返回结果集数据
     *
     * @return
     */
    public AbstractTask getResult() {
        return null;
    }

    @Override
    public void update(Object message) {
        try {
            Thread.sleep(1000);
            //todo
            System.out.println(Thread.currentThread().getName() + ":" + message);
            count.incrementAndGet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count.get() == workers.size()) {
            //todo
            for (Map.Entry<String, Object> result : resultMap.entrySet()) {
                System.out.println(result.getValue());
            }
            System.out.println("全部任务已完成");
        }
    }
}