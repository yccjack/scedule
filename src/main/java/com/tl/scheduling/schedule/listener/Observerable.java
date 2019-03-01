package com.tl.scheduling.schedule.listener;


/**
 * * 抽象被观察者接口
 * * 声明了添加、删除、通知观察者方法
 *
 * @author :MysticalYcc
 * @date :16:14 2019/2/28
 */
public interface Observerable {

    /**
     * 注册服务
     *
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 删除服务
     *
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知观察者
     */
    void notifyObserver();

}