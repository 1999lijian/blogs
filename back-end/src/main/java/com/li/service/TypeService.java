package com.li.service;

import com.li.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author LIJIAN
 * @Date 2024/10/25 16:42
 */
public interface TypeService {
//    保存
    Type saveType(Type type);
//    根据id获取
    Type getType(Long id);
//    分页
    Page<Type> listType (Pageable pageable);
//    更新
    Type updateType(Long id,Type type);
//    根据id删除
    void deleteTyep(Long id);
//    通过名称查询
    Type getTypeByName(String name);
}
