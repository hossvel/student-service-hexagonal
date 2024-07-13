package com.devhoss.app.domain.port.out;

import com.devhoss.app.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentPersistencePort {
    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Long id);
}
