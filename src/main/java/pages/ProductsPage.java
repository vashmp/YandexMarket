package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utills.Stash;

import java.util.List;

public class ProductsPage extends BasePage{

    private static final String sizePath= "//span[contains(@class,'select_size_s')]";
    private static final String sizeTwelvePath= "//span[@class ='select__text' and contains(text(),'Показывать по 12')]";
    private static final String productPath = "//div[contains(@class,'n-snippet') and contains(@class, 'title')]";
    private static final String inputPath = "//input[@id='header-search']";
    private static final String searchPath = "//span[@class='search2__button']";




    @FindBy(xpath = sizePath)
    public WebElement size;

    @FindBy(xpath = sizeTwelvePath)
    public WebElement sizeTwelve;

    @FindBy(xpath = productPath)
    public List<WebElement> productList;

    @FindBy(xpath = inputPath)
    public WebElement input;

    @FindBy(xpath = searchPath)
    public WebElement search;

    public ProductsPage() {
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public ProductsPage showTwelveResults (){
        size.click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(sizeTwelve));
        sizeTwelve.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(productPath), 12));
        if (!(productList.size() == 12)){
            Assert.fail("Size is not 12");
        }
        return new ProductsPage();
    }

    public ProductsPage takeProduct(int position){
        WebElement element = productList.get(position-1);
        String fullItemName = element.findElement(By.xpath("./a")).getText();
        Stash.put(Stash.itemName, fullItemName);
        return new ProductsPage();

    }

    public FinalPage searchProduct(){
        input.sendKeys((String) Stash.get(Stash.itemName));
        search.click();
        return new FinalPage();

    }
}
