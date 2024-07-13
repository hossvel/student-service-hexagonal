package com.devhoss.app.infraestructure.adapter.in.csv.mapper;

import com.devhoss.app.domain.model.Student;
import com.devhoss.app.infraestructure.adapter.in.csv.dto.StudentCsvDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IStudentCsvMapper {

    IStudentCsvMapper INSTANCE = Mappers.getMapper(IStudentCsvMapper.class);

    StudentCsvDto StudentToStudentCsvDto(Student student);

    Student StudentCsvDtoToStudent(StudentCsvDto studentCsvDto);

}
