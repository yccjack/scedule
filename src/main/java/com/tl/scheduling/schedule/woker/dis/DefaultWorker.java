package com.tl.scheduling.schedule.woker.dis;

import com.tl.scheduling.schedule.listener.Observer;
import com.tl.scheduling.schedule.task.AbstractTask;
import com.tl.scheduling.schedule.woker.AbstractWorker;

/**
 * @author :MysticalYcc
 * @date :16:50 2019/2/28
 */
public class DefaultWorker extends AbstractWorker {
    @Override
    public Object handle(AbstractTask input) {
        Object message = input.getName() + "任务已完成";
        return message;
    }

    @Override
    public void notifyObserver(Object outPut) {
        for (Observer o : list) {
            o.update(outPut);
        }
    }
}
