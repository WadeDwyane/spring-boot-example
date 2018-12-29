package com.wadedwyane.www.scheduler;

import com.wadedwyane.www.job.ScheduledJob;
import com.wadedwyane.www.job.SimpleJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class CronScheduler {

    /*@Autowired
    SchedulerFactoryBean schedulerFactoryBean;*/

    public void scheduledJobs() throws SchedulerException {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        Scheduler scheduler = bean.getScheduler();
        scheduleJob1(scheduler);
        scheduleJob2(scheduler);
    }

    private void scheduleJob1(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ScheduledJob.class).withIdentity("job1", "group1").build();
        CronScheduleBuilder builder = CronScheduleBuilder.cronSchedule("0/6 * * * * ?");
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(builder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    private void scheduleJob2(Scheduler scheduler) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(SimpleJob.class).withIdentity("job3", "group3").build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/12 * * * * ?");
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger3", "group3").withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
