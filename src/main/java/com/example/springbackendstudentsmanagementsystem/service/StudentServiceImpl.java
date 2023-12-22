package com.example.springbackendstudentsmanagementsystem.service;

import com.example.springbackendstudentsmanagementsystem.exception.StudentAlreadyExistException;
import com.example.springbackendstudentsmanagementsystem.exception.StudentNotFoundException;
import com.example.springbackendstudentsmanagementsystem.model.Student;
import com.example.springbackendstudentsmanagementsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {

        if (studentAlreadyExist(student.getEmail())){
            throw new StudentAlreadyExistException(student.getEmail()+" already exist!");
        }

        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(st -> {
            st.setFirstName(student.getFirstName());
            st.setLastName(student.getLastName());
            st.setEmail(student.getEmail());
            st.setDepartment(student.getDepartment());
            return studentRepository.save(st);
        }).orElseThrow(() -> new StudentNotFoundException("Sorry, this student could not be found"));
    }

    @Override
    public Student getStudentById(Long id) {
        return null;
    }

    @Override
    public void deleteStudent(Long id) {

    }

    private boolean studentAlreadyExist(String email) {
        return studentRepository.finbdByEmail(email).isPresent();
    }

}
