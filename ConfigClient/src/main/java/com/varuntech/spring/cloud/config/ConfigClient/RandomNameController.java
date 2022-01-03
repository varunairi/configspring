package com.varuntech.spring.cloud.config.ConfigClient;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNameController {
	@Value("${first.name}")
	private String firstName;
	
	@GetMapping("/random")
	public String getRandomName()
	{
		return firstName + new Random().nextDouble();
	}
}
