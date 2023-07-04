package com.example.loginAPI.repository;

import com.example.loginAPI.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findAllByEmail(String email);

    User findAllByUserName(String userName);

    User findAllByPassWord(String passWord);
}
