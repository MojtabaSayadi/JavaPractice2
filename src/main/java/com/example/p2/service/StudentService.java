package com.example.p2.service;

import com.example.p2.model.Student;
import com.example.p2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

@Autowired
    private StudentRepository studentRepository;

    public List<Student> studentList(){
        return studentRepository.findAll();
    }
    public Student studentFindById(Long id){
       Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
}
    public Student saveStudent(Student student){
    return studentRepository.save(student);
}
    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }
    public Student update(long id, Student studentrequest) {
      Student studentData = studentRepository.findById(id).get();
      // if (studentData.isPresent()) {
            if (studentrequest.getFirstName() != null) {
                studentData.setFirstName(studentrequest.getFirstName());
            }
            if (studentrequest.getLastName() != null) {
                studentData.setLastName(studentrequest.getLastName());
            }
            if (studentrequest.getEmail() != null) {
                studentData.setEmail (studentrequest.getEmail());
            }
            return studentRepository.save(studentData);
        }
       // return null;
   // }
}
