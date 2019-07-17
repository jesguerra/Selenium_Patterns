import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PageObject {

    WebDriver driver;

    By panel = By.xpath(menuPanel);
    By country = By.xpath(countryField);
    By macOption = By.xpath(macMenuOption);
    By macItems = By.xpath(menuMacItems);
    By macContainer = By.xpath(macContainerItems);


    public String getMenuPanel() {
        return menuPanel;
    }
    public String getMacMenuOption() {
        return macMenuOption;
    }

    public static String menuPanel = "//nav[@id='ac-globalnav']";
    public static String countryField = "(//span[contains(text(),'Colombia')])[1]";
    public static String expectCountry = "Colombia";
    public static String macMenuOption = "//a[@class='ac-gn-link ac-gn-link-mac']";
    public static String macContainerItems = "//ul[@class='chapternav-items']";
    public static String menuMacItems = "//span[@class='chapternav-label' and not(contains(text(),'Accessories')) and not(contains(text(),'Compare'))]";

    public List<String> data() {
        List<String> itemsMacMenu = new ArrayList<String>();
        itemsMacMenu.add("MacBook Air");
        itemsMacMenu.add("MacBook Pro");
        itemsMacMenu.add("iMac");
        itemsMacMenu.add("iMac Pro");
        itemsMacMenu.add("Mac Pro");
        itemsMacMenu.add("Mac mini");
        itemsMacMenu.add("Pro Display XDR");
        itemsMacMenu.add("Mojave");

        return itemsMacMenu;
    }


    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void validateCountry() {
        String pageCountry =  driver.findElement(country).getText();
        assertThat(pageCountry, equalTo(expectCountry));
    }

    public void selectMacOption() {
        driver.findElement(macOption).click();
    }

    public void validateMacItems() {

        List<WebElement> elements = driver.findElements(macItems);
        String lista = null;
        List<String> nuevaLista = new ArrayList<String>();
        for (int i = 0; i < elements.size(); i++) {

            lista = elements.get(i).getText();
            nuevaLista.add(lista);
        }
        assertThat("Validate web elements list", nuevaLista, equalTo(data()));
    }
}
