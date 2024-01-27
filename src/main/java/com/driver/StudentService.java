package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<String> addStudent(Student student) {
        studentRepository.addStudent(student);
        return new ResponseEntity<>("New student added successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
        return new ResponseEntity<>("New teacher added successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> addStudentTeacherPair(String studentName, String teacherName) {
        studentRepository.addStudentTeacherPair(studentName, teacherName);
        return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<Student> getStudentByName(String name) {
        Student student = studentRepository.getStudentByName(name);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    public ResponseEntity<Teacher> getTeacherByName(String name) {
        Teacher teacher = studentRepository.getTeacherByName(name);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getStudentsByTeacherName(String teacherName) {
        Map<String, String> studentTeacherPairs = studentRepository.getStudentsByTeacherName(teacherName);
        List<String> students = studentTeacherPairs.keySet().stream().collect(Collectors.toList());
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    public ResponseEntity<List<String>> getAllStudents() {
        Map<String, Student> students = studentRepository.getAllStudents();
        List<String> studentNames = students.keySet().stream().collect(Collectors.toList());
        return new ResponseEntity<>(studentNames, HttpStatus.OK);
    }

    public ResponseEntity<String> deleteTeacherByName(String teacherName) {
        studentRepository.deleteTeacherByName(teacherName);
        return new ResponseEntity<>(teacherName + " removed successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
        return new ResponseEntity<>("All teachers deleted successfully", HttpStatus.OK);
    }
}
