package com.example.loginApi.service;

import com.example.loginApi.dto.ResultDto;
import com.example.loginApi.dto.UserDto;

import java.util.List;

public interface LoginService {
    Boolean login(UserDto user);
    void logout(UserDto user);
    List<UserDto> getUsers();
    Boolean createUser(String login, String password);
    List<ResultDto> getResults();
    void postResult(String username, String title, int score, int max);
}
