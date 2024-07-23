package com.example.p2.controller;

import com.example.p2.model.Teacher;
import com.example.p2.repository.TeacherRepository;
import com.example.p2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @GetMapping
    public List<Teacher> teacherList(){
        return teacherService.teacherList();

    }
    @GetMapping("{id}")
    public Teacher teacherFindById(@PathVariable("id") Long id){
        return teacherService.teacherFindById(id);
    }
    @DeleteMapping("{id}")
    public void teacherDeleteById(@PathVariable("id") Long id){
        teacherService.teacherDeleteById(id);
    }

}
