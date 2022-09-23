package com.mx.ieepo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskJob {
	
	@Scheduled(fixedRate = 5000)
	public void scheduleTaskWithCronExpression() {
		System.out.println("cron eject");
	}

}
