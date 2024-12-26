package com.li.service;

import com.li.po.Tag;
import com.li.po.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author LIJIAN
 * @Date 2024/10/25 16:42
 */
public interface TagService {
    //    保存
    Tag saveTag(Tag tag);

    //    根据id获取
    Tag getTag(Long id);

    //    分页
    Page<Tag> listTag(Pageable pageable);

    //    更新
    Tag updateTag(Long id, Tag tag);

    //    根据id删除
    void deleteTag(Long id);

    //    通过名称查询
    Tag getTagByName(String name);
}
