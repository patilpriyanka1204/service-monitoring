package com.example.monitor.URLManagement.domain;

import com.example.monitor.URLManagement.util.StatusType;
import lombok.*;
import org.hibernate.StatelessSession;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Validated
@NotNull
@Getter
@Setter
public class ServiceDTO {

    @NotNull
    @Pattern(message = "not a valid URL",regexp = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
    String url;

    @NotNull
    @Length(min = 3, max = 20)
    String name;


    @Override
    public String toString() {
        return "ServiceDTO{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }



}
