package Object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class MainPage {


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"Header__Authentication\"]/div[2]/span")
    private WebElement LoginMenuLocator;
    @FindBy(id = "LLoginForm_phone")
    private WebElement LoginLocator;
    @FindBy(id = "LLoginForm_password")
    private WebElement PasswordLocator;
    @FindBy(name = "yt2")
    private WebElement LoginButtonLocator;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/a")
    private WebElement allCategoriesLocatorMenu;
    @FindBy(id = "yt0")
    private WebElement ForTheExitLocator;
    @FindBy(className = "Page__BlockElementsPageCatalog")
    private WebElement allCategoriesLocator;
    @FindBy(xpath = "//*[@id=\"Header__Authentication\"]/div[2]/a/div/div/span/div")
    private WebElement LogedMenuLocator;
    @FindBy(xpath = "//*[@id=\"ui-id-1\"]/div/div/div[2]")
    public WebElement LoginNameLocator;
    @FindBy(linkText = "Весь каталог")
    public WebElement ButtonAllCatalog;
    @FindBy(className = "Page__TitleActivePage")
    public static WebElement NameCatalog;
    @FindBy(className = "BreadCrumbs__LastElement")
    public static WebElement NameCatalogSource;
    @FindBy(className = "ModelReviewsHome__ContentReview")
    public static List<WebElement> Rewiews;
    @FindBys({
            @FindBy(className = "Page__BlockElementsPageCatalog"),
            @FindBy(tagName = "a")
    })
    public static List<WebElement> AllCatalog;

    public void clickLoginMenuButton() {
        LoginMenuLocator.click();
    }

    public void sentLoginPassword () {
        LoginLocator.clear();
        LoginLocator.sendKeys("293909938");
        PasswordLocator.clear();
        PasswordLocator.sendKeys("LmMZN2yx");
        LoginButtonLocator.click();
    }

    public void clickLogedMenuLocator() {
        LogedMenuLocator.click();
    }

    public void loginNameLocator() {
        LoginNameLocator.findElements(By.name("Makarig"));
    }
    public void clickButtonAllCatalog() {
        ButtonAllCatalog.click();
        driver.getPageSource();
    }
}






