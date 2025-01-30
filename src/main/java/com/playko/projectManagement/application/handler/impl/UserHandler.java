package com.playko.projectManagement.application.handler.impl;

import com.playko.projectManagement.application.dto.request.UserRequestDto;
import com.playko.projectManagement.application.dto.response.UserResponseDto;
import com.playko.projectManagement.application.handler.IUserHandler;
import com.playko.projectManagement.application.mapper.request.IUserRequestMapper;
import com.playko.projectManagement.application.mapper.response.IUserResponseMapper;
import com.playko.projectManagement.domain.api.IUserServicePort;
import com.playko.projectManagement.domain.model.UserModel;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public UserResponseDto findByEmail(String email) {
        UserModel userModel = userServicePort.findByEmail(email);
        return userResponseMapper.toResponse(userModel);
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        return userResponseMapper.toResponseList(userServicePort.findAllUsers());
    }

    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        UserModel userModel = userRequestMapper.toUserRequest(userRequestDto);
        userServicePort.saveUser(userModel);
    }
}
