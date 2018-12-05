package pages;
import framework.BrowserFactory;
import framework.PropertiesManager;
import org.openqa.selenium.By;
import java.io.File;

public class DownLoadPage {
    public static void getToDownloadPage() {
        BrowserFactory.getInstance().findElement(By.className("header_installsteam_btn_content")).click();
    }

    public static void startDownload() {
        BrowserFactory.getInstance().findElement(By.id("about_install_steam_link")).click();
    }
    public static boolean checkDownLoad() throws InterruptedException {
        File file = new File(BrowserFactory.pathToDownload+"/SteamSetup.exe");
        while (!file.exists()) {
            Thread.sleep(1000);
        }
        return PropertiesManager.bytes.equals(file.length());
    }
    public static void deleteFile(){
        File file = new File(BrowserFactory.pathToDownload+"/SteamSetup.exe");
        file.delete();
    }
    }
