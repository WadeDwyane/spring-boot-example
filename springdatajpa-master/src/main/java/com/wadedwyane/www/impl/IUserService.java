package com.wadedwyane.www.impl;

import com.wadedwyane.www.entity.User;

import java.util.List;

public interface IUserService {

    public List<User> getUserList();

    public User findUserById(long id);

    public void save(User user);

    public void edit(User user);

    public void delete(long id);

}
