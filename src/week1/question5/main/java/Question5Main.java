import factory.LoggerServiceFactory;
import interfaces.ILoggerService;
import model.Blog;
import model.User;
import model.enums.BlogStatus;
import model.enums.StatusType;
import service.BlogService;
import service.UserService;
import service.enums.LoggerLevelType;

import java.util.*;

public class Question5Main {

    public static void main(String[] args) {
        /**
         * Soru 3 - Singleton ve Factory pattern kullanarak projedeki objeleri oluşturun.
         */
        LoggerServiceFactory loggerServiceFactory = new LoggerServiceFactory();
        ILoggerService loggerService = loggerServiceFactory.getILoggerService("ConsoleLoggerService");
        UserService userService = UserService.getInstance();
        BlogService blogService = BlogService.getInstance();

        /**
         * Sisteme kullanıcılar kaydediyoruz
         */
        userService.saveUser("cem@gmail.com", "password");
        userService.saveUser("mehmet@gmail.com", "123456");
        userService.saveUser("toygun@gmail.com", "123456");
        userService.saveUser("melih@gmail.com", "mM123456!+");

        /**
         * Kullanıcıların durumlarını APPROVED olarak değiştiriyoruz
         */
        userService.changeStatus("cem@gmail.com", StatusType.APPROVED);
        userService.changeStatus("mehmet@gmail.com", StatusType.APPROVED);
        userService.changeStatus("toygun@gmail.com", StatusType.APPROVED);
        userService.changeStatus("melih@gmail.com", StatusType.APPROVED);

        /**
         * Durumu APPROVED olan tüm kullanıcıları listele ve göster
         */
        loggerService.logString("Durumu APPROVED olan tüm kullanıcıları listele ve göster");
        loggerService.logStream(userService.getAllUsers().stream(), LoggerLevelType.INFO);

        /**
         * Cem kullanıcısı ile sistemde işlemler yapmak için servis üzerinden email ile User nesnesini alıyoruz
         */
        User cemUser = userService.getUserByEmail("cem@gmail.com");

        blogService.createBlog("Hayat Kurtaran Java Stream Komutları", "Java 8 ile gelen en önemli ...", cemUser.getEmail());
        blogService.changeBlogStatus(BlogStatus.PUBLISHED, "Hayat Kurtaran Java Stream Komutları");
        blogService.changeCreatedDate("2023-08-01", "Hayat Kurtaran Java Stream Komutları");

        blogService.createBlog("Lombok", "Lombok Nedir? ...", cemUser.getEmail());
        blogService.changeBlogStatus(BlogStatus.PUBLISHED, "Lombok");
        blogService.changeCreatedDate("2024-06-31", "Lombok"); // tarih değişmeyecek, çünkü tarihten dolayı exception olacak ve exception mesajı ekrana loglanacak

        /**
         * Mehmet kullanıcısı ile sistemde işlemler yapmak için servis üzerinden email ile User nesnesini alıyoruz
         */
        User mehmetUser = userService.getUserByEmail("mehmet@gmail.com");

        /**
         * Toygun kullanıcısı ile sistemde işlemler yapmak için servis üzerinden email ile User nesnesini alıyoruz
         */
        User toygunUser = userService.getUserByEmail("toygun@gmail.com");

        blogService.createBlog("header", "content", toygunUser.getEmail());

        /**
         * Melih kullanıcısı ile sistemde işlemler yapmak için servis üzerinden email ile User nesnesini alıyoruz
         */
        User melihUser = userService.getUserByEmail("melih@gmail.com");

        blogService.createBlog("Java Frameworkleri nelerdir?", "Java Frameworkleri", melihUser.getEmail());
        blogService.changeCreatedDate("2024-07-07", "Java Frameworkleri nelerdir?");

        /**
         * Genel işlemler
         */
        blogService.changeBlogStatus(BlogStatus.DELETED, "header");
        blogService.readBlog("Hayat Kurtaran Java Stream Komutları", melihUser);
        blogService.addComment("Hayat Kurtaran Java Stream Komutları", "İyi bir makale olmuş", toygunUser);
        blogService.addComment("Hayat Kurtaran Java Stream Komutları", "Harika, teşekkürler", melihUser);
        blogService.readBlog("Hayat Kurtaran Java Stream Komutları", mehmetUser);
        blogService.readBlog("Hayat Kurtaran Java Stream Komutları", toygunUser);
        blogService.readBlog("Lombok", melihUser);
        blogService.readBlog("Lombok", mehmetUser);
        blogService.readBlog("Lombok", toygunUser);
        blogService.readBlog("Lombok", cemUser);
        blogService.addComment("Lombok", "isim tuhafmış", cemUser);
        blogService.readBlog("Java Frameworkleri nelerdir?", mehmetUser);
        blogService.readBlog("Java Frameworkleri nelerdir?", cemUser);
        blogService.addComment("Java Frameworkleri nelerdir?", "comment1", cemUser);
        blogService.addComment("Java Frameworkleri nelerdir?", "comment2", cemUser);
        blogService.addComment("Java Frameworkleri nelerdir?", "comment3", cemUser);

        /**
         * Tüm kullanıcıların bloglarını listele ve göster
         */
        List<Blog> allUsersBlogList = userService.getAllUsers()
                .stream()
                .flatMap(user -> user.getBlogList().stream())
                .toList();
        loggerService.logString("Tüm kullanıcıların bloglarını listele ve göster");
        loggerService.logStream(allUsersBlogList.stream(), LoggerLevelType.INFO);

        /**
         * Soru 5 - Blog istatistiklerini hesaplayan ve gösteren bir kodu yazın.
         */
        loggerService.logString("Soru 5 - Blog istatistiklerini hesaplayan ve gösteren bir kodu yazın.");
        blogService.printUserBasedBlogStatictics();

        /**
         * Soru 5 - Blog’ları oluşturulma tarihine göre, yorum sayısına göre ve okunma sayısına göre artan
         * ve azalan olacak şekilde listeleyen kodu yazın.
         */
        loggerService.logString("Soru 5 - Blog’ları oluşturulma tarihine göre, yorum sayısına göre ve okunma sayısına göre artan ve azalan olacak şekilde listeleyen kodu yazın.");
        blogService.printSortedAllBlogs();

    }
}
