import framework.BrowserFactory;
import framework.PropertiesManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestMain {


    @Before
    public void setUp() throws IOException {
        BrowserFactory.Initialize();
        BrowserFactory.getInstance().manage().window().maximize();
        BrowserFactory.getInstance().navigate().to(PropertiesManager.getUrl());
        BrowserFactory.getInstance().manage().timeouts().implicitlyWait(PropertiesManager.getTimeDelayImp(), TimeUnit.SECONDS);

    }
    @Test
    public void testNumberOne() throws IOException, InterruptedException {
        TopMenu.openMenu();
        TopMenu.goToElement();
        ActionPage.getTopSellers();
        ActionPage.goToMaxSale();
        DescriptionPage.exc1();
        DescriptionPage.exc2();
        Assert.assertTrue(DescriptionPage.equalsDiscount());
        DownLoadPage.getToDownloadPage();
        DownLoadPage.startDownload();
        Assert.assertTrue(DownLoadPage.checkDownLoad());

    }
    @AfterClass
    public static void tearDown(){
          BrowserFactory.exit();
        DownLoadPage.deleteFile();
    }

}
