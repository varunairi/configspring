package com.varuntech.spring.cloud.config.ConfigClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingsController {
	@Value("${greeting}")
	private String greeting;
	@GetMapping("/")
	public String showGreeting() {
	return greeting;
}
}
