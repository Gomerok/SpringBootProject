package by.lwo.ukis.myrestfullspringbootproject.service;

import by.lwo.ukis.myrestfullspringbootproject.data.dao.UserRepo;
import by.lwo.ukis.myrestfullspringbootproject.data.dao.UserRoleRepo;
import by.lwo.ukis.myrestfullspringbootproject.data.pojo.User;
import by.lwo.ukis.myrestfullspringbootproject.data.pojo.UserRole;
import by.lwo.ukis.myrestfullspringbootproject.data.pojo.enums.UserRoleType;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;


    public UserServiceImpl(UserRepo userRepo, UserRoleRepo userRoleRepo) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
    }


    @Override
    public User saveUser(User user) {
        LocalDateTime creationTime = LocalDateTime.now();
        User savedUser = userRepo.save(user);
        UserRole userRole = new UserRole(savedUser, UserRoleType.USER,creationTime);
        System.out.printf(String.valueOf(userRole));
        userRoleRepo.save(userRole);
        return savedUser;
    }

    @Override
    public User updateUser(User user) {
        User savedUser = userRepo.save(user);
        return savedUser;
    }

    @Override
    public User getUser(String id) {

        User user = userRepo.findById(id).get();
        return user;
    }

    @Override
    public Iterable<User> getUsers() {
        Iterable<User> users = userRepo.findAll();
        return users;
    }

    @Override
    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
}
