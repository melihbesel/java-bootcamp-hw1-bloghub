package interfaces;

import service.enums.LoggerLevelType;

import java.util.stream.Stream;

public interface ILoggerService {

    void logString(String msg);
    void logString(String msg, LoggerLevelType loggerLevelType);

    void logStream(Stream stream);
    void logStream(Stream stream, LoggerLevelType loggerLevelType);

}
