package com.wadedwyane.www;

import com.wadedwyane.www.scheduler.CronScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyStartupRunner implements CommandLineRunner {
    @Autowired
    public CronScheduler cronScheduler;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>定时任务开始执行<<<<<<<<<<<<<");
        cronScheduler.scheduledJobs();
    }
}
