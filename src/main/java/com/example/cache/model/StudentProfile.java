package com.example.cache.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class StudentProfile implements Serializable {
    private int id;
    private String firstname;
    private String lastname;
    private String department;
    private List<String> enrolledClasses= new ArrayList<>();
    private String advisor;
    private boolean isActive;
    private String email;
    private String phno;
}
