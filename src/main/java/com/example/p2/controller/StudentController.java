package com.example.p2.controller;

import com.example.p2.model.Student;
import com.example.p2.repository.StudenteRepository;
import com.example.p2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudenteRepository studenteRepository;

    StudentService  studentService;

    @GetMapping
    public List<Student> studentList(){

        return studenteRepository.findAll();
    }
    @GetMapping("{id}")
    public Student findStudentById(@PathVariable("id") Long id) {
        return studenteRepository.findById(id).get();
    }
    @PostMapping
    public Student save(@RequestBody Student student){

        return studenteRepository.save(student);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        studenteRepository.deleteById(id);

    }

    @PutMapping("{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student studentRequest) {
        return  studentService.update(id, studentRequest);
    }


}
