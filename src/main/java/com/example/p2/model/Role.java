package com.example.p2.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Role {
    @Id
    private Integer id;
    @Enumerated(EnumType.STRING)
    private ERole name;

}
