package org.denizugurgenc02.clubweb_backend.services;

import jakarta.transaction.Transactional;
import org.apache.coyote.BadRequestException;
import org.denizugurgenc02.clubweb_backend.dto.UserRequestDTO;
import org.denizugurgenc02.clubweb_backend.dto.UserResponseDTO;
import org.denizugurgenc02.clubweb_backend.entities.User;
import org.denizugurgenc02.clubweb_backend.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO) {
        User user = new User();
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        BeanUtils.copyProperties(userRequestDTO, user);
        userRepository.create(user);

        BeanUtils.copyProperties(user, userResponseDTO);
        return userResponseDTO;
    }

    public List<UserResponseDTO> getUserList() {
        List<User> userList = userRepository.readAll();
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user : userList) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            BeanUtils.copyProperties(user, userResponseDTO);
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
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
