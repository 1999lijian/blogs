package com.li.dao;

import com.li.po.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author LIJIAN
 * @Date 2024/12/27 0:16
 */
public interface BlogRepository extends JpaRepository<Blog,Long>  , JpaSpecificationExecutor<Blog> {
}
