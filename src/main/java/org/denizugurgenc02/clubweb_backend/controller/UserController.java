package org.denizugurgenc02.clubweb_backend.controller;

import org.denizugurgenc02.clubweb_backend.dto.UserRequestDTO;
import org.denizugurgenc02.clubweb_backend.dto.UserResponseDTO;
import org.denizugurgenc02.clubweb_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/add")
    public UserResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO) {
        return userService.addUser(userRequestDTO);
    }

    @GetMapping(path = "/list")
    public List<UserResponseDTO> getUserList() {
        return userService.getUserList();
    }

    @GetMapping(path = "/{id}")
    public UserResponseDTO getUser(@PathVariable(value = "id") Integer id) {
        return userService.getUser(id);
    }

    @PutMapping(path = "/{id}")
    public UserResponseDTO putUser(@PathVariable(value = "id") Integer id, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(id, userRequestDTO);
    }

    /*@PatchMapping
    public UserResponseDTO pathUser(@PathVariable(value = "id") Integer id, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(id, userRequestDTO);
    }*/

    @DeleteMapping(path = "/{id}")
    public UserResponseDTO deleteUser(@PathVariable(value = "id") Integer id) {
        return userService.deleteUser(id);
    }
}
