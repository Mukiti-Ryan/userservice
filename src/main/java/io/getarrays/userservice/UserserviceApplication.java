package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Charles Boyle", "boyle", "duck", new ArrayList<>()));
            userService.saveUser(new User(null, "Rosa Diaz", "diaz", "motorcycle", new ArrayList<>()));
            userService.saveUser(new User(null, "Gina Linetti", "linetti", "linizzles", new ArrayList<>()));
            userService.saveUser(new User(null, "Jake Peralta", "peralta", "diehard", new ArrayList<>()));
            userService.saveUser(new User(null, "Amy Santiago", "santiago", "binders", new ArrayList<>()));
            userService.saveUser(new User(null, "Raymond Holt", "holt", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Terry Jeffords", "jeffords", "cagneylacey", new ArrayList<>()));

            userService.addRoleToUser("boyle", "ROLE_USER");
            userService.addRoleToUser("diaz", "ROLE_MANAGER");
            userService.addRoleToUser("linetti", "ROLE_USER");
            userService.addRoleToUser("peralta", "ROLE_USER");
            userService.addRoleToUser("santiago", "ROLE_MANAGER");
            userService.addRoleToUser("holt", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("holt", "ROLE_ADMIN");
            userService.addRoleToUser("holt", "ROLE_USER");
            userService.addRoleToUser("jeffords", "ROLE_ADMIN");
        };
    }
}
