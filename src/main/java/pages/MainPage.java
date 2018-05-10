package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utills.Stash;


public class MainPage extends BasePage{
    @FindBy(xpath = "//a[@data-id='market']")
    public WebElement searchMarket;




    public MainPage(){
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage moveToMarket(){
        searchMarket.click();
        return new SearchResultPage();
    }
}
