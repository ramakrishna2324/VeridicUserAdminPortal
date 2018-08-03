package com.buddy;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.buddy.domain.User;
import com.buddy.domain.security.Role;
import com.buddy.domain.security.UserRole;
import com.buddy.service.UserService;
import com.buddy.utility.SecurityUtility;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner
{

	@Autowired
	private UserService userService;

	public static void main(String[] args)
	{
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		User user1 = new User();
		user1.setFirstName("John");
		user1.setLastName("Adams");
		user1.setUsername("j");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("JAdams@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);
	}
}
