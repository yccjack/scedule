package com.tl.scheduling.schedule.task;

import com.tl.scheduling.schedule.schedule.TaskSchedule;

/**
 * @author :MysticalYcc
 * @date :11:15 2019/2/27
 */
public abstract class AbstractTask {

    /**
     * 任务ID 唯一
     */
    protected long id;
    /**
     * 任务名称
     */
    protected String name;

    /**
     * 子任务数量
     */
    protected int workerNum;

    /**
     * 执行结果
     */
    protected Object result;

    /**
     * 执行策略,默认同步
     */
    protected String indicate = TaskSchedule.SYN_MODEL;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(int workerNum) {
        this.workerNum = workerNum;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getIndicate() {
        return indicate;
    }

    public void setIndicate(String indicate) {
        this.indicate = indicate;
    }
}