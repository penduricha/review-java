package com.example.spring_redis.models.caches;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Employee")
public class EmployeeCache implements Serializable {
    @Id
    @Indexed
    private Long employeeId;

    private String employeePassword;

    public EmployeeCache(String employeePassword, Long employeeId) {
        this.employeePassword = employeePassword;
        this.employeeId = employeeId;
    }
}
