package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
	  SpringApplication.run(DemoApplication.class, args);
	}

//  @Bean
//  public CommandLineRunner init(ApplicationContext ctx) {
//    return args -> {
//      System.out.println("Let's inspect the beans provided by Spring Boot:");
//      String[] beanNames = ctx.getBeanDefinitionNames();
//      Arrays.sort(beanNames);
//      for (String beanName : beanNames) {
//        System.out.println(beanName);
//      }
//
//    };
//  }

  @Bean
  public CommandLineRunner init(UserRepository userRepository) {
    return args -> {
      Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
        User user = new User(name, name.toLowerCase() + "@domain.com");
        userRepository.save(user);
      });
      userRepository.findAll().forEach(System.out::println);
    };
  }

}
