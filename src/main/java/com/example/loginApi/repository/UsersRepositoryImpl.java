package com.example.loginApi.repository;

import com.example.loginApi.dto.ResultDto;
import com.example.loginApi.dto.UserDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryImpl implements UsersRepository{
    private List<UserDto> users;
    private List<ResultDto> results;
    private Optional<Integer> index;
    public UsersRepositoryImpl() {
        users = new ArrayList<>();
        results = new ArrayList<>();
        users.add(new UserDto("Andrzej", "andrzej123"));
        users.add(new UserDto("Ela", "elka1"));
        users.add(new UserDto("kacper", "kacpero"));
        users.add(new UserDto("kasztan", "123kasztan"));
        users.add(new UserDto("mieciu", "mietek67"));
    }

    @Override
    public List<UserDto> getUsers() {
        return users;
    }

    private Optional<Integer> findIndex(UserDto user){
        Integer i = 0;
        for(UserDto u : users){
            if(user.getLogin().toLowerCase().equals(u.getLogin().toLowerCase())){
               return Optional.of(i);
            }
            i++;
        }
        return Optional.empty();
    }

    @Override
    public Boolean login(UserDto user) {
        index = findIndex(user);
        System.out.println(index);
        if(index.isPresent()){
            if(user.getPassword().equals(users.get(index.get()).getPassword())){
                users.get(index.get()).setLogged(true);
                return true;
            }
        }
        return false;
    }

    @Override
    public void logout(UserDto user) {
        index.ifPresent(integer -> users.get(integer).setLogged(false));
    }

    @Override
    public Boolean createUser(String login, String password) {
        for(UserDto u : users){
            if(u.getLogin().toLowerCase().equals(login.toLowerCase())){
                return false;
            }
        }

        users.add(new UserDto(login, password));

        return true;
    }

    @Override
    public void postResult(ResultDto result) {
        results.add(result);
    }

    @Override
    public List<ResultDto> getResults() {
        return results;
    }
}
