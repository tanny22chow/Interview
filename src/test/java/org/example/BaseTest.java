package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {

    WebDriver driver;
    Driverfactory driverfactory;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        driverfactory=new Driverfactory();
        driver=driverfactory.getDriver();

    }
    @AfterMethod(enabled = true)
    public void destroy(){
        driver.quit();
        driverfactory.resetThreadlocal();
    }
}
