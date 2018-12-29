package com.wadedwyane.www.listener;


import com.wadedwyane.www.scheduler.CronScheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Configuration
@EnableScheduling
@Component
public class SchedulerListener {

    @Autowired
    public CronScheduler scheduler;

    @Scheduled(cron = "0 30 11 25 11 ?")
    public void schedule() throws SchedulerException {
        scheduler.scheduledJobs();
    }


}
