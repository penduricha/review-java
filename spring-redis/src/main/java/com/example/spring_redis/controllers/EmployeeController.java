package com.example.spring_redis.controllers;

import com.example.spring_redis.models.caches.EmployeeCache;
import com.example.spring_redis.services.caches.EmployeeCacheService;
import com.jayway.jsonpath.spi.mapper.MappingException;
import com.sun.jdi.ObjectCollectedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping({"/employee"})
public class EmployeeController {
    private final EmployeeCacheService employeeCacheService;

    public EmployeeController(EmployeeCacheService employeeCacheService) {
        this.employeeCacheService = employeeCacheService;
    }

    @PostMapping("/cache")
    public ResponseEntity<?> postEmployeeCache(@RequestBody Map<String, Object> employeeCacheToPost)
            throws IllegalArgumentException, MappingException, ObjectCollectedException {
        Integer employeeIdInt = (Integer) employeeCacheToPost.get("employeeId");
        Long employeeId = employeeIdInt != null ? employeeIdInt.longValue() : null;
        String password = (String) employeeCacheToPost.get("password");
        EmployeeCache employeeCache = new EmployeeCache(employeeId, password);
        Boolean statusPersistCache = employeeCacheService.createEmployeeCache(employeeCache);
        return ResponseEntity.status(HttpStatus.CREATED).body(statusPersistCache);
    }

    @GetMapping("/cache/all")
    public ResponseEntity<?> getEmployeeCache() throws IllegalArgumentException {
        List<EmployeeCache> employeeCacheList = employeeCacheService.getEmployeeCache();
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeCacheList);
    }
}
