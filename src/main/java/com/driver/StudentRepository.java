package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class StudentRepository {

    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, Teacher> teachers = new HashMap<>();
    private final Map<String, String> studentTeacherPairs = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName) {
        studentTeacherPairs.put(studentName, teacherName);
    }

    public Student getStudentByName(String name) {
        return students.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teachers.get(name);
    }

    public Map<String, String> getStudentsByTeacherName(String teacherName) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : studentTeacherPairs.entrySet()) {
            if (entry.getValue().equals(teacherName)) {
                result.put(entry.getKey(), teacherName);
            }
        }
        return result;
    }

    public Map<String, Student> getAllStudents() {
        return students;
    }

    public void deleteTeacherByName(String teacherName) {
        teachers.remove(teacherName);
        // Also remove students taught by this teacher
        studentTeacherPairs.entrySet().removeIf(entry -> entry.getValue().equals(teacherName));
    }

    public void deleteAllTeachers() {
        teachers.clear();
        // Also remove all student-teacher pairs
        studentTeacherPairs.clear();
    }
}
