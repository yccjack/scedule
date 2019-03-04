package com.tl.scheduling.schedule.schedule;

import com.tl.scheduling.schedule.task.AbstractTask;

import java.util.List;

/**
 * @author :MysticalYcc
 * @date :14:48 2019/2/27
 */
public interface TaskStrategy {

    /**
     * 分发任务
     * @param taskList
     */
     void distributionTask (List<AbstractTask> taskList);
}
