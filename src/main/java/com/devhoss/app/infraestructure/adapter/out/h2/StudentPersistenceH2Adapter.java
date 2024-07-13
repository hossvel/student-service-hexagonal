package com.devhoss.app.infraestructure.adapter.out.h2;

import com.devhoss.app.domain.model.Student;
import com.devhoss.app.domain.port.out.IStudentPersistencePort;
import com.devhoss.app.infraestructure.adapter.out.persistence.mapper.StudentPersistenceMapper;
import com.devhoss.app.infraestructure.adapter.out.persistence.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("impl2")
@RequiredArgsConstructor
public class StudentPersistenceH2Adapter implements IStudentPersistencePort {
   // private final IStudentRepository _iStudentRepository;
    //private final StudentPersistenceMapper _iStudentPersistenceMapper;

            @Override
            public Optional<Student> findById(Long id) {
                return Optional.empty();
            }

            @Override
            public List<Student> findAll() {
                System.out.println("findAll - H2");
                return null;
            }

            @Override
            public Student save(Student student) {
                return null;
            }

            @Override
            public void deleteById(Long id) {

            }
        }
