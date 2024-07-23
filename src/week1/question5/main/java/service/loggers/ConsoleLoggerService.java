package service.loggers;


import interfaces.ILoggerService;
import service.enums.LoggerLevelType;

import java.util.stream.Stream;

public class ConsoleLoggerService implements ILoggerService {

    private static ConsoleLoggerService lazySingleton;

    private ConsoleLoggerService(){
        logString("ConsoleLoggerService sınıfından bir nesne oluşturuldu.", LoggerLevelType.INFO);
    }

    public static ConsoleLoggerService getInstance(){
        if (lazySingleton == null){
            lazySingleton = new ConsoleLoggerService();
        }
        return lazySingleton;
    }



    // ANSI escape code constants for text colors and background colors
    private final String RESET = "\u001B[0m";
    private final String RED_TEXT = "\u001B[31m";
    private final String GREEN_TEXT = "\u001B[32m";
    private final String YELLOW_TEXT = "\u001B[33m";
    private final String BLACK_BG = "\u001B[40m";
    private final String WHITE_BG = "\u001B[47m";

    public void logString(String msg){
        System.out.println(msg);
    }
    public void logString(String msg, LoggerLevelType loggerLevelType){
        switch (loggerLevelType){
            case INFO -> System.out.println(GREEN_TEXT + BLACK_BG + msg + RESET);
            case WARNING -> System.out.println(YELLOW_TEXT + BLACK_BG + msg + RESET);
            case ERROR -> System.out.println(RED_TEXT + BLACK_BG + msg + RESET);
            default -> System.out.println(msg);
        }
    }

    public void logStream(Stream stream){
        stream.forEach(System.out::println);
    }
    public void logStream(Stream stream, LoggerLevelType loggerLevelType){
        stream.forEach(s -> {
            logString(s.toString(), loggerLevelType);
        });
    }

    @Override
    public String toString() {
        return super.toString();
    }
}