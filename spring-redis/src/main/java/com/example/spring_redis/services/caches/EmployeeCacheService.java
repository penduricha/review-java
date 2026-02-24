package com.example.spring_redis.services.caches;

import com.example.spring_redis.cachings.EmployeeCacheRepository;
import com.example.spring_redis.models.caches.EmployeeCache;
import com.example.spring_redis.services.i_services.i_caches.I_EmployeeCacheService;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeCacheService implements I_EmployeeCacheService {

    private final EmployeeCacheRepository employeeCacheRepository;

    public EmployeeCacheService(EmployeeCacheRepository employeeCacheRepository) {
        this.employeeCacheRepository = employeeCacheRepository;
    }

    @Override
    public Boolean createEmployeeCache(EmployeeCache employeeCache) throws RedisSystemException {
        EmployeeCache employeeCacheFound = employeeCacheRepository
                .getEmployeeCacheByEmployeeId(employeeCache.getEmployeeId());
        if(employeeCacheFound == null) {
            employeeCacheRepository.save(employeeCache);
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeeCache> getEmployeeCache() throws RedisSystemException {
        return (List<EmployeeCache>) employeeCacheRepository.findAll();
    }
}
