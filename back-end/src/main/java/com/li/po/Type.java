package com.li.po;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

//分类实体类
@Entity
@Table(name = "t_type")
public class Type {

    //    id
    @Id
    @GeneratedValue
    private Long id;
    //    名称
    @NotBlank(message = "分类名称不能为空")
    private String name;
    //    @OneToMany表明当前实体与另一个实体之间存在一对多的关联关系。
    //mappedBy = "type"指定了这个关系的反向端
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();

    public Type() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
