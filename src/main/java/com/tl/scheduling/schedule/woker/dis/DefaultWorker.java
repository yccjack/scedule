package com.tl.scheduling.schedule.woker.dis;

import com.tl.scheduling.schedule.listener.Observer;
import com.tl.scheduling.schedule.task.Task;
import com.tl.scheduling.schedule.woker.AbstractWorker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :MysticalYcc
 * @date :16:50 2019/2/28
 */
public class DefaultWorker extends AbstractWorker {
    /**
     * 注册需要通知的类的集合
     */
    private List<Observer> list;
    private Object message;

    public DefaultWorker() {
        list = new ArrayList<>();
    }

    @Override
    public Object handle(Task input) {
        return null;
    }

    @Override
    public void registerObserver(Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        list.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : list) {
            o.update(message);
        }
    }
}
