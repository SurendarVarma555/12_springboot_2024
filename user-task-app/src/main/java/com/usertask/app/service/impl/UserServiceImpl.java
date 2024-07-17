package com.usertask.app.service.impl;

import com.usertask.app.entity.Users;
import com.usertask.app.playload.UserDto;
import com.usertask.app.repository.UserRepo;
import com.usertask.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser (UserDto userDto){
        Users user = userDtoToEntity(userDto);
        Users savedUser = userRepo.save(user);
        return entityToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById (Long id){
        Users savedUser = userRepo.findById(id).get();
        return entityToUserDto(savedUser);
    }

    private Users userDtoToEntity (UserDto userDto){
        Users users = new Users();
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        return users;
    }

    private UserDto entityToUserDto (Users savedUser){
        UserDto userDto = new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setName(savedUser.getName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setPassword(savedUser.getPassword());
        return userDto;

    }
}
