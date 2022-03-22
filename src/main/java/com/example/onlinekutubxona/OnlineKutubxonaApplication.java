package com.example.onlinekutubxona;

import com.example.onlinekutubxona.entity.Users;
import com.example.onlinekutubxona.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineKutubxonaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineKutubxonaApplication.class, args);
    }

//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public void run(String...args) throws Exception {
//        Users admin = new Users();
//        admin.setIsAdmin(true);
//        admin.setEmail("Muhammadqodir@gmail.com");
//        admin.setFirstName("Muhammadqodir");
//        admin.setLastName("Abdullajonov");
//        admin.setPhone("+998950035369");
//        admin.setPassword("1122");
//        userRepository.save(admin);
//
//    }
}
