package org.denizugurgenc02.clubweb_backend.configration;

import org.denizugurgenc02.clubweb_backend.dto.UserRequestDTO;
import org.denizugurgenc02.clubweb_backend.services.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class StarterConfig {
    @Value("${admin.username:admin}")
    private String adminUsername;

    @Value("${admin.password:asd123}")
    private String adminPassword;

    @Value("${admin.email:admin@example.com}")
    private String adminEmail;

    @Value("${admin.firstname:admin}")
    private String adminFirstname;

    @Value("${admin.lastname:admin}")
    private String adminLastname;

    @Bean
    @Primary
    public CommandLineRunner initAdminUser(UserService userService) {
        return args -> {
            if (userService.getUserList().size() == 0) {
                UserRequestDTO userRequestDTO = new UserRequestDTO(adminUsername, adminPassword, adminEmail, adminFirstname, adminLastname, true);
                userService.addUser(userRequestDTO);
                System.out.println("Adding a admin user");
            }
        };
    }
}
