package by.lwo.ukis.myrestfullspringbootproject.service;

import by.lwo.ukis.myrestfullspringbootproject.data.pojo.User;

import java.io.Serializable;
import java.util.List;

public interface UserService {

    User saveUser(User user);
    User updateUser(User user);
    User getUser(String id);
    Iterable<User> getUsers();
    void deleteUser(String id);
}
