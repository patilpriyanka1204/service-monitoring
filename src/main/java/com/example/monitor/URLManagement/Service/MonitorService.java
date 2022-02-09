package com.example.monitor.URLManagement.Service;

import com.example.monitor.URLManagement.Exception.MonitorServiceException;
import com.example.monitor.URLManagement.Repository.MonitorRepo;
import com.example.monitor.URLManagement.domain.ServiceData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonitorService {

    @Autowired
    MonitorRepo monitorRepo;


    public Optional<ServiceData> addService(ServiceData service) throws MonitorServiceException {
        try{
           return Optional.ofNullable(this.monitorRepo.save(service));
        }
        catch (Exception e){
            throw new MonitorServiceException(e.getMessage());
        }
    }

    public List<ServiceData> findAll() throws MonitorServiceException {
        return this.monitorRepo.findAll();

    }

    public Optional<ServiceData> findById(int Id)  {
        return this.monitorRepo.findById(Id);
    }

    public ServiceData update(ServiceData service) throws MonitorServiceException {
        return this.monitorRepo.save(service);

    }
}
