package com.tl.scheduling.schedule.schedule;

import com.tl.scheduling.schedule.schedule.impl.QueryTaskSchedule;
import com.tl.scheduling.schedule.task.AbstractTask;
import com.tl.scheduling.schedule.task.DefaultTask;
import com.tl.scheduling.schedule.util.SnowflakeIdWorker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TaskScheduleTest {

    @Test
    public void testDispatch() {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0,0);
        TaskSchedule schedule = new QueryTaskSchedule(TaskSchedule.ASY_MODEL);
        AbstractTask abstractTask1 = DefaultTask.DefaultTaskBuilder.aDefaultTask()
                .withId(idWorker.nextId())
                .withName("worker1")
                .build();
        AbstractTask abstractTask2 = DefaultTask.DefaultTaskBuilder.aDefaultTask()
                .withId(idWorker.nextId())
                .withName("worker2")
                .build();
        AbstractTask abstractTask3 = DefaultTask.DefaultTaskBuilder.aDefaultTask()
                .withId(idWorker.nextId())
                .withName("worker3")
                .build();
        List<AbstractTask> taskList = new ArrayList<>(3);
        taskList.add(abstractTask1);
        taskList.add(abstractTask2);
        taskList.add(abstractTask3);
        schedule.dispatch(taskList);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}