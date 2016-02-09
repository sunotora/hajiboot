package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner{

	@Autowired
	private CustomerService customerService;

	@Override
	public void run(String... args) throws Exception {
		//データ追加
		customerService.save(new Customer(1, "1a", "1b"));
		customerService.save(new Customer(2, "2a", "2b"));
		customerService.save(new Customer(3, "3a", "3b"));

		//データ表示
		customerService.findAll().forEach(System.out::println);
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
