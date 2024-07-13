package com.devhoss.app.infraestructure.adapter.out.persistence;

import com.devhoss.app.domain.model.Student;
import com.devhoss.app.domain.port.out.IStudentPersistencePort;
import com.devhoss.app.infraestructure.adapter.out.persistence.mapper.StudentPersistenceMapper;
import com.devhoss.app.infraestructure.adapter.out.persistence.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements IStudentPersistencePort {
    private final IStudentRepository _iStudentRepository;
    private final StudentPersistenceMapper _iStudentPersistenceMapper;
    @Override
    public Optional<Student> findById(Long id) {

        return _iStudentRepository.findById(id).map(_iStudentPersistenceMapper::toStudent);
    }

    @Override
    public List<Student> findAll() {

        return _iStudentPersistenceMapper.toStudentList(_iStudentRepository.findAll());
    }

    @Override
    public Student save(Student student) {
        return _iStudentPersistenceMapper.toStudent(
                _iStudentRepository.save(_iStudentPersistenceMapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
        _iStudentRepository.deleteById(id);
    }
}
