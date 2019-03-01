package com.tl.scheduling.schedule.schedule.impl;

import com.tl.scheduling.schedule.schedule.TaskSchedule;
import com.tl.scheduling.schedule.schedule.TaskStrategy;
import com.tl.scheduling.schedule.schedule.taskoption.OptionFactory;
import com.tl.scheduling.schedule.task.Task;

/**
 * @author :MysticalYcc
 * @date :13:49 2019/2/27
 */
public class QueryTaskSchedule implements TaskSchedule {
    private TaskStrategy taskStrategy;

    /**
     * 可供选择的
     *
     * @param indicate 分发模式
     */
    public QueryTaskSchedule(String indicate) {
        this.taskStrategy = OptionFactory.getStrategy(indicate);
    }

    /**
     * 自定义分发模式
     *
     * @param taskStrategy 自定义实现TaskStrategy
     */
    public QueryTaskSchedule(TaskStrategy taskStrategy) {
        this.taskStrategy = taskStrategy;
    }

    /**
     * 默认同步策略
     */
    public QueryTaskSchedule() {
        taskStrategy = new DefaultStrategy();
    }

    @Override
    public void dispatch(Task task) {
        taskStrategy.distributionTask(task);
    }
}
