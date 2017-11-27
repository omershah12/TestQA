import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample {

    private String url="https://github.com/login";
    private WebDriver webDriver;

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }

    @Test
    public void qaTest(){
        webDriver.navigate().to(url);
        WebElement username = webDriver.findElement(By.cssSelector("#login_field"));
        WebElement password = webDriver.findElement(By.cssSelector("#password"));
        username.sendKeys("omershah12@hotmail.co.uk");
        password.sendKeys("");
        WebElement enter = webDriver.findElement(By.cssSelector("#login > form > div.auth-form-body.mt-3 > input.btn.btn-primary.btn-block"));
        enter.click();
        WebElement name = webDriver.findElement(By.cssSelector("#user-links > li:nth-child(3) > details > summary > span"));
        name.click();
        WebElement profile = webDriver.findElement(By.cssSelector("#user-links > li:nth-child(3) > details > ul > li:nth-child(3) > a"));
        profile.click();
        String currentUrl = webDriver.getCurrentUrl();
        String expectedUrl = "https://github.com/omershah12";
        Assert.assertEquals("Not correct", expectedUrl, currentUrl);
    }

}
