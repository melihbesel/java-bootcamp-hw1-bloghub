package repository;

import interfaces.ILoggerService;
import model.User;
import model.enums.StatusType;
import service.enums.LoggerLevelType;
import service.loggers.ConsoleLoggerService;
import service.loggers.FileLoggerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static final ILoggerService loggerService = ConsoleLoggerService.getInstance();

    private List<User> userList = new ArrayList<>();

    private static UserRepository lazySingleton;

    private UserRepository(){
        loggerService.logString("UserRepository sınıfından bir nesne oluşturuldu.", LoggerLevelType.INFO);
    }

    public static UserRepository getInstance(){
        if (lazySingleton == null){
            lazySingleton = new UserRepository();
        }
        return lazySingleton;
    }



    public void save(User user) {
        userList.add(user);
    }

    public Optional<User> findByEmail(String email) {
        return userList.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    public List<User> findAll() {
        return userList.stream()
                .filter(user -> user.getStatusType().equals(StatusType.APPROVED))
                .toList();
    }
}
