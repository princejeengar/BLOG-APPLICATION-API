package com.blog;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.blog.config.AppConstant;
import com.blog.entities.Role;
import com.blog.repositories.RoleRepo;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@SpringBootApplication
public class BlogApplication  implements CommandLineRunner{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRope;

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
	@Bean
	ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("xyz"));
		
		try {
			Role role1 = new Role();
			role1.setId(AppConstant.ADMIN_USER);
			role1.setName("ADMIN_USER");
			
			Role role2 = new Role();
			role2.setId(AppConstant.NORMAL_USER);
			role2.setName("NORMAL_USER");
			
			List<Role> roles = List.of(role1, role2);
			List<Role> result = this.roleRope.saveAll(roles);
			result.forEach(r->{
				System.out.println(r.getName());
			});
		}
		catch(Exception e){
			
		}
	}

}
