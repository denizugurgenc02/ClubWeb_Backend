package org.denizugurgenc02.clubweb_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private String email;

    private String firstname;

    private String lastname;

    private Boolean isAdmin;
}
