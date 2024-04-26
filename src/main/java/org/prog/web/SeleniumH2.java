package org.prog.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumH2 {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://allo.ua/");
            driver.manage().window().maximize();
            WebElement searchBtn = driver.findElement(By.id("search-form__input"));
            searchBtn.sendKeys("Samsung Galaxy");
            searchBtn.sendKeys(Keys.ENTER);
            WebElement res1 = driver.findElement(By.partialLinkText("Samsung Galaxy S24 Ultra 12/256 Black"));
            System.out.println(res1.getText());
            WebElement res2=driver.findElement(By.partialLinkText("Samsung Galaxy S24 8/256Gb Black"));
            System.out.println(res2.getText());
            WebElement res3=driver.findElement(By.partialLinkText("Samsung Galaxy S23FE 8/256 Graphite"));
            System.out.println(res3.getText());
            WebElement res4=driver.findElement(By.partialLinkText("Samsung Galaxy A34 8/256 (SM-A346EZKESEK) BLACK"));
            System.out.println(res4.getText());

        } finally {
            driver.quit();

        }
    }
}