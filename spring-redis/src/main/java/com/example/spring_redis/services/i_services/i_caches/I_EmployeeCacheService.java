package com.example.spring_redis.services.i_services.i_caches;

import com.example.spring_redis.models.caches.EmployeeCache;
import org.springframework.data.redis.RedisSystemException;

import java.util.List;
import java.util.Set;

public interface I_EmployeeCacheService {
    public Boolean createEmployeeCache(EmployeeCache employeeCache) throws RedisSystemException;

    public List<EmployeeCache> getEmployeeCache() throws RedisSystemException;
}
