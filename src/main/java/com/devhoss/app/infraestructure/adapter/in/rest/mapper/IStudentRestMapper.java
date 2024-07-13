package com.devhoss.app.infraestructure.adapter.in.rest.mapper;


import com.devhoss.app.domain.model.Student;
import com.devhoss.app.infraestructure.adapter.in.rest.dto.request.StudentCreateRequest;
import com.devhoss.app.infraestructure.adapter.in.rest.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IStudentRestMapper {

    Student toStudent(StudentCreateRequest request);

    StudentResponse toStudentResponse(Student student);

    List<StudentResponse> toStudentResponseList(List<Student> studentList);

}
