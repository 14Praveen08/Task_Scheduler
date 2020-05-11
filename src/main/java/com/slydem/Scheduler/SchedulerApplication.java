package com.slydem.Scheduler;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerApplication.class, args);
	}
	
	//Cron expression
	@Scheduled(cron = "0 0/1 * 1/1 *  *")
	public void cron() {
		Date date = new Date();
		System.out.println(date.getMinutes());
	}
	
	//Fixed Delay Function
	@Scheduled(fixedDelayString = "${fixed.delay.mills}")
	public void delay() throws InterruptedException {
		Date date = new Date();
		System.out.println(date.getSeconds());
		Thread.sleep(4000);
		
	}
	
	//Fired Rate Function
	@Scheduled(fixedRate = 2000)
	public void rate() throws InterruptedException {
		Date date = new Date();
		System.out.println(date.getSeconds());
		Thread.sleep(4000);
		
	}
	
}
