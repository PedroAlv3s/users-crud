package com.java.spring.api.user.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "user_table")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "The annotated field must not be null!")
	@NotBlank(message = "The annotated field must not be blank!")
	private String name;
	
	@NotNull(message = "The annotated field must not be null!")
	@NotBlank(message = "The annotated field must not be blank!")
	@Email(message = "You need to enter with a valid e-mail address!")
	private String email;
	
	@NotNull(message = "The annotated field must not be null!")
	@NotBlank(message = "The annotated field must not be blank!")
	@Size(min = 8)
	private String password;
}