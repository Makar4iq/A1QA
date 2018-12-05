package pages;
import framework.BrowserFactory;
import framework.PropertiesManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;
public class TopMenu {
    public static String menuAction = "//*[@class='popup_menu_item' and contains(text(),'%s')]";
    public static WebElement getMenuLocator = BrowserFactory.getInstance().findElement(By.id("genre_tab"));
    public static WebElement getmenuElement(String action) {
        return BrowserFactory.getInstance().findElement(By.xpath(String.format(menuAction, action)));
    }
    public static void  openMenu(){
        Actions actions = new Actions(BrowserFactory.getInstance());
        BrowserFactory.getInstance().manage().timeouts().implicitlyWait(PropertiesManager.getTimeDelayImp(), TimeUnit.SECONDS);
        actions.moveToElement(getMenuLocator).build().perform();
    }
    public static void goToElement(){
        getmenuElement(PropertiesManager.getGame()).click();
    }
    }
