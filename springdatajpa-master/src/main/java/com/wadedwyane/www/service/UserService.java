package com.wadedwyane.www.service;

import com.wadedwyane.www.entity.User;
import com.wadedwyane.www.impl.IUserService;
import com.wadedwyane.www.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableAutoConfiguration
public class UserService implements IUserService {

    @Autowired
    UserRespository userRespository;

    @Override
    public List<User> getUserList() {
        return userRespository.findAll();
    }

    @Override
    public User findUserById(long id) {
        return userRespository.findById(id);
    }

    @Override
    public void save(User user) {
        userRespository.save(user);
    }

    @Override
    public void edit(User user) {
        userRespository.save(user);
    }

    @Override
    public void delete(long id) {
        userRespository.deleteById(id);
    }
}
