package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class GoogleSeleniumTest {

    private ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Profile\\IdeaProjects\\seleniumtesting\\src\\test\\java\\resources\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void searchTest() throws InterruptedException {
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
        WebElement clickOnPicture = driver.findElementById("H3Jk1nGZgdaK6M:");
        clickOnPicture.click();
        Thread.sleep(5000);


//        driver.findElement(By.xpath())
//                driver.findElement(By.cssSelector()) These are for when the element doesn't have an ID
    }

    @Test
    public void messageTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(2000);
        WebElement searchTextBox = driver.findElementById("user-message");
        searchTextBox.sendKeys("This is my message");
        Thread.sleep(5000);
        WebElement showMessageButton = driver.findElement(By.xpath("//*[@id=\"get-input\"]/button"));
        showMessageButton.click();
        Thread.sleep(5000);
        WebElement messageShown = driver.findElementById("display");
        assertTrue(messageShown.isDisplayed());
        Thread.sleep(5000);
    }

    @Test
    public void twoInputTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        Thread.sleep(2000);
        WebElement searchInputBoxA = driver.findElementById("sum1");
        searchInputBoxA.sendKeys("3");
        Thread.sleep(2000);
        WebElement searchInputBoxB = driver.findElementById("sum2");
        searchInputBoxB.sendKeys("3");
        Thread.sleep(2000);
        WebElement getTotalButton = driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button"));
        getTotalButton.click();
        Thread.sleep(5000);
        WebElement sumDone = driver.findElementById("displayvalue");
        assertTrue(sumDone.isDisplayed());
        Thread.sleep(5000);
    }

    @Test
    public void singleCheckBoxTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(2000);
        WebElement checkBox = driver.findElementById("isAgeSelected");
        checkBox.click();
        Thread.sleep(2000);
        WebElement successMessage = driver.findElementById("txtAge");
        assertTrue(successMessage.isDisplayed());
        Thread.sleep(5000);
    }

    @Test
    public void multiCheckBoxTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(2000);
        WebElement checkAllButton = driver.findElement(By.xpath("//*[@id=\"check1\"]"));
        checkAllButton.click();
        Thread.sleep(2000);
        String uncheckAll = driver.findElementById("check1").getAttribute("value");
        assertTrue(uncheckAll.equals("Uncheck All"));
        Thread.sleep(5000);
    }

    @Test
    public void radioButtonTest() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        Thread.sleep(2000);
        WebElement checkMaleButton = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/label[1]/input"));
        checkMaleButton.click();
        Thread.sleep(2000);
        WebElement getValueButton = driver.findElementById("buttoncheck");
        getValueButton.click();
        Thread.sleep(2000);
        WebElement checkMaleOutput = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]"));
        assertTrue(checkMaleOutput.isDisplayed());
        Thread.sleep(2000);
    }

    @Test
    public void radioButtonTest2() throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
        Thread.sleep(2000);
        WebElement checkMaleButton = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[1]/input"));
        checkMaleButton.click();
        Thread.sleep(2000);
        WebElement checkAgeButton = driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label[1]/input"));
        checkAgeButton.click();
        Thread.sleep(2000);
        WebElement getValuesButton = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button");
        getValuesButton.click();
        Thread.sleep(2000);
        String maleAgeTextOutput = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]").getText();
        assertTrue(maleAgeTextOutput.contains("Male"));
        assertTrue(maleAgeTextOutput.contains("0 - 5"));
    }

    @Test
    public void dropDownListTest() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
        Thread.sleep(2000);
        WebElement checkDropDown = driver.findElementById("select-demo");
        checkDropDown.click();
        Thread.sleep(2000);
        WebElement selectOption = driver.findElementByXPath("//*[@id=\"select-demo\"]/option[4]");
        selectOption.click();
        Thread.sleep(2000);
        String checkDay = driver.findElementByXPath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[2]").getText();
        assertTrue(checkDay.contains("Tuesday"));
        Thread.sleep(2000);
    }

}
