package com.li.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//博客实体类
@Entity
@Table(name = "t_blog")
public class Blog {

    //    id
    //   @GeneratedValue注解通常与@Id一起使用，用于指定主键的生成策略
    @Id
    @GeneratedValue
    private Long id;
    //    标题
    private String title;
    //    内容
    private String content;
    //    首图
    private String firstPicture;
    //    标记
    private String flag;
    //    浏览次数
    private Integer views;
    //    赞赏开启
    private boolean appreciation;
    //    版权开启
    private boolean shareStatement;
    //    评论开启
    private boolean commentabled;
    //    发布
    private boolean published;
    //  推荐开启
    private boolean recommend;
    //    创建时间
    //     Java 对象的日期时间属性应该如何映射到数据库中的时间戳列。
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    //    更新时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    //    @ManyToOne注解表示多对一的关系
    @ManyToOne
    private Type type;
    //@ManyToMany注解用于表示多对多的关联关系
    /*
    cascade属性用于指定在对一个实体进行特定操作时，是否应该自动将该操作传播到与之相关联的实体上。
    CascadeType.PERSIST表示当对一个实体进行持久化操作（通常是保存到数据库）时，
    与其相关联且配置了此级联类型的实体也会被自动持久化。
   */
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    //@ManyToOne注解用于表示多对一的关联关系
    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();


    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
