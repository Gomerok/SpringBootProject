package by.lwo.ukis.myrestfullspringbootproject.data.dao;

import by.lwo.ukis.myrestfullspringbootproject.data.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, String> {
}
