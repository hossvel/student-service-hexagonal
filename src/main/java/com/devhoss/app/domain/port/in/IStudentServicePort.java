package com.devhoss.app.domain.port.in;

import com.devhoss.app.domain.model.Student;

import java.util.List;

public interface IStudentServicePort {
    Student findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    Student update(Long id, Student student);
    void deleteById(Long id);
}
