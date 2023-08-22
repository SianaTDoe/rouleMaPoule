package fr.fixgia.roulemapoule.user;

import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {


    void createUser(UserEntity user);

    void deleteUser(String email);

    List<UserEntity> getAllUser();





}
