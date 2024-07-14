package com.example.p2.service;

import com.example.p2.model.Teacher;
import com.example.p2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    public List<Teacher> teacherList(){
        return teacherRepository.findAll();
    }
}
