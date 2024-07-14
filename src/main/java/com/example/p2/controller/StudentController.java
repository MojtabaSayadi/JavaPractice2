package com.example.p2.controller;

import com.example.p2.model.Student;
import com.example.p2.repository.StudentRepository;
import com.example.p2.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
   /*
    @Autowired
    StudentRepository studentRepository;
   */
   @Autowired
    StudentService  studentService;

    @GetMapping
    public List<Student> studentList(){

        return studentService.studentList();
    }
    @GetMapping("{id}")
    public Student findStudentById(@PathVariable("id") Long id) {
      // return studenteRepository.findById(id).get();
        return studentService.studentFindById(id);
    }
    @PostMapping
    public Student save(@RequestBody Student student){
        return studentService.saveStudent(student);
       // return studenteRepository.save(student);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        studentService.deleteById(id);
      //studentRepository.deleteById(id);

    }

    @PutMapping("{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student studentRequest) {
        return  studentService.update(id, studentRequest);
    }


}
