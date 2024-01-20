package com.kaya.kaya01;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Kaya01Application {

    public static void main(String[] args) {
        SpringApplication.run(Kaya01Application.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

}
