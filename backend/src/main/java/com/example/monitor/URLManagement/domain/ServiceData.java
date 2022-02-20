package com.example.monitor.URLManagement.domain;


import com.example.monitor.URLManagement.util.StatusType;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "Service")
public class ServiceData{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(name = "name")
    String name;

    @Column(name = "URL")
    String URL;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    StatusType status ;

    @Column(name = "created_Date")
    Timestamp createdDate;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "ServiceData{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", URL='" + URL + '\'' +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
