package com.examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;

public class AbstractUiTest
{
    protected WebDriver driver;

    @BeforeClass
    public void init()
    {
        System.setProperty("webdriver.gecko.driver","C:\\my\\KE\\libs\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( 10, TimeUnit.SECONDS );
        driver.navigate().to( "https://www.google.com/" );
    }



    @AfterClass
    public void quit() {
        driver.close();
    }
}
