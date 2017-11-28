import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.http.util.Asserts;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.io.File;

public class Draggable {
    private String url="http://demoqa.com/draggable/";
    private WebDriver webDriver;
    private static ExtentReports report;

    @BeforeClass
    public static void init() {
        report = new ExtentReports();
        String fileName = "Report" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
    }

    @Test
    public void Test1() throws InterruptedException {
        ExtentTest test = report.createTest("First");
        test.log(Status.INFO, "First Test is Starting ");

        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        a.clickAndHold(drag.el).moveToElement(drag.el2,300,200).release(drag.el).perform();
        test.log(Status.INFO, "Moved");
        int offset = drag.el.getLocation().getX();

        Assert.assertEquals(441, offset);
        test.log(Status.INFO, "Complete");
    }

    @Test
    public void Test2() throws InterruptedException{

        ExtentTest test = report.createTest("Second");
        test.log(Status.INFO, "Second Test is Starting ");
        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        drag.clickBtn1();
        a.clickAndHold(drag.dragS1).moveByOffset(0, 20).release(drag.dragS1).perform();
        test.log(Status.INFO, "Moved");
        int offset=drag.dragS1.getLocation().getY();

        Thread.sleep(5000);

        Assert.assertEquals(424, offset);
        test.log(Status.INFO, "Complete");
    }

    @Test
    public void Test3() throws InterruptedException{
        ExtentTest test = report.createTest("Third");
        test.log(Status.INFO, "Third Test is Starting ");
        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        drag.clickBtn1();
        a.clickAndHold(drag.dragS2).moveByOffset(80, 0).release(drag.dragS2).perform();
        test.log(Status.INFO, "Moved");
        int offset=drag.dragS2.getLocation().getX();

        Assert.assertEquals(453, offset);
        test.log(Status.INFO, "Compelte");
    }

    @Test
    public void Test4() throws InterruptedException{
        ExtentTest test = report.createTest("Fourth");
        test.log(Status.INFO, "Fourth Test is Starting ");
        webDriver.navigate().to(url);

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        Actions a = new Actions(webDriver);
        DraggablePOM drag = PageFactory.initElements(webDriver, DraggablePOM.class);
        drag.clickBtn1();
        a.clickAndHold(drag.dragS3).moveToElement(drag.dragDom,300,200).release(drag.dragS3).perform();
        int offset=drag.dragS3.getLocation().getX();

        Thread.sleep(5000);
        Assert.assertEquals(528, offset);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

}
