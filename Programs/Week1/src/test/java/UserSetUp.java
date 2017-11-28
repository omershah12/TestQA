import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserSetUp {
    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
    WebElement username;

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
    WebElement password;

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
    WebElement add;

    @FindBy(css="body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")
    WebElement login;

    public void setUsername(String uname) {
       username.sendKeys(uname);
    }

    public void setPassword(String pword) {
        password.sendKeys(pword);
    }

    public void clickAdd(){
        add.click();
    }

    public void clickLogin(){
        login.click();
    }
}
