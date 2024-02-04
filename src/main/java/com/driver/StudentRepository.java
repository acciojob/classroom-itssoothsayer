package com.driver;

import java.util.*;

public class StudentRepository {

    Map<String,Student> studentData=new HashMap<>();
    Map<String,Teacher> teacherData=new HashMap<>();

    private Map<String,ArrayList<String>> teacherStudentPair=new HashMap<String, ArrayList<String>>();




    public void add(Student student) {
        studentData.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        teacherData.put(teacher.getName(),teacher);

    }

    public void addStudentTeacherPair(String student, String teacher) {

        ArrayList<String> students=teacherStudentPair.getOrDefault(teacher,new ArrayList<String>());
        students.add(student);
        teacherStudentPair.put(teacher,students);

    }

    public Optional<Student> getstudent(String student) {
        if(studentData.containsKey(student)){
            return Optional.of(studentData.get(student));
        }
     return Optional.empty();
    }

    public Optional<Teacher> getTeacher(String teacher) {
        if(teacherData.containsKey(teacher)){
            return  Optional.of(teacherData.get(teacher));
        }
        return Optional.empty();
    }


    public List<String> getStudentByTeacherName(String teacher) {
       return teacherStudentPair.getOrDefault(teacher,new ArrayList<>());
    }

    public List<String> getAllStudent() {
        return new ArrayList<>(studentData.keySet());
    }

    public void deleteTeacher(String teacher) {
        teacherData.remove(teacher);
        teacherStudentPair.remove(teacher);
    }

    public void deleteStudent(String stud) {
        studentData.remove(stud);

    }

    public List<String> getAllTeacher() {
        return new ArrayList<>(teacherData.keySet());
    }
}
