package org.denizugurgenc02.clubweb_backend.services;

import org.denizugurgenc02.clubweb_backend.dto.UserRequestDTO;
import org.denizugurgenc02.clubweb_backend.dto.UserResponseDTO;
import org.denizugurgenc02.clubweb_backend.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    public UserResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO) {
        return null;
    }

    public List<UserResponseDTO> getUserList() {
        return null;
    }

    public UserResponseDTO getUser(@RequestBody Integer id) {
        return null;
    }

    public UserResponseDTO updateUser(@RequestBody Integer id , UserRequestDTO userRequestDTO) {
        return null;
    }

    public UserResponseDTO deleteUser(@RequestBody Integer id) {
        return null;
    }

}
