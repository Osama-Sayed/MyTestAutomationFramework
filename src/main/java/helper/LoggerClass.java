package helper;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerClass {

    public static Logger logs = Logger.getLogger(LoggerClass.class.getName());
    static FileHandler f1 = null;
    public static String logFileName;
    private static FileHandler fh=null,fh2 = null;
    static Logger globalLogger = Logger.getLogger("global");


    public void makeLog() {
        logs.log(Level.INFO, "HIIIIIIIIIIIIIIII");
    }
}
