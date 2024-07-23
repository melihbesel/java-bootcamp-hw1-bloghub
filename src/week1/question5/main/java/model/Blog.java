package model;

import model.enums.BlogStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Blog {

    private String title;
    private String text;
    private LocalDate createdDate;
    private User user;
    private BlogStatus blogStatus;
    private Long likeCount;
    /**
     * Soru 5 - Blog’ları oluşturulma tarihine göre, yorum sayısına göre ve okunma sayısına göre artan
     * ve azalan olacak şekilde listeleyen kodu yazın.
     */
    private Long readCount;
    private List<BlogComment> blogCommentList = new ArrayList<>();

    public Blog(String title, String text, User user) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.createdDate = LocalDate.now();
        this.blogStatus = BlogStatus.DRAFT;
        this.likeCount = 0L;
        this.readCount = 0L;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BlogStatus getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(BlogStatus blogStatus) {
        this.blogStatus = blogStatus;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * Soru 5 - Blog’ları oluşturulma tarihine göre, yorum sayısına göre ve okunma sayısına göre artan
     * ve azalan olacak şekilde listeleyen kodu yazın.
     */
    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(Long readCount) {
        this.readCount = readCount;
    }

    public List<BlogComment> getBlogCommentList() {
        return blogCommentList;
    }

    public void setBlogCommentList(List<BlogComment> blogCommentList) {
        this.blogCommentList = blogCommentList;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                ", user=" + user +
                ", blogStatus=" + blogStatus +
                ", likeCount=" + likeCount +
                ", readCount=" + readCount +
                ", blogCommentList=" + blogCommentList +
                '}';
    }
}
