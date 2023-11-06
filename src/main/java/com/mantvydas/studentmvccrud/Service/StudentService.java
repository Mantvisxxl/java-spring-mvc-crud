package com.mantvydas.studentmvccrud.Service;

import com.mantvydas.studentmvccrud.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public List<Student> findAll();


}
