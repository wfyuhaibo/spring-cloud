package com.yhb.job.executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class JobExecutorApplication {

	public static void main(String[] args) {
        SpringApplication.run(JobExecutorApplication.class, args);
	}

}