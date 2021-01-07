package com.project.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Base {
    public WebDriver driver;
    private By locator;

    public Base(WebDriver driver){
        this.driver=driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        driver= new ChromeDriver();
        return driver;
    }

    //Wrapper findElement
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    //Wrapper findElements
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    //Wrapper getTest
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    //Wrapper Click
    public void click(By locator){
        driver.findElement(locator).click();
    }


}
