package com.rentirs.webSchool.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue
    private UUID id;
    @Column(nullable = false)
    private String courseName;
}
