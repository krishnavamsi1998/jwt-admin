package com.jwtadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwtadmin.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
