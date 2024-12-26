package com.li.dao;

import com.li.po.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Author LIJIAN
 * @Date 2024/10/25 16:47
 */

public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);

}
