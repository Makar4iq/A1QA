package pages;
import framework.BrowserFactory;
import framework.PropertiesManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.Select;
public class DescriptionPage {
    public static void exc1(){
        try {
        Select daySelect = new Select(BrowserFactory.getInstance().findElement(By.id("ageDay")));
        daySelect.selectByValue(PropertiesManager.getDay());
        Select monthSelect = new Select(BrowserFactory.getInstance().findElement(By.id("ageMonth")));
        monthSelect.selectByValue(PropertiesManager.getMonth());
        Select yearSelect = new Select (BrowserFactory.getInstance().findElement(By.id("ageYear")));
        yearSelect.selectByValue(PropertiesManager.getYear());
        BrowserFactory.getInstance().findElement(By.xpath("//a[@onclick='ViewProductPage()']")).click();
        } catch (TimeoutException e) {
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    public static void exc2(){
        try {
            BrowserFactory.getInstance().findElement(By.xpath("//a[@onclick='ViewProductPage()']")).click();
        } catch (TimeoutException e) {

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    public static Boolean equalsDiscount(){
        return  BrowserFactory.getInstance().findElement(By.className("discount_pct")).getText().contains(ActionPage.getMaxDiscount());
}
}
