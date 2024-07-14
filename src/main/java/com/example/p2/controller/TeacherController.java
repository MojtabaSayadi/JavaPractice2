package com.example.p2.controller;

import com.example.p2.model.Teacher;
import com.example.p2.repository.TeacherRepository;
import com.example.p2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    TeacherService teacherService;
    @RequestMapping
    public List<Teacher> teacherList(){
       // return teacherService.findAll();
       return teacherRepository.findAll();
    }
}
