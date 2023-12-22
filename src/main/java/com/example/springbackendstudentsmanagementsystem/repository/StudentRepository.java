package com.example.springbackendstudentsmanagementsystem.repository;

import com.example.springbackendstudentsmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> finbdByEmail(String email);
}
