package com.mantvydas.studentmvccrud.controller;

import com.mantvydas.studentmvccrud.entity.Student;
import com.mantvydas.studentmvccrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/addNewStudentForm")
    public String addNewStudent(Model model) {

        // create new student object to use for saving
        Student student = new Student();

        // add this student to the model to be able to access it in thymeleaf through html
        model.addAttribute("student", student);

        // show form for entering/modifying student data
        return "student-form";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {

        // saving student we got from student-form after pressing submit button
        studentService.save(student);

        // good practice to redirect user to main menu after saving to avoid duplicates
        return "redirect:/students/list";
    }

    @GetMapping("/updateStudent")
    public String updateStudent(@RequestParam("studentId") int id, Model model) {

        // fetch the student from database
        Student student = studentService.findById(id);

        // to preload student's data in the form, we need to add it to the model
        model.addAttribute("student", student);

        //send the user to the form where the user can update data
        return "student-form";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int id) {

        studentService.deleteById(id);

        return "redirect:/students/list";
    }
}
