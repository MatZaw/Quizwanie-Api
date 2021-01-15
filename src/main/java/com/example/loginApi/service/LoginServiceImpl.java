package com.example.loginApi.service;

import com.example.loginApi.dto.ResultDto;
import com.example.loginApi.dto.UserDto;
import com.example.loginApi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UsersRepository usersRepository;

    public LoginServiceImpl() {
    }

    @Override
    public Boolean login(UserDto user) {
        return usersRepository.login(user);
    }

    @Override
    public void logout(UserDto user) {
        usersRepository.logout(user);
    }

    @Override
    public List<UserDto> getUsers() {
        return usersRepository.getUsers();
    }

    @Override
    public Boolean createUser(String login, String password) {
        return usersRepository.createUser(login, password);
    }

    @Override
    public List<ResultDto> getResults() {
        return usersRepository.getResults();
    }

    @Override
    public void postResult(String username, String title, int score, int max) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        usersRepository.postResult(new ResultDto(username,title,score,max,formatter.format(date)));
    }

}
