package com.devhoss.app.infraestructure.adapter.out.persistence.mapper;


import com.devhoss.app.domain.model.Student;
import com.devhoss.app.infraestructure.adapter.out.persistence.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface StudentPersistenceMapper {

    StudentEntity toStudentEntity(Student student);

    Student toStudent(StudentEntity entity);

    List<Student> toStudentList(List<StudentEntity> entityList);

}
