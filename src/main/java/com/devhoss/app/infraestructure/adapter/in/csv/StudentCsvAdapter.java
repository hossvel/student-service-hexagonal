package com.devhoss.app.infraestructure.adapter.in.csv;

import com.devhoss.app.domain.model.Student;
import com.devhoss.app.domain.port.in.IStudentServicePort;
import com.devhoss.app.infraestructure.adapter.in.csv.dto.StudentCsvDto;
import com.devhoss.app.infraestructure.adapter.in.csv.mapper.IStudentCsvMapper;
import com.sun.jdi.IntegerValue;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@RequiredArgsConstructor
@Configuration
public class StudentCsvAdapter {

    @Value("${csvFilePath}")
    private String csvFilePath;

    private final IStudentServicePort _iStudentServicePort;

    @Bean
    public void SaveStudentFromCsv() {

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length >= 4) {
                    String firstname = columns[0].trim();
                    String lastname = columns[1].trim();
                    String age = columns[2].trim();
                    String address = columns[3].trim();
                    StudentCsvDto studentCsvDto = new StudentCsvDto(firstname,lastname, Integer.parseInt(age), address);

                    Student student = IStudentCsvMapper.INSTANCE.StudentCsvDtoToStudent(studentCsvDto);
                    _iStudentServicePort.save(student);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
