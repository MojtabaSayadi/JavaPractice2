package com.example.p2.service;

import com.example.p2.model.Student;
import com.example.p2.model.Teacher;
import com.example.p2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    public List<Teacher> teacherList(){
        return teacherRepository.findAll();
    }
    public Teacher teacherSave(Teacher teacher ){
        return teacherRepository.save(teacher);
    }
    public void teacherDeleteById(Long id){
        teacherRepository.deleteById(id);
    }

    public Teacher teacherFindById(Long id){
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElse(null); }
}
