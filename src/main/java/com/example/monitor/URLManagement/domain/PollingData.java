package com.example.monitor.URLManagement.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NotNull
public class PollingData {

    List<ServiceData> pollingList;

    public List<ServiceData> getPollingList() {
        return pollingList;
    }

    public void setPollingList(List<ServiceData> pollingList) {
        this.pollingList = pollingList;
    }
}
