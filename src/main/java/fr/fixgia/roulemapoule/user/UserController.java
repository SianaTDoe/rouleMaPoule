package fr.fixgia.roulemapoule.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@RequestBody final UserEntity user) {

        log.debug("Controller UserApplication: create User - Called");

        userService.createUser(user);
        return user;

    }

    @PostMapping("/deleteUser/{email}")
    public void deletePatient(@PathVariable("email")String email){

        log.debug("Controller UserApplication: deleteUser - called");
        userService.deleteUser(email);
    }

    @GetMapping("/all")
    public List<UserEntity> getAll() {
        return userService.getAllUser();
    }

}
