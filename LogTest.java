import org.apache.log4j.*;
import java.lang.Thread;

import java.io.IOException;

public class LogTest {
    
  private static final Logger log = Logger.getLogger(LogTest.class);
  public static void main(String args[]) {
    //BasicConfigurator.configure();
    Logger rootLogger = Logger.getRootLogger();
    rootLogger.setLevel(Level.INFO);
    PatternLayout layout = new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN);
    rootLogger.addAppender(new ConsoleAppender(layout));
     try {
        RollingFileAppender rfa = new RollingFileAppender(layout, "logtest.log");
        rfa.setMaximumFileSize(1000000);
        rootLogger.addAppender(rfa);

     } catch (IOException t) {
           //  e.printStackTrace();
    }    

           for(int i=0; i<=1000; i++){
                 log.info("Testing...");
                       try {
                           Thread.sleep(5 * 1000);
                           }
                      catch (InterruptedException e) {
                           e.printStackTrace();
                           }
             }
    }

}
