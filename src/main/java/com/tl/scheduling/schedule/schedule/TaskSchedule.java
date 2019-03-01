package com.tl.scheduling.schedule.schedule;

import com.tl.scheduling.schedule.task.Task;

/**
 * @author :MysticalYcc
 * @date :13:37 2019/2/27
 */
public interface TaskSchedule {

    /**
     * 异步查询
     */
    String ASY_MODEL = "asy";
    /**
     * 同步查询
     */
    String SYN_MODEL = "syn";

    /**
     * 任务分发
     *
     * @param task 任务
     * @param task 返回值类型
     */
    void dispatch(Task task);
}
