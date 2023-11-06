package com.mantvydas.studentmvccrud.dao;

import com.mantvydas.studentmvccrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
