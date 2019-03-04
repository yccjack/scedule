package com.tl.scheduling.schedule.schedule.impl;

import com.tl.scheduling.schedule.master.Master;
import com.tl.scheduling.schedule.schedule.TaskStrategy;
import com.tl.scheduling.schedule.task.AbstractTask;
import com.tl.scheduling.schedule.woker.AbstractWorker;
import com.tl.scheduling.schedule.woker.dis.DefaultWorker;

import java.util.List;

/**
 * @author :MysticalYcc
 * @date :14:50 2019/2/27
 */
public class AsyStrategy implements TaskStrategy {
    @Override
    public void distributionTask(List<AbstractTask> taskList) {

        AbstractWorker worker = new DefaultWorker();
        Master master = new Master(worker, taskList.size());
        //注册观察者
        worker.registerObserver(master);
        for (AbstractTask task : taskList) {
            master.submit(task);
        }
        master.execute();
    }
}
