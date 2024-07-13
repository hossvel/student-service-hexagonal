package com.devhoss.app.infraestructure.adapter.in.csv.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCsvDto {

    @NotBlank(message = "Field firstname cannot be empty or null.")
    private String firstname;

    @NotBlank(message = "Field lastname cannot be empty or null.")
    private String lastname;

    @NotNull(message = "Field age cannot be null.")
    private Integer age;

    @NotBlank(message = "Field address cannot be empty or null.")
    private String address;
}
