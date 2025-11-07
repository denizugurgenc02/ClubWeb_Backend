package org.denizugurgenc02.clubweb_backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDTO {
    @NotBlank(message = "Username field not be empty")
    private String username;

    @NotBlank(message = "Password field not be empty")
    private String password;

    @NotBlank(message = "Email field not be empty")
    @Email(message = "Email field must be right email format")
    private String email;

    private String firstname;

    private String lastname;

    private Boolean isAdmin;
}
