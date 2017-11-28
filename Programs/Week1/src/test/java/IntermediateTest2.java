import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IntermediateTest2 {
    private String url="http://thedemosite.co.uk/";
    private WebDriver webDriver;
    private static ExtentReports report;
    private SpreadSheetReader spreadSheetReader;


    @BeforeClass
    public static void init() {
        report = new ExtentReports();
        String fileName = "MyReport" + ".html";
        String filePath = System.getProperty("user.dir")
                + File.separatorChar + fileName;
        report.attachReporter(new ExtentHtmlReporter(filePath));
    }

    @Before
    public void setUp(){
        spreadSheetReader = new SpreadSheetReader("test.xlsx");
        webDriver = new ChromeDriver();
    }

    @Test
    public void test() throws IOException {

        List<String> row = new ArrayList<String>();
        row = spreadSheetReader.readRow(0, "Sheet1");
        String username = row.get(0);
        String password = row.get(1);
        String expected = row.get(2);

        webDriver.navigate().to(url);

        ExtentTest test = report.createTest("MyFirstTest");
        test.log(Status.INFO, "My First Test is Starting ");

        PageObject start = PageFactory.initElements(webDriver, PageObject.class);
        start.clickAddUser();
        test.log(Status.INFO, "Paged loaded");

        UserSetUp setup = PageFactory.initElements(webDriver, UserSetUp.class);
        setup.setUsername(username);
        setup.setPassword(password);
        setup.clickAdd();
        setup.clickLogin();
        test.log(Status.INFO, "User details added");

        LoginPage log = PageFactory.initElements(webDriver, LoginPage.class);
        log.setUsername(username);
        log.setPassword(password);
        log.clickLogin();
        test.log(Status.INFO, "Logegd in");

        try{
            Assert.assertEquals(expected, log.getResult());
        }catch (AssertionError error) {
            ScreenShot shot = new ScreenShot();
            String shot1 = shot.take(webDriver, "shot");
            test.addScreenCaptureFromPath(shot1);
        }
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @AfterClass
    public static void cleanUp() {
        report.flush();
    }


}


