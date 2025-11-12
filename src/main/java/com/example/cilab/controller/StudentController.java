package com.example.cilab.controller;

import com.example.cilab.model.Student;
import com.example.cilab.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")
    public String add(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student is added";
    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return true;}
    @PutMapping("/update")
    public Student update(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
}
