package com.mantvydas.studentmvccrud.Service;

import com.mantvydas.studentmvccrud.dao.StudentRepository;
import com.mantvydas.studentmvccrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {

        return studentRepository.findAll();
    }


}
