package factory;

import interfaces.ILoggerService;

import service.loggers.ConsoleLoggerService;
import service.loggers.FileLoggerService;

public class LoggerServiceFactory {

    public ILoggerService getILoggerService(String loggerServiceName){

        if (loggerServiceName == null){
            return null;
        }

        if (loggerServiceName.equalsIgnoreCase("ConsoleLoggerService")){
            return ConsoleLoggerService.getInstance();
        }
        if (loggerServiceName.equalsIgnoreCase("FileLoggerService")){
            return FileLoggerService.getInstance();
        }
        return null;
    }
}
