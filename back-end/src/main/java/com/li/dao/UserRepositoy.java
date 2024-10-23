package com.li.dao;

import com.li.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoy extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);
}
