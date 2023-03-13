package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FacebookTestingApp {
    private static final String XPATH_COOKIES = "//button[contains(string(), 'Allow essential and optional cookies')]";
    private static final String XPATH_NEW_ACCOUNT = "//div[contains(@class, \"_6ltg\")]/a";
    private static final String XPATH_MONTH = "//select[contains(@id, \"month\")]";
    private static final String XPATH_DAY = "//select[contains(@id, \"day\")]";
    private static final String XPATH_YEAR = "//select[contains(@id, \"year\")]";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath(XPATH_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_NEW_ACCOUNT)).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement month = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_MONTH)));
        Select selectMonth = new Select(month);
        selectMonth.selectByIndex(6);

        WebElement day = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(day);
        selectDay.selectByIndex(12);

        WebElement year = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(year);
        selectYear.selectByValue("2000");
    }
}