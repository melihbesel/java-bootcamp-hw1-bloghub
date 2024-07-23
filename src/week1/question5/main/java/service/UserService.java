package service;

import com.google.common.hash.Hashing;
import interfaces.ILoggerService;
import model.User;
import model.enums.StatusType;
import repository.UserRepository;
import service.enums.LoggerLevelType;
import service.loggers.ConsoleLoggerService;
import service.loggers.FileLoggerService;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserService {

    private static final ILoggerService loggerService = ConsoleLoggerService.getInstance();

    private static final UserRepository userRepository = UserRepository.getInstance();

    private static final UserService eagerSingleton = new UserService();

    private UserService(){
        loggerService.logString("UserService sınıfından bir nesne oluşturuldu.", LoggerLevelType.INFO);
    }

    public static UserService getInstance(){
        return eagerSingleton;
    }



    public User saveUser(String email, String password) {

        /**
         * Soru 5 - Password bilgisini SHA-512 ile hashleyin.
         */
        String sha512Password = Hashing.sha512().hashString(password, StandardCharsets.UTF_8).toString();

        User user = new User(email, sha512Password);

        userRepository.save(user);

        return user;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("user bulunamadı"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void changeStatus(String email, StatusType statusType) {
        getUserByEmail(email).setStatusType(statusType);
    }

    public void changeStatus(List<String> emailList, StatusType statusType) {

        Map<String, User> allUsersMap = getAllUsersMap();

        emailList.forEach(email -> {

            User user = allUsersMap.get(email);
            user.setStatusType(statusType);
        });

    }

    public void changeStatus2(List<String> emailList, StatusType statusType) {
        emailList.forEach(email -> changeStatus(email, statusType));
    }

    public Map<String, User> getAllUsersMap() {
        return getAllUsers().stream()
                .collect(Collectors.toMap(User::getEmail, Function.identity()));
    }
}
