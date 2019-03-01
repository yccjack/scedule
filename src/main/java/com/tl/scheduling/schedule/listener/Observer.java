package com.tl.scheduling.schedule.listener;

/**
 * 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 *
 * @author :MysticalYcc
 * @date :16:15 2019/2/28
 */
public interface Observer {
    /**
     * 订阅消息回调方法
     *
     * @param message 结果
     */
    void update(Object message);
}