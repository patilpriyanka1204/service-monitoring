package com.example.monitor.URLManagement.util;

import com.example.monitor.URLManagement.Service.PollingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

@Configuration
@EnableScheduling
@ComponentScan(basePackages = "com.example.monitor.URLManagement")
public class AyncConfig  {

    @Autowired
   PollingService pollingService;

     int time_delay_costant = 10000;
}
