package com.example.monitor.URLManagement.coverter;

import com.example.monitor.URLManagement.domain.ServiceDTO;
import com.example.monitor.URLManagement.domain.ServiceData;
import com.example.monitor.URLManagement.util.StatusType;
import org.springframework.stereotype.Component;

@Component
public class ServiceConverter implements Converter<ServiceDTO, ServiceData> {
    @Override
    public ServiceData convert(ServiceDTO serviceDTO) {
       return ServiceData.builder().name(serviceDTO.getName())
                .URL(serviceDTO.getUrl())
                .status(StatusType.OK)
                .build();
    }
}
