package com.example.monitor.URLManagement.Controller;

import com.example.monitor.URLManagement.Exception.MonitorServiceException;
import com.example.monitor.URLManagement.Service.MonitorService;
import com.example.monitor.URLManagement.Service.PollingService;
import com.example.monitor.URLManagement.coverter.Converter;
import com.example.monitor.URLManagement.coverter.ServiceConverter;
import com.example.monitor.URLManagement.domain.PollingData;
import com.example.monitor.URLManagement.domain.ServiceDTO;
import com.example.monitor.URLManagement.domain.ServiceData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@RestController
@RequestMapping("/services")
public class URLController {

    @Autowired
    MonitorService monitorService;

    @Autowired
    PollingService pollingService;

    @Autowired
    ServiceConverter converter;

    Logger logger
            = Logger.getLogger(URLController.class.getName());

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity addService(@Valid @RequestBody ServiceDTO service) {
        try {
            logger.info("RequestBody  -->"+service.toString());
            return new ResponseEntity(this.monitorService.addService(converter.convert(service)).orElseThrow(()-> new MonitorServiceException("Failed to create")), HttpStatus.CREATED);
        }
        catch (MonitorServiceException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }

    }

    @GetMapping
    public Collection<ServiceData> getService() throws Exception {
        try {
            return this.monitorService.findAll();
        } catch (MonitorServiceException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }



    @PutMapping("/{id}")
    public ResponseEntity<ServiceData> updateService(@PathVariable ( value  =  " id " ) Integer serviceId,
                                                   @RequestBody  ServiceDTO serviceDTO)  {
        try {
            Optional<ServiceData> serviceData = this.monitorService.findById(serviceId);
            serviceData.orElseThrow(() ->new MonitorServiceException("Resource not found"));
            ServiceData service = serviceData.get();
            service.setName(serviceDTO.getName());
            return new ResponseEntity(this.monitorService.update(service),HttpStatus.ACCEPTED);

        } catch (MonitorServiceException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(),e);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

    @GetMapping("/monitors")
    public PollingData getPolling()  {
        try {
            return pollingService.pollAll();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(),e);
        }
    }

}