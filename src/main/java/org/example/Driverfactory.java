package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Driverfactory {
    ThreadLocal<WebDriver> threadLocal=new ThreadLocal<>();
    public WebDriver driver;
    private WebDriver bstacksetup(String browser) throws MalformedURLException {
        Properties p=new commonutils().configreader("./src/main/resources/bstack.properties");
        MutableCapabilities cap=new MutableCapabilities();
        switch (browser){
            case "chrome"->
                cap.setCapability("browserName", "Chrome");
            case "firefox"->
                cap.setCapability("browserName", "Firefox");
            case "edge"->
                cap.setCapability("browserName", "Edge");
            default->
                cap.setCapability("browserName", "Chrome");
        }

        return new RemoteWebDriver(new URL(p.getProperty("bstackhub")),cap);
    }

    public WebDriver getDriver() throws MalformedURLException {
        if (System.getProperty("env").equals("local")) {
            switch (System.getProperty("browser")) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "edge" -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }

        } else if (System.getProperty("env").equals("cloud")) {
            switch (System.getProperty("browser")) {
                case "chrome" -> driver = bstacksetup("chrome");
                case "firefox" -> driver = bstacksetup("firefox");
                case "safari" -> driver = bstacksetup("edge");
                default -> driver = bstacksetup("chrome");
            }

        }
        threadLocal.set(driver);
        return threadLocal.get();

    }
}
