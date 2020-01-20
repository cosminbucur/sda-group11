package com.sda.spring.mvc.hibernate.service;

import com.sda.spring.mvc.hibernate.dao.UserDao;
import com.sda.spring.mvc.hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    @Transactional
    public void create(final User user) {
        dao.create(user);
    }
}
