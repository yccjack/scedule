package com.tl.scheduling.schedule.task;

import com.tl.scheduling.schedule.schedule.TaskSchedule;
import com.tl.scheduling.schedule.util.SnowflakeIdWorker;

/**
 * @author :MysticalYcc
 * @date :10:30 2019/3/4
 */
public class DefaultTask extends AbstractTask {

    public DefaultTask() {
        if (id == 0) {
            id = new SnowflakeIdWorker(5L, 5L).nextId();
        }
    }


    public static final class DefaultTaskBuilder {
        private long id;
        private String name;
        private int workerNum;
        private Object result;
        private String indicate = TaskSchedule.SYN_MODEL;

        private DefaultTaskBuilder() {
        }

        public static DefaultTaskBuilder aDefaultTask() {
            return new DefaultTaskBuilder();
        }

        public DefaultTaskBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public DefaultTaskBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DefaultTaskBuilder withWorkerNum(int workerNum) {
            this.workerNum = workerNum;
            return this;
        }

        public DefaultTaskBuilder withResult(Object result) {
            this.result = result;
            return this;
        }

        public DefaultTaskBuilder withIndicate(String indicate) {
            this.indicate = indicate;
            return this;
        }

        public DefaultTask build() {
            DefaultTask defaultTask = new DefaultTask();
            defaultTask.name = this.name;
            defaultTask.indicate = this.indicate;
            defaultTask.id = this.id;
            defaultTask.workerNum = this.workerNum;
            defaultTask.result = this.result;
            return defaultTask;
        }
    }
}
