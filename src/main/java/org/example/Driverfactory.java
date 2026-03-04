package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Driverfactory {

    private WebDriver bstacksetup(String browser) throws MalformedURLException {
        Properties p=new commonutils().configreader("./src/main/resources/bstack.properties");
        MutableCapabilities cap=new MutableCapabilities();
        switch (browser){
            case "chrome":
                cap.setCapability("browserName", "Chrome");
                break;
            case "firefox":
                cap.setCapability("browserName", "Firefox");
                break;
            case "edge":
                cap.setCapability("browserName", "Edge");
                break;
            default:
                cap.setCapability("browserName", "Chrome");
                break;
        }


        WebDriver remoteWebDriver=new RemoteWebDriver(new URL(p.getProperty("bstackhub")),cap);
        return remoteWebDriver;
    }

    public WebDriver driver;

    public WebDriver getDriver() throws MalformedURLException {
        if (System.getProperty("env").equals("local")) {
            switch (System.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }


        } else if (System.getProperty("env").equals("cloud")) {
            switch (System.getProperty("browser")) {
                case "chrome":
                    driver = bstacksetup("chrome");
                    break;
                case "firefox":
                    driver = bstacksetup("firefox");
                    break;
                case "safari":
                    driver = bstacksetup("edge");
                    break;
                default:
                    driver = bstacksetup("chrome");
                    break;
            }

        }
        return driver;

    }
}
