package com.usertask.app.service;

import com.usertask.app.playload.UserDto;

public interface UserService {
    public UserDto createUser(UserDto userDto);

    public UserDto getUserById(Long id);
}
