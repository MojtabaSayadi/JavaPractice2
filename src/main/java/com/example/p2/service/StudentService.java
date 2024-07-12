package com.example.p2.service;

import com.example.p2.model.Student;
import com.example.p2.repository.StudenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

@Autowired
    private StudenteRepository studenteRepository;

    public Student studentFindById(Long id){
      return studenteRepository.findById(id).get();
}
    public Student saveStudent(Student student){
    return studenteRepository.save(student);
}
    public void deleteById(Long id){
        studenteRepository.deleteById(id);
    }
    public Student update(long id, Student studentrequest) {
        Student studentData = studenteRepository.findById(id).get();

        if (studentrequest.getFirstName() != null) {
            studentData.setFirstName(studentrequest.getFirstName());
        }
        if (studentrequest.getLastName() != null) {
            studentData.setLastName(studentrequest.getLastName());
        }
        if (studentrequest.getEmail() != null) {
            studentData.setEmail(studentrequest.getEmail());
        }
        return studenteRepository.save(studentData);
    }
}
