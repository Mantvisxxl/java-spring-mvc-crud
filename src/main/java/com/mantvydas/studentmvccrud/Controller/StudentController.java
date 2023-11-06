package com.mantvydas.studentmvccrud.Controller;

import com.mantvydas.studentmvccrud.Service.StudentService;
import com.mantvydas.studentmvccrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String getAllStudents(Model model) {

        // fetch all available students
        List<Student> allStudents = studentService.findAll();

        // send student data to model
        model.addAttribute("students", allStudents);

        // show student html page
        return "students-list";
    }
}
