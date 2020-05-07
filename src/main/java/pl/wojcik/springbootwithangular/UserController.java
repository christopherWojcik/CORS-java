package pl.wojcik.springbootwithangular;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        userRepository.findAll().forEach(System.out::print);
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/user1")
    public List<User> getUsers1() {
        userRepository.save(new User("Janek", "someEMAIL@domain.com"));
        return (List<User>) userRepository.findAll();
    }


    @PostMapping("/users")
    void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

}
