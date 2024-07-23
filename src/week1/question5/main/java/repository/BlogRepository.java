package repository;

import interfaces.ILoggerService;
import model.Blog;
import model.enums.BlogStatus;
import service.enums.LoggerLevelType;
import service.loggers.ConsoleLoggerService;
import service.loggers.FileLoggerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BlogRepository {

    private static final ILoggerService loggerService = ConsoleLoggerService.getInstance();

    private List<Blog> blogList = new ArrayList<>();

    private static BlogRepository lazySingleton;

    private BlogRepository(){
        loggerService.logString("BlogRepository sınıfından bir nesne oluşturuldu.", LoggerLevelType.INFO);
    }

    public static BlogRepository getInstance(){
        if (lazySingleton == null){
            lazySingleton = new BlogRepository();
        }
        return lazySingleton;
    }



    public void save(Blog blog) {
        blogList.add(blog);
    }

    public Optional<Blog> findByTitle(String title) {
        return blogList.stream()
                .filter(blog -> blog.getTitle().equals(title))
                .filter(blog -> !blog.getBlogStatus().equals(BlogStatus.DELETED))
                .findFirst();
    }

    public List<Blog> findAll() {
        return blogList.stream()
                .filter(blog -> !blog.getBlogStatus().equals(BlogStatus.DELETED))
                .toList();
    }
}
