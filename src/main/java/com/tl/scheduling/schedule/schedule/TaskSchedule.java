package com.tl.scheduling.schedule.schedule;

import com.tl.scheduling.schedule.task.AbstractTask;

import java.util.List;

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
     *
     * @param taskList
     */
    void dispatch(List<AbstractTask> taskList);
}
