package pages;

import framework.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActionPage {
    public static int maxDiscount;
    public static WebElement topSellLocator = BrowserFactory.getInstance().findElement(By.id("tab_select_TopSellers"));
    public static List<WebElement> saleLocators = BrowserFactory.getInstance().findElements(By.xpath("//div[@id='TopSellersRows']//div[@class='discount_pct']"));
    public static void getTopSellers() {
        topSellLocator.click();
    }
    public static List<Integer> getMaxSale  (){
        List<Integer> values = new ArrayList<>();
        Pattern pat = Pattern.compile("[0-9]+");
        for (WebElement e : saleLocators) {
            Matcher matcher = pat.matcher(e.getText());
            while (matcher.find()) {
                values.add(Integer.parseInt(matcher.group()));
            }
        }
        return values;
    }
    public static void goToMaxSale(){
        maxDiscount = Collections.max(getMaxSale());
        saleLocators.get(getMaxSale().indexOf(maxDiscount)).click();
    }
    public static String getMaxDiscount() {
        return String.valueOf(maxDiscount);}
}

