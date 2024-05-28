package org.prog.cucumber.steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.cucumber.steps.WebSteps;
import org.prog.web.GooglePage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
    public class HomSteps {
    @CucumberOptions(
            features = "src/test/resources/features",
            glue = "org.prog.cucumber.steps"
    )
    public class CucumberRunner extends AbstractTestNGCucumberTests {
        private static WebDriver driver;

        @BeforeSuite
        public void setUp() {
            CucumberRunner.driver = new ChromeDriver();
            WebSteps.googlePage = new GooglePage(driver);
            driver.manage().window().maximize();
        }

        @AfterSuite
        public void tearDown() {
            CucumberRunner.driver.quit();
            @Override
            @DataProvider(parallel = true)
            public Object[][] scenarios() {
                return super.scenarios();
            }
        }
    }
}
