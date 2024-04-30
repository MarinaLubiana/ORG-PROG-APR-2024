package org.prog.web;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;

import java.util.List;

public class ParamTest {

private WebDriver driver;
@BeforeSuite
public void setUp() {
    this.driver = new ChromeDriver();
    driver.manage().window().maximize();
}
    @AfterSuite
    public void tearDown() {
        Assert.assertNotNull(driver, "Driver has not been initialized!");
        driver.quit();
    }
        @Test(dataProvider ="sear" )
        public void paramTest(String s){

        }
    @BeforeMethod
    public void preTest() {
        Assert.assertNotNull(driver, "Driver has not been initialized!");
        driver.get("https://allo.ua/");
    }
        @DataProvider(name = "sear")
        public Object[][]dataProvider(){
            return new Object[][]{
                    new Object[]{"iPhone"},
                    new Object[]{"Xiaomi"},
                    new Object[]{"sennheiser"}
            };
}
@Test(dataProvider = "sear")
public void testSear(String sear) {

    WebElement searchBtn = driver.findElement(By.id("search-form__input"));
    searchBtn.sendKeys(sear);
    searchBtn.sendKeys(Keys.ENTER);
    List<WebElement> resul = driver.findElements(By.className("product-card__title"));
    Assert.assertTrue(resul.size() > 0, "Results found " + sear );

    }
}

