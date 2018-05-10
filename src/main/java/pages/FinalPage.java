package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utills.Stash;

public class FinalPage extends BasePage{

    private static final String titlePath = "//h1[contains(@class, 'title')]";

    @FindBy(xpath = titlePath)
    public WebElement title;

    public FinalPage() {
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void checkNameOfProduct(){
        String expectedName = (String) Stash.get(Stash.itemName);
        String factName = title.getText();
        Assert.assertEquals("Название товара не соответствует выбранному в результатах поиска!", expectedName, factName);
    }
}
