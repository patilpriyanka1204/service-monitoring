package com.example.monitor.URLManagement.Service;

import com.example.monitor.URLManagement.Exception.MonitorServiceException;
import com.example.monitor.URLManagement.domain.PollingData;
import com.example.monitor.URLManagement.domain.ServiceData;
import com.example.monitor.URLManagement.util.Constant;
import com.example.monitor.URLManagement.util.PollerWorker;
import com.example.monitor.URLManagement.util.StatusType;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class PollingService{

    static SocketAddress URL ;

    @Value("{TIMEOUT.DELAY}")
    private static final int timeout = 0;

    @Autowired
    private MonitorService monitorService;

    @Autowired
    private PollerWorker pollerWorker;


    @Scheduled(fixedDelay = Constant.DELAY_TIME_SCHEDUED_JOB)
    public PollingData pollAll() throws MonitorServiceException {
        PollingData pollingData = new PollingData();
        pollingData.setPollingList(monitorService.findAll());
        pollerWorker.pollURL(pollingData);
        return pollingData;

    }




}
