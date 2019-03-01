package com.tl.scheduling.schedule.master;

import com.tl.scheduling.schedule.listener.Observer;
import com.tl.scheduling.schedule.task.Task;
import com.tl.scheduling.schedule.woker.AbstractWorker;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author :MysticalYcc
 * @date :11:14 2019/2/27
 */


public class Master  implements Observer {
    /**
     * 1、承装任务的集合
     */
    private ConcurrentLinkedQueue<Task> workQueue = new ConcurrentLinkedQueue<>();
    /**
     * 2.使用hashMap装所有的worker对象；
     */
    private HashMap<String, Thread> workers = new HashMap<>(16);
    /**
     * 3、使用一个容器承装每一个worker并发执行结果
     */

    public Master(AbstractWorker worker, int workerCount) {
        ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>(16);
        // 每一個worker都需要有Master的引用用於任務的領取
        worker.setWorkQueue(this.workQueue);
        // 用於任務的提交
        worker.setResultMap(resultMap);
        for (int i = 0; i <= workerCount; i++) {
            // key每一个worker的名字,value线程执行对象
            workers.put("子节点" + i, new Thread(worker));
        }
    }

    /**
     * 提交任务
     *
     * @param task
     */
    public void submit(Task task) {
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
    public Task getResult() {
        return null;
    }

    @Override
    public void update(Object message) {
        //todo
    }
}