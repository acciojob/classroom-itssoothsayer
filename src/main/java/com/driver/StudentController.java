package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PostMapping("/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher) {
        return studentService.addTeacher(teacher);
    }

    @PutMapping("/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String student, @RequestParam String teacher) {
        return studentService.addStudentTeacherPair(student, teacher);
    }

    @GetMapping("/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name) {
        return studentService.getTeacherByName(name);
    }

    @GetMapping("/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher) {
        return studentService.getStudentsByTeacherName(teacher);
    }

    @GetMapping("/get-all-students")
    public ResponseEntity<List<String>> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher) {
        return studentService.deleteTeacherByName(teacher);
    }

    @DeleteMapping("/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers() {
        return studentService.deleteAllTeachers();
    }
}
