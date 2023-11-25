package org.autope.configclient.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Configuration
@RefreshScope
public class ClientController {

	@Value("${URL_A: default value}")
	private String URL_A;
	@Value("${URL_B: default value}")
	private String URL_B;

	@Autowired
	Environment env;

	@GetMapping("/a")
	public String getConfigDataA() {
		return URL_A;
	}

	@GetMapping("/b")
	public String getConfigDataB() {
		return URL_B;
	}

	@GetMapping("/get/{key}")
	public String getValue(@PathVariable String key) {
		return env.getProperty(key);
	}
	
	@GetMapping("/key/{key}")
	public String getValues(@PathVariable String key) {
		System.out.println("Key:"+key);
		System.out.println("Value:"+env.getProperty(key));
		return env.getProperty(key);
	}
	
	@GetMapping("/v1/payment")
	public String getPayment() {
		return "Payment Processed";
	}
	
}
