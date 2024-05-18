package com.roboelectric.shopslisting.mapper;

import com.roboelectric.shopslisting.dto.UserDTO;
import com.roboelectric.shopslisting.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTACE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOtoUser(UserDTO userDTO);

    UserDTO mapUserToUserDTO(User user);
}
