package com.mantvydas.studentmvccrud.service;

import com.mantvydas.studentmvccrud.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    List<Student> findAll();

    void save(Student student);

    Student findById(int id);

    void deleteById(int id);


}
