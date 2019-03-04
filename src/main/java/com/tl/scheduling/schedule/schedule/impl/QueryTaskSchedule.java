package com.tl.scheduling.schedule.schedule.impl;

import com.tl.scheduling.schedule.exception.NotFoundStrategyException;
import com.tl.scheduling.schedule.schedule.TaskSchedule;
import com.tl.scheduling.schedule.schedule.TaskStrategy;
import com.tl.scheduling.schedule.schedule.taskoption.OptionFactory;
import com.tl.scheduling.schedule.task.AbstractTask;

import java.util.List;

/**
 * @author :MysticalYcc
 * @date :13:49 2019/2/27
 */
public class QueryTaskSchedule implements TaskSchedule {
    private TaskStrategy taskStrategy;

    /**
     * 目前只支持同步[TaskSchedule.SYN_MODEL ] ,异步[TaskSchedule.ASY_MODEL]两种选择
     *
     * @param indicate 类型
     * @throws NotFoundStrategyException 不支持的类型
     * @throws NullPointerException      不支持null
     */
    public QueryTaskSchedule(String indicate) throws NotFoundStrategyException, NullPointerException {
        if (indicate == null) {
            throw new NullPointerException("QueryTaskSchedule --->null is not supported!");
        }
        if (indicate.equals(TaskSchedule.SYN_MODEL) || indicate.equals(TaskSchedule.ASY_MODEL)) {
            this.taskStrategy = OptionFactory.getStrategy(indicate);
        } else {
            throw new NotFoundStrategyException("QueryTaskSchedule --->the indicate:[" + indicate + "] is not supported.");
        }
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
     * 默认同步策略 {@link DefaultStrategy}
     */
    public QueryTaskSchedule() {
        taskStrategy = new DefaultStrategy();
    }

    @Override
    public void dispatch(List<AbstractTask> taskList) {
        taskStrategy.distributionTask(taskList);
    }
}
