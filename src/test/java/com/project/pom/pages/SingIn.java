package com.project.pom.pages;

import com.project.pom.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utils.TestDB;

import java.sql.SQLException;


public class SingIn extends Base {
    //Locators
    By singIn = By.xpath("//a[@class='login']");
    By emailCreate=By.xpath("//input[@id='email_create']");
    By btnSubmitCreate=By.xpath("//button[@id='SubmitCreate']");

    //Personal Information
    By titleMr=By.xpath("//input[@id='id_gender1']");
    By firstName=By.xpath("//input[@id='customer_firstname']");
    By lastName=By.xpath("//input[@id='customer_lastname']");
    By password=By.xpath("//input[@id='passwd']");
    By day=By.xpath("//select[@id='days']");
    By month=By.xpath("//select[@id='months']");
    By year=By.id("years");

    By line1=By.id("address1");
    By line2=By.id("address2");
    By city=By.id("city");
    By state=By.xpath("//select[@id='id_state']");
    By zipCode=By.xpath(" //input[@id='postcode']");
    By phoneNumber=By.xpath("//input[@id='phone_mobile']");
    By btnRegister=By.xpath("//button[@id='submitAccount']");



    public SingIn(WebDriver driver) {
        super(driver);
    }

    //SingIn
    public void singIn() throws InterruptedException, SQLException, ClassNotFoundException {
        String  idCard= TestDB.test();
        driver.findElement(singIn).click();
        Thread.sleep(2000);
        driver.findElement(emailCreate).sendKeys("arianna.carbonell.test.15@gmail.com");
        driver.findElement(btnSubmitCreate).click();
        Thread.sleep(2000);
    }

    //Register

    public void registerUser() throws InterruptedException, SQLException, ClassNotFoundException {
        Thread.sleep(2000);
        click(titleMr);
        Thread.sleep(3000);
        driver.findElement(firstName).sendKeys("arianna");
        Thread.sleep(2000);
        driver.findElement(lastName).sendKeys("arianna");
        Thread.sleep(2000);
        driver.findElement(password).sendKeys("Arianna1234");
        Thread.sleep(2000);
        Select dayB= new Select(driver.findElement(day)) ;
        dayB.selectByValue("23");
        Thread.sleep(2000);
        Select monthB= new Select(driver.findElement(month)) ;
        monthB.selectByValue("5");
        Thread.sleep(2000);
        Select yearB= new Select(driver.findElement(year));
        yearB.selectByValue("1991");
        Thread.sleep(2000);
        driver.findElement(line1).sendKeys("line1");
        Thread.sleep(2000);
        driver.findElement(line2).sendKeys("line2");
        Thread.sleep(2000);
        driver.findElement(city).sendKeys("City");
        Thread.sleep(2000);
        Select stateA= new Select(driver.findElement(state));
        stateA.selectByValue("3");
        Thread.sleep(2000);
        driver.findElement(zipCode).sendKeys("23232");
        Thread.sleep(2000);
        driver.findElement(phoneNumber).sendKeys("12229393332");
        Thread.sleep(2000);
        click(btnRegister);













    }


}
