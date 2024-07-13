package com.devhoss.app.application.usercase;

import com.devhoss.app.domain.model.Student;
import com.devhoss.app.domain.port.in.IStudentServicePort;
import com.devhoss.app.domain.port.out.IStudentPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.devhoss.app.domain.exception.StudentNotFoundException;

import java.util.List;

@Component
//@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentServicePort {

    @Autowired
    @Qualifier("impl1")
    private IStudentPersistencePort _iStudentPersistencePort;

    @Override
    public Student findById(Long id) {
        return _iStudentPersistencePort.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public List<Student> findAll() {
        return _iStudentPersistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return _iStudentPersistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return _iStudentPersistencePort.findById(id)
                .map(savedStudent -> {
                    savedStudent.setFirstname(student.getFirstname());
                    savedStudent.setLastname(student.getLastname());
                    savedStudent.setAge(student.getAge());
                    savedStudent.setAddress(student.getAddress());
                    return _iStudentPersistencePort.save(savedStudent);
                })
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (_iStudentPersistencePort.findById(id).isEmpty()) {
            throw new StudentNotFoundException();
        }

        _iStudentPersistencePort.deleteById(id);
    }
}
