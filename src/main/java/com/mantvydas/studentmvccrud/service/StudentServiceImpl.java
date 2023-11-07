package com.mantvydas.studentmvccrud.service;

import com.mantvydas.studentmvccrud.dao.StudentRepository;
import com.mantvydas.studentmvccrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {

        Optional<Student> student = studentRepository.findById(id);

        if (student.isPresent()) {

            return student.get();
        } else {

            throw new RuntimeException("Student was not found with id - " + id);
        }
    }

    @Override
    public void save(Student student) {

        studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {

        studentRepository.deleteById(id);
    }
}
