import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggablePOM {

    @FindBy(id = "draggable")
    WebElement el;

    @FindBy(css="#tabs-1 > div")
    WebElement el2;

    @FindBy(css="#ui-id-2")
    WebElement btn1;

    @FindBy(css="#draggabl > p")
    WebElement dragS1;

    @FindBy(css="#draggabl2 > p")
    WebElement dragS2;

    @FindBy(css="#draggabl3 > p")
    WebElement dragS3;

    @FindBy(css="#containment-wrapper")
    WebElement dragDom;

    public void clickBtn1(){
        btn1.click();
    }


}
