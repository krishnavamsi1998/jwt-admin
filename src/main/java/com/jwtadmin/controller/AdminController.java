package com.jwtadmin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwtadmin.entity.AuthorizationRequest;
import com.jwtadmin.entity.Student;
import com.jwtadmin.repository.AdminRepository;
import com.jwtadmin.repository.StudentRepository;
import com.jwtadmin.util.JwtUtil;

@RestController
public class AdminController {

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private StudentRepository studentRepo;

	@GetMapping("/")
	public String hello() {
		return "hello admin";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthorizationRequest authRequest) throws Exception {
		try {

			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

	@PostMapping("/addStudentsAndCourses")

	public String add(@RequestBody List<Student> students) {

		studentRepo.saveAll(students);

		return "Students and their courses added successfully";
	}

	@GetMapping("/getAllStudentsAndCourses")
	public List<Student> get() {
		return studentRepo.findAll();
	}

	@GetMapping("/findStudent/{studentId}")
	public Optional<Student> findStudentById(@PathVariable("studentId") int studentId) {

		return studentRepo.findById(studentId);
	}

	@DeleteMapping("/deleteStudent/{studentId}")
	public String deleteStudentById(@PathVariable("studentId") int studentId) {
		studentRepo.deleteById(studentId);
		return "Student with ID " + studentId + " deleted sucessfully";

	}
}
