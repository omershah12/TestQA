import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
    WebElement username;

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
    WebElement password;

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
    WebElement login;

    @FindBy(css="body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b")
    WebElement result;

    public void setUsername(String uname) {
        username.sendKeys(uname);
    }

    public void setPassword(String pword) {
        password.sendKeys(pword);
    }

    public void clickLogin(){
        login.click();
    }

    public String getResult(){
         return result.getText();
    }

}
