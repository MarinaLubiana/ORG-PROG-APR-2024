package org.prog.cucumber.steps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import java.time.Duration;import java.util.List;
public class CUSteps {
    public class Cucumberstep {
        public static WebDriver driver;
        private final static String SEARCH_PAGE_NUMBERS = "//li[@class='paginationitem']/a[contains(text(), '%s')]";
        private final static String PAGE_PREV_XPATH = "//*[@aria-label='prevision page']";
        private final static String PAGE_NEXT_XPATH = "//*[@class='paginationnext']/a";
        @Given("I load Allo page")
        public void loadPage() { driver.get("https://allo.ua/");
        } @Given("I click search")
        public List<WebElement> getSearchResults() {
            return new WebDriverWait(driver, Duration.ofSeconds(30L)) .until( ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div.product-card"), 1) );
        } @When("I search Samsung Galaxy S24") public void searchForGoods(String searchValue) { WebElement searchInput = driver.findElement(By.name("search"));

            searchInput.sendKeys(searchValue);
            searchInput.sendKeys(Keys.ENTER);
        } @Then("I see goods in page") public WebElement searchResultsContain(String value) { String phoneName = "Samsung Galaxy S24";
            List<WebElement> searchResults = getSearchResults();
            Assert.assertFalse(searchResults.isEmpty(), "Search results must not be empty!");
            boolean valueIsPresent = false;
            for (WebElement e : searchResults) {
                if (e.findElement(By.xpath("div/a")).getText().contains(value)) { valueIsPresent = true;
                    break;
            }
            } return valueIsPresent;
         @Given("I switch To Next Page") public WebElement pagination() {
            } return driver.findElement(By.className("pagination"));
            } public void scrollToElement(WebElement e) { ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        } public void switchToNextPage() { switchPrevNextPage(PAGE_NEXT_XPATH);

        } private void switchPrevNextPage(String xpath) { scrollToElement(pagination());
            if (isPaginationMissing(xpath)) { System.out.println("Pagination is missing!");
            } else { new WebDriverWait(driver, Duration.ofSeconds(30L)) .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))) .click();
            } waitForLoadingToFinish();
        } private boolean isPaginationMissing(String xpath) { List<WebElement> pagination = new WebDriverWait(driver, Duration.ofSeconds(30L)) .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
            return pagination.isEmpty();
        } private void waitForLoadingToFinish() {
            new WebDriverWait(driver, Duration.ofSeconds(30L)) .until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-block-gif")));
        } @Given("I switch To Search Page By Number")
        public void switchToSearchPageByNumber(String number) {
            new WebDriverWait(driver, Duration.ofSeconds(30L)) .until(ExpectedConditions.presenceOfElementLocated( By.xpath(String.format(SEARCH_PAGE_NUMBERS, number)))) .click(); waitForLoadingToFinish();
        } @Given("I switch To Prev Page") public void switchToPrevPage() { switchPrevNextPage(PAGE_PREV_XPATH);
        }
    }
}
