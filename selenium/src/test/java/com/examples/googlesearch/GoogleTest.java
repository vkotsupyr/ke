package com.examples.googlesearch;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTest
{
    private WebDriver driver;
    private GooglePage google;

    @BeforeTest
    public void setUp() throws MalformedURLException
    {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setBrowserName( "chrome" );
        dc.setPlatform( Platform.LINUX );
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
//        driver = new RemoteWebDriver(new URL("http://172.17.0.4:5555/wd/hub"), dc);
        google = new GooglePage(driver);
    }

    @Test
    public void googleTest() throws InterruptedException {
        google.goTo();
        google.searchFor("automation");
        Assert.assertTrue(google.getResults().size() >= 3);
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.quit();
    }
}
