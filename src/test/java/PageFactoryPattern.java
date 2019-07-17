import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PageFactoryPattern {

    WebDriver driver;

    private String expectMacbookAirText = "MacBook Air";

    public String getMacbookAirTitleXpath() {
        return macbookAirTitleXpath;
    }

    private String macbookAirTitleXpath = "//div[@class='ac-ln-title']";

    @FindBy(xpath = "//li[@class='chapternav-item chapternav-item-macbook-air']")
    WebElement macbokAirOption;

    @FindBy(xpath = "//div[@class='ac-ln-title']")
    WebElement macbookAirTitle;

    public PageFactoryPattern(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    //Methods//
    public void enterMacbookAirOption(){

        macbokAirOption.click();
    }
    public void validateMacbookAirTitle(){

        String macbookTitle = macbookAirTitle.getText();
        assertThat(expectMacbookAirText,equalTo(macbookTitle));
    }
}
