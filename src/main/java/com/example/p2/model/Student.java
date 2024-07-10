package com.example.p2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 30)
    private String firstName;
    @Size(max=40)
    private String lastName;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private Gender  gender;
}
