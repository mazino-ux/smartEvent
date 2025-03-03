package com.mathena.smartEventM.model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password; 
	@Column(nullable = false)
	private String role;
	

	
	@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
				name = "user_roles",
				joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "id")}
				
				
			)
	private List<Role> roles = new ArrayList<>();

}
