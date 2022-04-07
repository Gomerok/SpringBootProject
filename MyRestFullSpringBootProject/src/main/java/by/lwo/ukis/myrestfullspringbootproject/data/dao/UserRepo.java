package by.lwo.ukis.myrestfullspringbootproject.data.dao;

import by.lwo.ukis.myrestfullspringbootproject.data.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, String> {

}