package com.example.spring_redis.cachings;

import com.example.spring_redis.models.caches.EmployeeCache;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EmployeeCacheRepository extends CrudRepository<EmployeeCache, Long> {
    // Spring sẽ tự động cung cấp các hàm save(), findById(), delete()
    EmployeeCache getEmployeeCacheByEmployeeId(Long employeeId);
}