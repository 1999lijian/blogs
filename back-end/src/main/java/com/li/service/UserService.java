package com.li.service;

import com.li.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
