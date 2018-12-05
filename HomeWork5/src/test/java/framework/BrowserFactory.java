package framework;
import framework.PropertiesManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    private static WebDriver Instance = null;
    public static WebDriver getInstance() {
        return Instance;
    }
    private static String pathToFirefoxDriver = "src/test/resources/geckodriver.exe";
    private static String pathToChromeDriver = "src/test/resources/chromedriver.exe";
    public static String pathToDownload ="D:\\A1QA\\HomeWork5\\src\\test\\resources";
    public static void Initialize() throws IOException {
        if(Instance == null){
            if(PropertiesManager.getBrowser().equals("firefox")){
                System.setProperty("webdriver.gecko.driver", pathToFirefoxDriver);
                FirefoxOptions fp =  new FirefoxOptions();
                fp.addPreference("browser.download.folderList",2);
                fp.addPreference("browser.download.manager.showWhenStarting",false);
                fp.addPreference("browser.download.dir", pathToDownload);
                fp.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");
                Instance = new FirefoxDriver(fp);
            }
            else if(PropertiesManager.getBrowser().equals("chrome")){
                System.setProperty("webdriver.chrome.driver",pathToChromeDriver);
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("download.default_directory", pathToDownload);
                chromePrefs.put("download.prompt_for_download", false);
                chromePrefs.put("safebrowsing.enabled", false);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                Instance = new ChromeDriver(options);
            }
        }
        Instance.manage().timeouts().implicitlyWait(PropertiesManager.getTimeDelayImp(), TimeUnit.SECONDS);
        Instance.manage().timeouts().setScriptTimeout(PropertiesManager.getTimeDelayImp(), TimeUnit.SECONDS);
    }
    public static void exit(){
        Instance.quit();
        Instance = null;
    }


}