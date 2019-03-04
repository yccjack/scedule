package com.tl.scheduling.schedule.woker;

import com.tl.scheduling.schedule.listener.Observer;
import com.tl.scheduling.schedule.listener.Observerable;
import com.tl.scheduling.schedule.task.AbstractTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author :MysticalYcc
 * @date :11:16 2019/2/27
 */
public abstract class AbstractWorker implements Runnable, Observerable {
    protected ConcurrentHashMap<String, Object> resultMap;
    protected ConcurrentLinkedQueue<AbstractTask> workQueue;
    /**
     * 注册需要通知的类的集合
     */
    protected final List<Observer> list;

    public AbstractWorker() {
        list = new ArrayList<>(16);
    }

    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap = resultMap;

    }

    public void setWorkQueue(ConcurrentLinkedQueue<AbstractTask> workQueue) {
        this.workQueue = workQueue;

    }

    @Override
    public void run() {
        AbstractTask input = this.workQueue.poll();
        System.out.println(Thread.currentThread().getName() + "获取任务:[" + input + "]");
        //以下是正真的业务处理
        Object outPut = handle(input);
        this.resultMap.put(input.getId() + "", outPut == null ? "" : outPut);
        notifyObserver(outPut);

    }

    /**
     * 业务逻辑
     *
     * @param input 入参
     * @return Object
     */
    public abstract Object handle(AbstractTask input);


    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public abstract void notifyObserver( Object outPut);


}