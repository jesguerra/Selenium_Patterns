import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

    private WebDriver driver;
    private String Url = "https://www.apple.com";
    private long waitTime = 20;

    @Test
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(Url);
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        PageObject pageObject = new PageObject(driver);
        pageObject.validateCountry();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageObject.getMenuPanel())));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageObject.getMacMenuOption())));
        pageObject.selectMacOption();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageObject.macContainerItems)));
        pageObject.validateMacItems();

        //Implements PageFactory Pattern
        PageFactoryPattern pageFactoryPattern = new PageFactoryPattern(driver);

        pageFactoryPattern.enterMacbookAirOption();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pageFactoryPattern.getMacbookAirTitleXpath())));
        pageFactoryPattern.validateMacbookAirTitle();

        driver.quit();

    }
}
