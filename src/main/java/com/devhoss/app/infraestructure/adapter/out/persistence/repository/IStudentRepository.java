package com.devhoss.app.infraestructure.adapter.out.persistence.repository;

import com.devhoss.app.infraestructure.adapter.out.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, Long> {
}
