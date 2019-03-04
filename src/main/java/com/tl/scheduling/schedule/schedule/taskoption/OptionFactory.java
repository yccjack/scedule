package com.tl.scheduling.schedule.schedule.taskoption;

import com.tl.scheduling.schedule.schedule.TaskSchedule;
import com.tl.scheduling.schedule.schedule.TaskStrategy;
import com.tl.scheduling.schedule.schedule.impl.AsyStrategy;
import com.tl.scheduling.schedule.schedule.impl.DefaultStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建分发实体类
 * 枚举
 *
 * @author :MysticalYcc
 * @date :15:10 2019/2/27
 */
public enum OptionFactory {

    /**
     *
     */
    INSTANCE;

    private static Map<String, TaskStrategy> strategyMap = new HashMap<>(16);

    public OptionFactory getInstance() {
        return INSTANCE;
    }

    static {
        TaskStrategy syn = new DefaultStrategy();
        TaskStrategy asy = new AsyStrategy();
        strategyMap.put(TaskSchedule.SYN_MODEL, syn);
        strategyMap.put(TaskSchedule.ASY_MODEL, asy);
    }

    public static TaskStrategy getStrategy(String model) {
        return strategyMap.get(model);
    }
}
