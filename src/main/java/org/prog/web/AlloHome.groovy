package org.prog.web

import io.cucumber.java.Before

import java.sql.Driver

class AlloHome {
    private Driver driver;
    @BeforeSuite
    public void preTest() {
        driver.get("https://allo.ua/");
    }

    @DataProvider(name = "searchData")
    public Object[][] searchData() {
        return new Object[][]{
                {"iPhone"},
                {"Xiaomi"},
                {"sennheiser"}
        };
    }

    @Test(dataProvider = "searchData")
    public void testSearchForPhone(String searchText) {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-card__content")));

        List<WebElement> productCards = driver.findElements(By.className("product-card__content"));

        for (int i = 0; i < 4 && i < productCards.size(); i++) {
            WebElement productTitle = productCards.get(i).findElement(By.className("product-card__title"));
            String title = productTitle.getText();
            Assert.assertTrue(title.length() > 0, "Product title should have a length greater than 0");
        }
    }

    @Test
    public void testPromoInfo() {
        WebElement discountsBtn = driver.findElement(By.partialLinkText("Акції"));
        public void checkLoginFormTest() {
            "Це поле є обов'язковим для заповнення.", "Bad error message!");
        }
    }
}
}
}
