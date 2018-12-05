package framework;
import pages.MainPage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
public class PropertiesManager {
    private static String url,browser,month,day,year;
    private static int timeDelayImp, timeDelayExp;
    public static Long bytes;
    private static String gameMenuRUS, gameMenuEN;
    private static String path = "src/test/resources/config.properties";
    public static int getTimeDelayImp() {
        return timeDelayImp;
    }
    public static String getGame() {
        if (MainPage.getLanguage().equals("english")) {
            return gameMenuEN;
        } else {
            return gameMenuRUS;
        }
    }
    public static String getUrl() {
        return url;
    }
    public static String getDay() { return day; }
    public static String getMonth() { return month; }
    public static String getYear() { return year; }
    public static String getBrowser() {
        return browser;
    }
    static {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream(new File(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = props.getProperty("url");
        browser = props.getProperty("browser");
        timeDelayImp = Integer.valueOf(props.getProperty("timeDelayImp"));
        timeDelayExp = Integer.valueOf(props.getProperty("timeDelayExp"));
        day = props.getProperty("day");
        month = props.getProperty("month");
        year = props.getProperty("year");
        bytes = Long.valueOf(props.getProperty("bytes"));
        gameMenuRUS =(new String(props.getProperty("gameMenuRUS").getBytes(StandardCharsets.ISO_8859_1)));
        gameMenuEN = props.getProperty("gameMenuEN");

    }


}