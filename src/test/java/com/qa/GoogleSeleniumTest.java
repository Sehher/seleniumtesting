package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Profile\\IdeaProjects\\seleniumtesting\\src\\test\\java\\resources\\chromedriver.exe");

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void searchTest() throws InterruptedException {
        // //maximises the screen
        driver.get("http://google.com");
        Thread.sleep(2000); //This keeps the window open for 2 seconds before closing it
        WebElement searchField = driver.findElement(By.name("q"));
        assertTrue(searchField.isDisplayed());
        searchField.sendKeys("funny cat pictures"); //adds text to search field
        Thread.sleep(5000);
        WebElement submitButton = driver.findElement(By.name("btnK"));
        submitButton.click();
        Thread.sleep(5000);
        WebElement linkToBiggerPicture = driver.findElementByLinkText("Images for funny cat"); //finds the link in the web search
        linkToBiggerPicture.click();
        Thread.sleep(5000);
    }

}
