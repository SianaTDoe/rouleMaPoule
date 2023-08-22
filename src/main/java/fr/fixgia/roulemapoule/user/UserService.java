package fr.fixgia.roulemapoule.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService{

    private final UserEntityRepository userEntityRepository;

    public UserService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public void createUser(UserEntity user) {
       UserEntity userExist =  userEntityRepository.findUserEntityByEmail(user.getEmail());

        if (userExist != null) {
            throw new RuntimeException("utilisateurs existe déjà");
        }
        userEntityRepository.save(user);

    }

    @Override
    public void deleteUser(String email) {
        UserEntity userToDelete = userEntityRepository.findUserEntityByEmail(email);

        if(userToDelete != null) {
            userEntityRepository.delete(userToDelete);
        }
        throw new RuntimeException("utilisateurs existe déjà");
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userEntityRepository.findAll();
    }
}
