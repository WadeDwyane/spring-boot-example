package com.wadedwyane.www.task;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler1Task {

    private int count = 0;

    @Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        System.out.print("\n this is scheduled task1 running " + (count++));
    }

}
