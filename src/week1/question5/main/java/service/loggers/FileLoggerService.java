package service.loggers;


import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.FileWriteMode;
import com.google.common.io.Files;
import interfaces.ILoggerService;
import service.enums.LoggerLevelType;
import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class FileLoggerService implements ILoggerService {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss Z");

    private CharSink chs;

    private static FileLoggerService lazySingleton;

    private FileLoggerService(){
        try {
            String filePath = "output/logs/";
            String fileName = "blogHub.log";
            File file = new File(filePath + fileName);
            chs = Files.asCharSink(
                    file, Charsets.UTF_8, FileWriteMode.APPEND);
            chs.write("\r\n\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logString("FileLoggerService sınıfından bir nesne oluşturuldu.", LoggerLevelType.INFO);
    }

    public static FileLoggerService getInstance(){
        if (lazySingleton == null){
            lazySingleton = new FileLoggerService();
        }
        return lazySingleton;
    }



    public void logString(String msg){
        try {
            chs.write(ZonedDateTime.now().format(formatter) + ": ");
            chs.write("*** " + msg + " ***");
            chs.write("\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void logString(String msg, LoggerLevelType loggerLevelType){
        try {
            chs.write(ZonedDateTime.now().format(formatter) + ": ");
            chs.write("<" + loggerLevelType + ">");
            chs.write("\r\n");

            chs.write(ZonedDateTime.now().format(formatter) + ": ");
            chs.write("*** " + msg + " ***");
            chs.write("\r\n");

            chs.write(ZonedDateTime.now().format(formatter) + ": ");
            chs.write("<" + loggerLevelType + "/>");
            chs.write("\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void logStream(Stream stream){
        try {
            chs.write(ZonedDateTime.now().format(formatter) + ": ");
            chs.write("*** " + "Stream listeleniyor" + " ***");
            chs.write("\r\n");

            stream.forEach(s -> {
                logString(s.toString());
            });

            chs.write(ZonedDateTime.now().format(formatter) + ": ");
            chs.write("*** " + "Stream listelendi" + " ***");
            chs.write("\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void logStream(Stream stream, LoggerLevelType loggerLevelType){
        try {
            chs.write(ZonedDateTime.now().format(formatter) + ": ");
            chs.write("<" + loggerLevelType + ">");
            chs.write("\r\n");

            chs.write(ZonedDateTime.now().format(formatter) + ": ");
            chs.write("*** " + "Stream listeleniyor" + " ***");
            chs.write("\r\n");

            stream.forEach(s -> {
                logString(s.toString(), loggerLevelType);
            });

            chs.write(ZonedDateTime.now().format(formatter) + ": ");
            chs.write("*** " + "Stream listelendi" + " ***");
            chs.write("\r\n");

            chs.write(ZonedDateTime.now().format(formatter) + ": ");
            chs.write("<" + loggerLevelType + "/>");
            chs.write("\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}