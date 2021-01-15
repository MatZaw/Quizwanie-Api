package com.example.loginApi.repository;

import com.example.loginApi.dto.ResultDto;
import com.example.loginApi.dto.UserDto;

import java.util.List;

public interface UsersRepository {
    List<UserDto> getUsers();
    Boolean login(UserDto user);
    void logout(UserDto user);
    Boolean createUser(String login, String password);
    void postResult(ResultDto result);
    List<ResultDto> getResults();
}
