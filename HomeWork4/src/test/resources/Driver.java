import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public  class Driver {
    public static WebDriver Instance = null;
    public static void Initialize () throws IOException {
        Functions functions = new Functions();
        Properties properties = functions.openProperties();
        String  browser =  properties.getProperty("brow");
        if (Instance == null) {
            if (browser.equalsIgnoreCase("chrome")){
                Instance = new ChromeDriver();}
            else if (browser.equalsIgnoreCase("ie")) {
                Instance = new InternetExplorerDriver();
            } else if (browser.equalsIgnoreCase("ff")) {
                Instance = new FirefoxDriver();
            }
        }
        Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Instance.manage().window().maximize();
    }
    public void close(){
        Instance.close();
        Instance = null;
    }
    public void quit(){
        Instance.quit();
        Instance = null;

    }
}

