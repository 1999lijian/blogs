package com.li.service.impl;

import com.li.dao.BlogRepository;
import com.li.handler.NotFoundException;
import com.li.po.Blog;
import com.li.po.Type;
import com.li.service.BlogService;
import com.li.vo.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @Author LIJIAN
 * @Date 2024/12/27 0:15
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog getBlog(Long id) {
        Optional<Blog> byId = blogRepository.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            return null;
        }
    }

    /**
     * @param pageable
     * @param blog
     * @return org.springframework.data.domain.Page<com.li.po.Blog>
     * @Description: 基于 Spring Data JPA 框架写在服务层或者数据访问层类中的一个用于查询Blog（博客）数据的方法。方法上的@Override注解表明它重写了父类或接口中定义的同名方法。方法名为listBlog，
     * 它接收Pageable类型的pageable参数用于定义分页相关信息（如每页记录数、排序规则、当前页码等）以及Blog类型的blog参数用于传递查询条件相关信息，返回值类型是Page<Blog>，
     * 即按分页规则组织好的Blog对象集合页面，用于分页查询Blog数据。
     * 方法体中调用了blogRepository的findAll方法来执行数据库查询操作，blogRepository通常是负责与数据库交互的仓库类接口（基于 Spring Data JPA 相关机制）。findAll方法在这里接收两个参数，其中第一个参数是通过匿名内部类实现的Specification<Blog>接口对象，用于定义具体查询条件；第二个参数就是前面提到的pageable用于分页控制。
     * 在匿名内部类实现的Specification<Blog>接口的toPredicate方法里，首先接收了Root<Blog>类型的root（代表要查询的Blog实体对象根节点，可通过它获取实体类各属性来构建条件表达式）、CriteriaQuery<?>类型的cq（用于构建整个查询语句，比如设置查询的WHERE子句条件）以及CriteriaBuilder类型的cb（构建查询条件的工具类，
     * 提供创建不同类型条件表达式的方法）这三个参数。
     * 接着创建了一个List<Predicate>类型的predicates列表用于收集查询条件对应的Predicate对象。
     * 之后有几个if判断语句来构建不同的查询条件：如果传入的blog对象的title属性不为空且不是空字符串，
     * 就用cb.like方法通过root.<String>get("title")获取Blog实体的title属性并构建模糊查询的Predicate（按标题模糊查询）添加到predicates列表中；若blog对象关联的Type对象的id不为空，
     * 就用cb.equal方法基于root.<Type>get("type").get("id")与blog.getType().getId()构建相等条件的Predicate（按类型id筛选）添加到predicates列表；要是blog对象的recommend属性为true，
     * 则用cb.equal方法根据root.<Boolean>get("recommend")与blog.isRecommend()构建相等条件的Predicate（按是否推荐筛选）添加到predicates列表里。
     * 最后通过cq.where(predicates.toArray(new Predicate[predicates.size()]))把收集好的所有Predicate对象数组设置到查询语句的WHERE子句中用于实际条件筛选，不过代码中最后返回了null（从规范角度可能需要返回合适的Predicate对象，但有些框架能处理返回null的情况），
     * 整体实现了根据传入Blog对象携带的不同条件（标题模糊查询、按类型id筛选、按是否推荐筛选等）对Blog数据进行分页查询的功能。
     */
    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        return blogRepository.findAll(new Specification<Blog>() {
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(blog.getTitle()) && blog.getTitle() != null) {
                    predicates.add(cb.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
                }
                if (blog.getTypeId() != null) {
                    predicates.add(cb.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
                }
                if (blog.isRecommend()) {
                    predicates.add(cb.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);
    }

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {

        Optional<Blog> byId = blogRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("该博客不存在");
        }
        Blog blog1 = byId.get();
        BeanUtils.copyProperties(blog1, blog);
        return blogRepository.save(blog1);
    }

    @Override
    public void deleteBlog(Long id) {

    }
}
