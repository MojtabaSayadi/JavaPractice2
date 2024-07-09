package com.example.p2.repository;

import com.example.p2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudenteRepository extends JpaRepository<Student,Long> {
}
