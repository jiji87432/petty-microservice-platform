package com.github.pettyfer.basic.auth;

import com.alibaba.fastjson.JSONObject;
import com.github.pettyfer.basic.auth.service.UserDetailsServiceImpl;
import com.github.pettyfer.basic.auth.utils.UserDetailsImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PettyAuthServiceApplicationTests {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Test
	public void contextLoads() {
		UserDetails userDetails = userDetailsService.loadUserByUsername("pettyfer");
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
		System.out.println(new BCryptPasswordEncoder().matches("admin","$2a$10$ruJZU6MaoqoTGstpiBs5P.y3OIs0f3H01iyf31qZz1NnS/BxrHMOa"));
	}

}
