package com.example.monitor.URLManagement.Repository;

import com.example.monitor.URLManagement.domain.ServiceData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepo extends JpaRepository<ServiceData,Integer> {

}
