package com.li.service.impl;

import com.li.dao.UserRepositoy;
import com.li.po.User;
import com.li.service.UserService;
import com.li.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServieceImpl implements UserService {

    @Autowired
    private UserRepositoy userRepositoy ;


    @Override
    public User checkUser(String username, String password) {
        User user =userRepositoy.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
