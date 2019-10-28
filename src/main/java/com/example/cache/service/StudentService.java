package com.example.cache.service;

import com.example.cache.dto.DataAccess;
import com.example.cache.model.Student;
import com.example.cache.model.StudentProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService extends CacheService {

    @Autowired
    private DataAccess dataAccess;

    public StudentProfile create(Student student, StudentProfile profile) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        var res =  dataAccess.create(student,profile);
        System.out.println("TimeTaken:"+(System.currentTimeMillis()-t1)/1000);
        return res;
    }

    public StudentProfile retrieve(Student student) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        var profile = dataAccess.retrieve(student);
        System.out.println("TimeTaken:"+(System.currentTimeMillis()-t1)/1000);
        return profile;
    }

    public boolean delete(Student student) throws InterruptedException {
        long t1 = System.currentTimeMillis();
        dataAccess.delete(student);
        System.out.println("TimeTaken:"+(System.currentTimeMillis()-t1)/1000);
        return true;
    }
}
