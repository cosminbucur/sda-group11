package com.sda.spring.mvc.hibernate.dao;

import com.sda.spring.mvc.hibernate.model.User;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class UserDaoInMemory implements UserDao {

    private List<User> users = new ArrayList<>();

    @Override
    public void create(User user) {
        users.add(user);
    }
}
