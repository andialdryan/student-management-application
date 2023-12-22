package com.example.springbackendstudentsmanagementsystem.exception;

public class StudentAlreadyExistException extends RuntimeException {
    public StudentAlreadyExistException(String message) {
        super(message);
    }
}
