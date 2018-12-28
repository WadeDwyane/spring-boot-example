package com.wadedwyane.www.scheduler;

import com.wadedwyane.www.job.SimpleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SimpleScheduler {

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(SimpleJob.class)
                .usingJobData("name", "world").storeDurably().build();
    }

    @Bean
    public Trigger trigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
        return TriggerBuilder.newTrigger().forJob(jobDetail()).withIdentity("simpleTrigger").withSchedule(scheduleBuilder).build();
    }


}
