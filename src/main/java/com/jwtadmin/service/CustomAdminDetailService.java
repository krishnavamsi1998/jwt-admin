package com.jwtadmin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwtadmin.entity.Admin;

import com.jwtadmin.repository.AdminRepository;

@Service
public class CustomAdminDetailService implements UserDetailsService {
	@Autowired
	private AdminRepository repo;

	@Override
	public UserDetails loadUserByUsername(String adminName) throws UsernameNotFoundException {
		Admin admin = repo.findByAdminName(adminName);
		return new org.springframework.security.core.userdetails.User(admin.getAdminName(), admin.getPassword(),
				new ArrayList<>());
	}

}
