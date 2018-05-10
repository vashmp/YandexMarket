import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import pages.MainPage;
import utills.Stash;

public class YandexTests {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Stash.put("driver", driver);
        driver.get("https://www.yandex.ru");
    }


    @After
    public void shutDown(){
        Stash.getDriver().quit();
    }


    @Test
    public void search_tv_on_yandex_market() {
        new MainPage()
            .moveToMarket()
            .moveToSection("Электроника")
            .moveToSubSection("Телевизор")
            .expandFilters()
            .setStartPrice("20000")
            .setProducers(new String[]{"LG", "Samsung"})
            .showResults()
            .showTwelveResults()
            .takeProduct(1)
            .searchProduct()
            .checkNameOfProduct();

    }
    @Test
    public void search_hphones_on_yandex_market() {
        new MainPage()
                .moveToMarket()
                .moveToSection("Электроника")
                .moveToSubSection("Наушники")
                .expandFilters()
                .setStartPrice("5000")
                .setProducers(new String[]{"Sennheiser", "Sony"})
                .showResults()
                .showTwelveResults()
                .takeProduct(2)
                .searchProduct()
                .checkNameOfProduct();

    }

}