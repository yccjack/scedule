package com.tl.scheduling.schedule.woker;

import com.tl.scheduling.schedule.listener.Observerable;
import com.tl.scheduling.schedule.task.Task;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * @author :MysticalYcc
 * @date :11:16 2019/2/27
 */
public abstract class AbstractWorker implements Runnable , Observerable {
    private ConcurrentHashMap<String, Object> resultMap;
    private  ConcurrentLinkedQueue<Task> workQueue;
    public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
        this.resultMap=resultMap;

    }

    public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
        this.workQueue=workQueue;

    }

    @Override
    public void run() {

    }

    /**
     * 业务逻辑
     * @param input 入参
     * @return Object
     */
    public abstract Object handle(Task input);


}