package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utills.Stash;


public class FilterPage extends BasePage{
    private static final String inputPath = "//span[@sign-title='от']//input";
    private static final String showResultPath= "//span[contains(text(),'Показать подходящие')]//ancestor::a";


    @FindBy(xpath = inputPath)
    public WebElement input;

    @FindBy(xpath = showResultPath)
    public WebElement showResult;


    public FilterPage() {
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public FilterPage setProducers (String[] producers){
        WebElement[] checkBoxList = new WebElement[producers.length];
        for (int i=0; i<producers.length; i++) {
            checkBoxList[i] = driver.findElement(By.xpath("//label[@class='checkbox__label' and contains(text(), '" + producers[i] +"')]"));
            checkBoxList[i].click();
        }

        return this;
    }
    public FilterPage setStartPrice (String startPrice){
        input.sendKeys(startPrice);
        Assert.assertEquals("Начальная цена не соответствует введенной", startPrice, input.getAttribute("value"));
        return this;
    }
    public ProductsPage showResults (){
        showResult.click();
        return new ProductsPage();
    }
}
