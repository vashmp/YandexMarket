package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utills.Stash;


public class SearchResultPage extends BasePage{

    private static final String sectionPath = "//ul[@class='topmenu__list']";
    private static final String subSectionPath = "//div[@class='catalog-menu__item']/following::div[@class='catalog-menu__list']";
    private static final String filterPath = "//a[contains(text(), 'Перейти ко всем фильтрам')]";

    @FindBy(xpath = sectionPath)
    public WebElement mainSection;

    @FindBy(xpath = subSectionPath)
    public WebElement subSection;

    @FindBy(xpath = filterPath)
    public WebElement filter;

    public SearchResultPage() {
        driver = Stash.getDriver();
        PageFactory.initElements(driver, this);
    }

    public SearchResultPage moveToSection(String sectionName) {
        WebElement searchSection = mainSection.findElement(By.xpath(sectionPath + "//a[contains(text(),'" +sectionName+"')]"));
        searchSection.click();
        return this;
    }
    public SearchResultPage moveToSubSection(String subSectionName) {
        WebElement searchSubSection = subSection.findElement(By.xpath(subSectionPath + "/a[contains(text(),'" +subSectionName+"')]"));
        searchSubSection.click();
        return this;
    }
    public FilterPage expandFilters(){
        filter.click();
        return new FilterPage();
    }







}
