package org.denizugurgenc02.clubweb_backend.services;

import jakarta.transaction.Transactional;
import org.denizugurgenc02.clubweb_backend.dto.UserRequestDTO;
import org.denizugurgenc02.clubweb_backend.dto.UserResponseDTO;
import org.denizugurgenc02.clubweb_backend.entities.User;
import org.denizugurgenc02.clubweb_backend.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
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

    public UserResponseDTO getUser(Integer id) {
        User user = userRepository.read(id);
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        BeanUtils.copyProperties(user, userResponseDTO);
        return userResponseDTO;
    }

    @Transactional
    public UserResponseDTO updateUser(Integer id , UserRequestDTO userRequestDTO) {
        User existingUser = userRepository.read(id);
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        if (existingUser != null) {
            existingUser.setUsername(userRequestDTO.getUsername());
            existingUser.setPassword(userRequestDTO.getPassword());
            existingUser.setEmail(userRequestDTO.getEmail());
            existingUser.setFirstname(userRequestDTO.getFirstname());
            existingUser.setLastname(userRequestDTO.getLastname());
            existingUser.setIsAdmin(userRequestDTO.getIsAdmin());

            userRepository.update(existingUser);
            BeanUtils.copyProperties(existingUser, userResponseDTO);
        }
        return userResponseDTO;
    }

    @Transactional
    public UserResponseDTO deleteUser(Integer id) {
        User user = userRepository.read(id);
        userRepository.delete(id);
        UserResponseDTO userResponseDTO = new UserResponseDTO();

        BeanUtils.copyProperties(user, userResponseDTO);
        return userResponseDTO;
    }

}
