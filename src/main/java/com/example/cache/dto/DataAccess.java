package com.example.cache.dto;

import com.example.cache.model.Student;
import com.example.cache.model.StudentProfile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DataAccess {
    private Map<Student,StudentProfile> store = new HashMap<>();
    public StudentProfile create(Student key, StudentProfile val) throws InterruptedException {
        Thread.sleep(10000);
        store.put(key,val);
        return val;
    }
    public StudentProfile retrieve(Student key) throws InterruptedException {
        Thread.sleep(10000);
        return store.get(key);
    }
    public boolean delete(Student key) throws InterruptedException {
        Thread.sleep(10000);
        store.remove(key);
        return true;
    }
}
