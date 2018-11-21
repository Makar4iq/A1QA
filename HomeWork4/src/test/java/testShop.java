import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.junit.Before;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import Object.MainPage;
import Framework.Functions;

public class testShop {
    private static String log, loginname, mainpage, pass;
    public static WebDriver driver;
    public static MainPage mainPage;
    int rnd;


    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String log = "293909938";
        String pass = "LmMZN2yx";
        String mainpage = "https://shop.by/";
        String loginname = "Makar4ig";
    }

    @Test
    public void TestShop(){
        driver.get(mainpage);
        Assert.assertEquals("https://shop.by/", driver.getCurrentUrl());
        mainPage.clickLoginMenuButton();
        mainPage.sentLoginPassword();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        mainPage.clickLogedMenuLocator();
        Assert.assertTrue(mainPage.LoginNameLocator.getText().contains("Makar4ig"));
        driver.get("https://shop.by/");
        mainPage.clickButtonAllCatalog();
        Random random = new Random();
        rnd = random.nextInt(MainPage.AllCatalog.size());
        MainPage.AllCatalog.get(rnd).click();
        Assert.assertTrue(MainPage.NameCatalogSource.getText().contains(mainPage.NameCatalog.getText()));
        //Assert.assertTrue(MainPage.NameCatalog.getText().contains("name"));
        driver.get("https://shop.by/");
        Functions functions = new Functions();
        String elem =  driver.getPageSource();
        Set<String> classes=functions.findClassesReviews(elem);
        List<String> data = new ArrayList<>();
        for(String cl:classes) {
            List<WebElement> l = driver.findElements(By.className("ModelReviewsHome__NameModel"));
            for(WebElement el:l){
                data.add(el.getText());
            }
        }
        System.out.println(data);
        

    }

}
