package com.example.monitor.URLManagement.util;

import com.example.monitor.URLManagement.domain.PollingData;
import com.example.monitor.URLManagement.domain.ServiceData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.*;
import java.util.Collection;
import java.util.Collections;


@Component
@RequiredArgsConstructor
public class PollerWorker {

    int URLtimeOut = Constant.URL_TIMEOUT;

    public void pollURL(PollingData data){
        data.getPollingList().stream().forEach(e -> {
            if(ping(e.getURL())){
                e.setStatus(StatusType.OK);
            }
            else{
                e.setStatus(StatusType.FAIL);
            }
        });
    }

    boolean ping(String url) {
        try {
            URLConnection urlConnection = new URL(url).openConnection();
            urlConnection.setReadTimeout(URLtimeOut);
            urlConnection.setConnectTimeout(URLtimeOut);
            HttpURLConnection connection = (HttpURLConnection) urlConnection;
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 399) ? true : false;
        } catch (Exception exception) {
            return false;
        }
    }
}
