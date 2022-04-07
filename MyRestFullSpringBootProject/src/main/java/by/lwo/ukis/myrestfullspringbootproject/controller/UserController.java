package by.lwo.ukis.myrestfullspringbootproject.controller;


import by.lwo.ukis.myrestfullspringbootproject.data.dao.UserRepo;
import by.lwo.ukis.myrestfullspringbootproject.data.pojo.User;
import by.lwo.ukis.myrestfullspringbootproject.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/v1/api")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserRepo userRepo;
    private final UserServiceImpl userServiceImpl;

    public UserController(UserRepo userRepo, UserServiceImpl userServiceImpl) {
        this.userRepo = userRepo;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getAllUsers() {
        try {
            Iterable<User> users = userServiceImpl.getUsers();
            return new ResponseEntity<Object>(users, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") String id) {
        try {
            User user = userServiceImpl.getUser(id);
            if (user != null) {
                return new ResponseEntity<Object>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try {
            User savedUser = userServiceImpl.saveUser(user);
            return new ResponseEntity<Object>(savedUser, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") String id, @RequestBody User user) {
        try {
            User isUser = userServiceImpl.getUser(id);
            if (isUser != null) {
                user.setId(id);
                User updatedUser = userServiceImpl.updateUser(user);
                return new ResponseEntity<Object>(updatedUser, HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
        try {
            userServiceImpl.deleteUser(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}