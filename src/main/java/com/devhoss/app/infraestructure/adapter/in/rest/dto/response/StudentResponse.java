package com.devhoss.app.infraestructure.adapter.in.rest.dto.response;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {

    private Long id;
    private String firstname;
    private String lastname;
    private Integer age;
    private String address;

}
