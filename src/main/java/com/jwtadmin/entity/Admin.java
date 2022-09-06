package com.jwtadmin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ADMIN_TBL")
public class Admin {
	
	@Id
	private int adminId;
	@Column(unique=true)
	@NotNull
	private String adminName;
	@NotNull
	private String password;
	
}
