package com.project.pom.test;

import com.project.pom.pages.SingIn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.sql.SQLException;

public class RegisterTest {
    private WebDriver driver;
    SingIn singIn;

    @Before
    public void setUp(){
        singIn= new SingIn(driver);
        driver=singIn.chromeDriverConnection();
        driver.get("http://automationpractice.com/index.php");
    }
    @After
    public void quit(){
        //driver.quit();
    }
    @Test
    public  void register() throws InterruptedException, SQLException, ClassNotFoundException {
        singIn.singIn();
        singIn.registerUser();
    }
}
