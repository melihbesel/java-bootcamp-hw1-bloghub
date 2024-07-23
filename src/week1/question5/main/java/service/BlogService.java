package service;

import interfaces.ILoggerService;
import model.Blog;
import model.BlogComment;
import model.User;
import service.enums.BlogOrderByType;
import model.enums.BlogStatus;
import repository.BlogRepository;
import service.enums.LoggerLevelType;
import service.loggers.ConsoleLoggerService;
import service.loggers.FileLoggerService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BlogService {

    private static final ILoggerService loggerService = ConsoleLoggerService.getInstance();

    private static final UserService userService = UserService.getInstance();

    private static final BlogRepository blogRepository = BlogRepository.getInstance();

    private static final BlogService eagerSingleton = new BlogService();

    private BlogService() {
        loggerService.logString("BlogService sınıfından bir nesne oluşturuldu.", LoggerLevelType.INFO);
    }

    public static BlogService getInstance(){
        return eagerSingleton;
    }



    public Blog createBlog(String title, String text, String email) {

        User foundUser = userService.getUserByEmail(email);

        Blog blog = new Blog(title, text, foundUser);

        blogRepository.save(blog);

        loggerService.logString("'" + blog.getTitle() + "' başlıklı blog '" + foundUser.getEmail() + "' tarafından eklendi", LoggerLevelType.INFO);
        foundUser.getBlogList().add(blog);

        return blog;
    }

    public Blog getBlogByTitle(String title) {

        return blogRepository.findByTitle(title).orElseThrow(() -> new RuntimeException("blog bulunamadı"));
    }

    public void addComment(String title, String comment, User user) {

        Blog foundBlog = getBlogByTitle(title);

        loggerService.logString("'" + foundBlog.getTitle() + "' başlıklı bloga '" + user.getEmail() + "' tarafından yorum eklendi", LoggerLevelType.INFO);
        foundBlog.getBlogCommentList().add(new BlogComment(user, comment));

    }

    public List<Blog> getBlogsFilterByStatus(BlogStatus blogStatus, String email) {

        User foundUser = userService.getUserByEmail(email);

        return foundUser.getBlogList().stream()
                .filter(blog -> blogStatus.equals(blog.getBlogStatus()))
                .toList();
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public List<Blog> getSortedAllBlogs(BlogOrderByType orderByType, Boolean orderDescending) {
        if (orderDescending == null) orderDescending = false;
        List<Blog> sortedList = new ArrayList<>(getAllBlogs());
        if (orderByType.equals(BlogOrderByType.CREATED_DATE)) sortedList.sort(Comparator.comparing(Blog::getCreatedDate));
        if (orderByType.equals(BlogOrderByType.COMMENT_COUNT)) sortedList.sort(Comparator.comparingInt(a -> a.getBlogCommentList().size()));
        if (orderByType.equals(BlogOrderByType.READ_COUNT)) sortedList.sort(Comparator.comparingLong(Blog::getReadCount));
        if (orderDescending) return sortedList.reversed();
        return sortedList;
    }

    public void printSortedAllBlogs() {
        BlogOrderByType[] blogOrderByTypes = BlogOrderByType.values();
        Boolean[] orderTypes = {true, false};
        for (Boolean orderDescending : orderTypes) {
            for (BlogOrderByType blogOrderByType : blogOrderByTypes) {
                loggerService.logString("blogOrderByType: " + blogOrderByType + ", orderDescending: " + orderDescending, LoggerLevelType.INFO);
                loggerService.logStream(getSortedAllBlogs(blogOrderByType, orderDescending).stream());
            }
        }
    }

    public void printUserBasedBlogStatictics() {
        for (User user : userService.getAllUsers()) {
            List<Blog> userBlogs = user.getBlogList();
            loggerService.logString("'" + user.getEmail() + "' kullanıcısının blogları", LoggerLevelType.INFO);
            loggerService.logStream(userBlogs.stream());
            int totalBlogCount = userBlogs.size();
            long totalBlogReadCount = 0L;
            int totalBlogCommentCount = 0;
            for (Blog blog : userBlogs) {
                totalBlogReadCount += blog.getReadCount();
                totalBlogCommentCount += blog.getBlogCommentList().size();
            }
            loggerService.logString("'" + user.getEmail() + "' kullanıcısının blog istatistikleri", LoggerLevelType.INFO);
            loggerService.logString("BLOG_COUNT: " + totalBlogCount);
            loggerService.logString("READ_COUNT: " + totalBlogReadCount);
            loggerService.logString("COMMENT_COUNT: " + totalBlogCommentCount);
        }
    }

    public void changeBlogStatus(BlogStatus blogStatus, String title) {

        Blog foundBlog = getBlogByTitle(title);

        if (foundBlog.getBlogStatus().equals(BlogStatus.PUBLISHED)) {
            throw new RuntimeException("statüsü PUBLISHED olan bir blog silinemez.");
        }

        loggerService.logString("'" + foundBlog.getTitle() + "' başlıklı blog durumu '" + blogStatus + "' olarak değişti", LoggerLevelType.INFO);
        foundBlog.setBlogStatus(blogStatus);

    }

    public void changeCreatedDate(String date, String title) {
        Blog foundBlog = getBlogByTitle(title);
        try {
            foundBlog.setCreatedDate(LocalDate.parse(date));
        } catch (Exception e) {
            loggerService.logString(e.getMessage(), LoggerLevelType.ERROR);
        }
    }

    public void readBlog(String title, User user) {
        Blog foundBlog = getBlogByTitle(title);
        loggerService.logString("'" + foundBlog.getTitle() + "' başlıklı blog '" + user.getEmail() + "' tarafından okundu", LoggerLevelType.INFO);
        foundBlog.setReadCount(foundBlog.getReadCount() + 1);
    }
}
