package com.example.cache.service;

import com.example.cache.dto.DataAccess;
import com.example.cache.model.Student;
import com.example.cache.model.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@CacheConfig(
        cacheNames = {"profiles"},cacheManager = "cacheManager"
)
public abstract class CacheService {

    @CachePut(key="#student")
    public abstract StudentProfile create(Student student, StudentProfile profile) throws InterruptedException;

    @Cacheable(sync=true)
    public abstract StudentProfile retrieve(Student student) throws InterruptedException;

    public boolean update(Student student, StudentProfile profile){
        return false;
    }
    @CacheEvict(key="#student")
    public abstract boolean delete(Student student) throws InterruptedException;
}
