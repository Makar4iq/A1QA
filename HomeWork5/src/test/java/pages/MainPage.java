package pages;
import framework.BrowserFactory;
import org.openqa.selenium.By;
public class MainPage{

    public static String getLanguage() {
        if (BrowserFactory.getInstance().findElement(By.id("language_pulldown")).getText().contains("language")) {
            return "english";
        }
        else return "russian";
    }

    }






