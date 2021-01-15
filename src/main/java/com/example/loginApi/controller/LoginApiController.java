package com.example.loginApi.controller;

import com.example.loginApi.dto.ResultDto;
import com.example.loginApi.dto.UserDto;
import com.example.loginApi.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginApiController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginApiController.class);
    private UserDto userDto;

    @Autowired
    private LoginService loginService;



    @PostMapping("/login/{login}/{password}")
    ResponseEntity<Void> login(@PathVariable("login") String login, @PathVariable("password") String password){

        userDto = new UserDto(login, password);

        LOG.info("userDTO = " + userDto.getLogin() + ", " + userDto.getPassword());
        LOG.info("PathVariable = " + login + ", " + password);
        if(loginService.login(userDto)){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/logout/{login}")
    ResponseEntity<Void> logout(@PathVariable("login") String login){
        if(userDto.getLogin().equals(login)){
            loginService.logout(userDto);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/results")
    ResponseEntity<List<ResultDto>> getResults(){
        return ResponseEntity.ok().body(loginService.getResults());
    }

    @GetMapping("/users")
    ResponseEntity<List<UserDto>> getUsers(){
        return ResponseEntity.ok().body(loginService.getUsers());
    }

    @PostMapping("/createUser/{login}/{password}")
    ResponseEntity<Void> createUser(@PathVariable("login") String login, @PathVariable("password") String password){
        if(loginService.createUser(login,password)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/postResult/{username}/{title}/{score}/{max}")
    ResponseEntity<Void> postResult(@PathVariable("username") String username, @PathVariable("title") String title, @PathVariable("score") String score, @PathVariable("max") String max){
        loginService.postResult(username,title,Integer.parseInt(score),Integer.parseInt(max));
        return ResponseEntity.ok().build();
    }
}
