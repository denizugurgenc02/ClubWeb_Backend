package org.denizugurgenc02.clubweb_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String email;
    private String firstname;
    private String lastname;
    private Boolean isAdmin;
}
