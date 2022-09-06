package com.jwtadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtadmin.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
