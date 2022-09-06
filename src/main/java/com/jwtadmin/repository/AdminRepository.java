package com.jwtadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtadmin.entity.Admin;
import com.jwtadmin.entity.Student;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	Admin findByAdminName(String adminName);
	
}
