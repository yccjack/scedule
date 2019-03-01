package com.tl.scheduling.schedule.task;

import com.tl.scheduling.schedule.schedule.TaskSchedule;

/**
 * @author :MysticalYcc
 * @date :11:15 2019/2/27
 */
public class Task  {

    private int id;
    private String name;

    private int workerNum;

    private Object result;

    private String indicate = TaskSchedule.SYN_MODEL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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