package com.hivelab.paymentprj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siot.IamportRestClient.IamportClient;

@Configuration
public class AppConfig {

	String apiKey = "4814965505762421";
	String secretKey = "ETZ099aDZj6VZGr0b9GrCXCWJ5bZWawB3vCcEMQE6WA6C17OaNgNLTKuYVuV50x9w9mbWcP38p9LqgAB";

	@Bean
	public IamportClient iamportClient() {
		return new IamportClient(apiKey, secretKey);
	}
}
