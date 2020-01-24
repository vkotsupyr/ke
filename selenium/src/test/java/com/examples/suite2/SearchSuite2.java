package com.examples.suite2;

import com.examples.AbstractUiTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SearchSuite2 extends AbstractUiTest
{
    @Test
    public void searchTest()
    {
        WebElement search = driver.findElement( By.name( "q" ) );
        search.clear();
        search.sendKeys( "TEST" );
        search.sendKeys( Keys.ENTER );
    }
}
