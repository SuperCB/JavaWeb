package com.supercb.alweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Schedule {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Scheduled(cron = "*/5 * */24 * * ?")
    public void execute() {
        logger.info("dafsdfa");
    }

}

