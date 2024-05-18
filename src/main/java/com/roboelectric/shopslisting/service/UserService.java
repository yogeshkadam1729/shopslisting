package com.roboelectric.shopslisting.service;

import com.roboelectric.shopslisting.dto.UserDTO;
import com.roboelectric.shopslisting.entity.User;
import com.roboelectric.shopslisting.mapper.UserMapper;
import com.roboelectric.shopslisting.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUsers()
    {
        List<User>  user = userRepository.findAll();
        List<UserDTO> userDTOS = user.stream().map(e-> UserMapper.INSTACE.mapUserToUserDTO(e)).collect(Collectors.toList());
        return userDTOS;
    }

    public UserDTO getUserById(int id)
    {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) return null;
        return UserMapper.INSTACE.mapUserToUserDTO(user.get());

    }
    public UserDTO addUser(UserDTO userDTO)
    {
        User user = userRepository.save(UserMapper.INSTACE.mapUserDTOtoUser(userDTO));
        return UserMapper.INSTACE.mapUserToUserDTO(user);
    }
}
