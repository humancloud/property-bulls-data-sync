package com.property.sync_data.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.task.TaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Slf4j
public class VirtualThreadTaskExecutor implements TaskExecutor {

    private final Executor virtualThreadExecutor;

    public VirtualThreadTaskExecutor() {
        this.virtualThreadExecutor = Executors.newVirtualThreadPerTaskExecutor();
        log.info("Initialized VirtualThreadTaskExecutor");
    }

    @Override
    public void execute(Runnable task) {
        log.info("Executing task in VirtualThreadTaskExecutor");
        virtualThreadExecutor.execute(task);
    }

}
