package com.devhoss.app.infraestructure.adapter.in.rest;



import com.devhoss.app.domain.port.in.IStudentServicePort;
import com.devhoss.app.infraestructure.adapter.in.rest.dto.request.StudentCreateRequest;
import com.devhoss.app.infraestructure.adapter.in.rest.dto.response.StudentResponse;
import com.devhoss.app.infraestructure.adapter.in.rest.mapper.IStudentRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentRestAdapter {

    private final IStudentServicePort _iStudentServicePort;
   private final IStudentRestMapper restMapper;


    @GetMapping("/v1/api")
    public List<StudentResponse> findAll() {

        return restMapper.toStudentResponseList(_iStudentServicePort.findAll());
    }

    @GetMapping("/v1/api/{id}")
    public StudentResponse findById(@PathVariable Long id) {
        return restMapper.toStudentResponse(_iStudentServicePort.findById(id));
    }

    @PostMapping("/v1/api")
    public ResponseEntity<StudentResponse> save(@Valid @RequestBody StudentCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(restMapper.toStudentResponse(
                        _iStudentServicePort.save(restMapper.toStudent(request))));
    }

    @PutMapping("/v1/api/{id}")
    public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentCreateRequest request) {
        return restMapper.toStudentResponse(
                _iStudentServicePort.update(id, restMapper.toStudent(request)));
    }

    @DeleteMapping("/v1/api/{id}")
    public void delete(@PathVariable Long id) {
        _iStudentServicePort.deleteById(id);
    }

}
