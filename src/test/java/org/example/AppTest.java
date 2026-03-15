package org.example;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class AppTest extends  BaseTest

{
    @Test
    public void m1(){
        driver.navigate().to("https://medium.com/");
        System.out.println(driver.getTitle());
    }

}
