package com.qa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

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

    @Test
    public void inputFormTest() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        Thread.sleep(2000);
        WebElement fillFirstName = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[1]/div/div/input");
        fillFirstName.sendKeys("Suvnah");
        Thread.sleep(2000);
        WebElement fillLastName = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[2]/div/div/input");
        fillLastName.sendKeys("Goober");
        Thread.sleep(2000);
        WebElement fillEmail = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[3]/div/div/input");
        fillEmail.sendKeys("suvnahisbetrayme@hotmail.com");
        Thread.sleep(2000);
        WebElement fillNumber = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[4]/div/div/input");
        fillNumber.sendKeys("0161");
        Thread.sleep(2000);
        WebElement fillAddress = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[5]/div/div/input");
        fillAddress.sendKeys("1 Betrayer Street, Betrayerville");
        Thread.sleep(2000);
        WebElement fillCity = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[6]/div/div/input");
        fillCity.sendKeys("Traitorcester");
        Thread.sleep(2000);
        WebElement fillState = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select");
        fillState.click();
        Thread.sleep(2000);
        WebElement fillStateOption = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select/option[5]");
        fillStateOption.click();
        Thread.sleep(2000);
        WebElement fillZip = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[8]/div/div/input");
        fillZip.sendKeys("blah23");
        Thread.sleep(2000);
        WebElement fillWeb = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[9]/div/div/input");
        fillWeb.sendKeys("blah23.com");
        Thread.sleep(2000);
        WebElement fillHosting = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[10]/div/div[1]/label/input");
        fillHosting.click();
        Thread.sleep(2000);
        WebElement Des = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[11]/div/div/textarea");
        fillWeb.sendKeys("blah23.com");
        Thread.sleep(2000);
        WebElement clickSend = driver.findElementByXPath("//*[@id=\"contact_form\"]/fieldset/div[11]/div/div/textarea");
        clickSend.click();
        Thread.sleep(2000);
    }

    @Test
    public void RangeSliders() throws InterruptedException{
        driver.get("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
        Thread.sleep(2000);
        WebElement slider10 = driver.findElementByXPath("//*[@id=\"slider3\"]/div/input");
        //Dimension slidersize = slider10.getSize();
        //int sliderwidth = slidersize.getWidth();
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(slider10).perform();
        action.click();
        Thread.sleep(2000);
        action.moveByOffset(5,0).perform();
        action.click();
        Thread.sleep(2000);



    }

//    @Test
//    public void sporcle() throws InterruptedException{
//        driver.get("https://www.sporcle.com");
//        Thread.sleep(3000);
//        WebElement search = driver.findElementById("searchBox");
//        search.sendKeys("countries of the world");
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(3000);
//        WebElement countriesQuiz = driver.findElementByXPath("//*[@id=\"1cf2bfb2fe\"]/a");
//        countriesQuiz.click();
//        Thread.sleep(3000);
//        WebElement playQuiz = driver.findElementByXPath("//*[@id=\"button-play\"]/span");
//        playQuiz.click();
//        Thread.sleep(3000);
//        WebElement typeAnswer = driver.findElementById("gameinput");
//        typeAnswer.sendKeys("France");
//        typeAnswer.sendKeys("Afghanistan");
//        typeAnswer.sendKeys("Albania");
//        typeAnswer.sendKeys("Afghanistan");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("Afghanistan");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("Albania");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Algeria");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Andorra");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Angola");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Antigua and Barbuda");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Argentina");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Armenia");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Australia");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Austria");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Azerbaijan");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Bahamas");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Bahrain");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Bangladesh");
//        Thread.sleep(3000);
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Barbados	");
//        typeAnswer.sendKeys("	Belarus	");
//        typeAnswer.sendKeys("	Belgium	");
//        typeAnswer.sendKeys("	Belize	");
//        typeAnswer.sendKeys("	Benin	");
//        typeAnswer.sendKeys("	Bhutan	");
//        typeAnswer.sendKeys("	Bolivia	");
//        typeAnswer.sendKeys("	Bosnia and Herzegovina	");
//        typeAnswer.sendKeys("	Botswana	");
//        typeAnswer.sendKeys("	Brazil	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Brunei	");
//        typeAnswer.sendKeys("	Bulgaria	");
//        typeAnswer.sendKeys("	Burkina Faso	");
//        typeAnswer.sendKeys("	Burundi	");
//        typeAnswer.sendKeys("	Cabo Verde	");
//        typeAnswer.sendKeys("	Cambodia	");
//        typeAnswer.sendKeys("	Cameroon	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Canada	");
//        typeAnswer.sendKeys("	Central African Republic	");
//        typeAnswer.sendKeys("	Chad	");
//        typeAnswer.sendKeys("	Chile	");
//        typeAnswer.sendKeys("	China	");
//        typeAnswer.sendKeys("	Colombia	");
//        typeAnswer.sendKeys("	Comoros	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Congo	");
//        typeAnswer.sendKeys("	Costa Rica	");
//        typeAnswer.sendKeys("	Croatia	");
//        typeAnswer.sendKeys("	Cuba	");
//        typeAnswer.sendKeys("	Cyprus	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Czechia	");
//        typeAnswer.sendKeys("	Côte d'Ivoire	");
//        typeAnswer.sendKeys("	Denmark	");
//        typeAnswer.sendKeys("	Djibouti	");
//        typeAnswer.sendKeys("	Dominica	");
//        typeAnswer.sendKeys("	Dominican Republic	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	DR Congo	");
//        typeAnswer.sendKeys("	Ecuador	");
//        typeAnswer.sendKeys("	Egypt	");
//        typeAnswer.sendKeys("	El Salvador	");
//        typeAnswer.sendKeys("	Equatorial Guinea	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Eritrea	");
//        typeAnswer.sendKeys("	Estonia	");
//        typeAnswer.sendKeys("	Eswatini	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Ethiopia	");
//        typeAnswer.sendKeys("	Fiji	");
//        typeAnswer.sendKeys("	Finland	");
//        typeAnswer.sendKeys("	France	");
//        typeAnswer.sendKeys("	Gabon	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Gambia	");
//        typeAnswer.sendKeys("	Georgia	");
//        typeAnswer.sendKeys("	Germany	");
//        typeAnswer.sendKeys("	Ghana	");
//        typeAnswer.sendKeys("	Greece	");
//        typeAnswer.sendKeys("	Grenada	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Guatemala	");
//        typeAnswer.sendKeys("	Guinea	");
//        typeAnswer.sendKeys("	Guinea-Bissau	");
//        typeAnswer.sendKeys("	Guyana	");
//        typeAnswer.sendKeys("	Haiti	");
//        typeAnswer.sendKeys("	Holy See	");
//        typeAnswer.sendKeys("	Honduras	");
//        typeAnswer.sendKeys("	Hungary	");
//        typeAnswer.sendKeys("	Iceland	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	India	");
//        typeAnswer.sendKeys("	Indonesia	");
//        typeAnswer.sendKeys("	Iran	");
//        typeAnswer.sendKeys("	Iraq	");
//        typeAnswer.sendKeys("	Ireland	");
//        typeAnswer.sendKeys("	Israel	");
//        typeAnswer.sendKeys("	Italy	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Jamaica	");
//        typeAnswer.sendKeys("	Japan	");
//        typeAnswer.sendKeys("	Jordan	");
//        typeAnswer.sendKeys("	Kazakhstan	");
//        typeAnswer.sendKeys("	Kenya	");
//        typeAnswer.sendKeys("	Kiribati	");
//        typeAnswer.sendKeys("	Kuwait	");
//        typeAnswer.sendKeys("	Kyrgyzstan	");
//        typeAnswer.sendKeys("	Laos	");
//        typeAnswer.sendKeys("	Latvia	");
//        typeAnswer.sendKeys("	Lebanon	");
//        typeAnswer.sendKeys("	Lesotho	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Liberia	");
//        typeAnswer.sendKeys("	Libya	");
//        typeAnswer.sendKeys("	Liechtenstein	");
//        typeAnswer.sendKeys("	Lithuania	");
//        typeAnswer.sendKeys("	Luxembourg	");
//        typeAnswer.sendKeys("	Madagascar	");
//        typeAnswer.sendKeys("	Malawi	");
//        typeAnswer.sendKeys("	Malaysia	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Maldives	");
//        typeAnswer.sendKeys("	Mali	");
//        typeAnswer.sendKeys("	Malta	");
//        typeAnswer.sendKeys("	Marshall Islands	");
//        typeAnswer.sendKeys("	Mauritania	");
//        typeAnswer.sendKeys("	Mauritius	");
//        typeAnswer.sendKeys("	Mexico	");
//        typeAnswer.sendKeys("	Micronesia	");
//        typeAnswer.sendKeys("	Moldova	");
//        typeAnswer.sendKeys("	Monaco	");
//        typeAnswer.sendKeys("	Mongolia	");
//        typeAnswer.sendKeys("	Montenegro	");
//        typeAnswer.sendKeys("	Morocco	");
//        typeAnswer.sendKeys("	Mozambique	");
//        typeAnswer.sendKeys("	Myanmar	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Namibia	");
//        typeAnswer.sendKeys("	Nauru	");
//        typeAnswer.sendKeys("	Nepal	");
//        typeAnswer.sendKeys("	Netherlands	");
//        typeAnswer.sendKeys("	New Zealand	");
//        typeAnswer.sendKeys("	Nicaragua	");
//        typeAnswer.sendKeys("	Niger	");
//        typeAnswer.sendKeys("	Nigeria	");
//        typeAnswer.sendKeys("	North Korea	");
//        typeAnswer.sendKeys("	North Macedonia	");
//        typeAnswer.sendKeys("	Norway	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Oman	");
//        typeAnswer.sendKeys("	Pakistan	");
//        typeAnswer.sendKeys("	Palau	");
//        typeAnswer.sendKeys("	Panama	");
//        typeAnswer.sendKeys("	Papua New Guinea	");
//        typeAnswer.sendKeys("	Paraguay	");
//        typeAnswer.sendKeys("	Peru	");
//        typeAnswer.sendKeys("	Philippines	");
//        typeAnswer.sendKeys("	Poland	");
//        typeAnswer.sendKeys("	Portugal	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Qatar	");
//        typeAnswer.sendKeys("	Romania	");
//        typeAnswer.sendKeys("	Russia	");
//        typeAnswer.sendKeys("	Rwanda	");
//        typeAnswer.sendKeys("	Saint Kitts & Nevis	");
//        typeAnswer.sendKeys("	Saint Lucia	");
//        typeAnswer.sendKeys("	Samoa	");
//        typeAnswer.sendKeys("	San Marino	");
//        typeAnswer.sendKeys("	Sao Tome & Principe	");
//        typeAnswer.sendKeys("	Saudi Arabia	");
//        typeAnswer.sendKeys("	Senegal	");
//        typeAnswer.sendKeys("	Serbia	");
//        typeAnswer.sendKeys("	Seychelles	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Sierra Leone	");
//        typeAnswer.sendKeys("	Singapore	");
//        typeAnswer.sendKeys("	Slovakia	");
//        typeAnswer.sendKeys("	Slovenia	");
//        typeAnswer.sendKeys("	Solomon Islands	");
//        typeAnswer.sendKeys("	Somalia	");
//        typeAnswer.sendKeys("	South Africa	");
//        typeAnswer.sendKeys("	South Korea	");
//        typeAnswer.sendKeys("	South Sudan	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Spain	");
//        typeAnswer.sendKeys("	Sri Lanka	");
//        typeAnswer.sendKeys("	St. Vincent & Grenadines	");
//        typeAnswer.sendKeys("	Palestine	");
//        typeAnswer.sendKeys("	Sudan	");
//        typeAnswer.sendKeys("	Suriname	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Sweden	");
//        typeAnswer.sendKeys("	Switzerland	");
//        typeAnswer.sendKeys("	Syria	");
//        typeAnswer.sendKeys("	Tajikistan	");
//        typeAnswer.sendKeys("	Tanzania	");
//        typeAnswer.sendKeys("	Thailand	");
//        typeAnswer.sendKeys("	Timor-Leste	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Togo	");
//        typeAnswer.sendKeys("	Tonga	");
//        typeAnswer.sendKeys("	Trinidad and Tobago	");
//        typeAnswer.sendKeys("	Tunisia	");
//        typeAnswer.sendKeys("	Turkey	");
//        typeAnswer.sendKeys("	Turkmenistan	");
//        typeAnswer.sendKeys("	Tuvalu	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Uganda	");
//        typeAnswer.sendKeys("	Ukraine	");
//        typeAnswer.sendKeys("	United Arab Emirates	");
//        typeAnswer.sendKeys("	United Kingdom	");
//        typeAnswer.sendKeys("	United States	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Uruguay	");
//        typeAnswer.sendKeys("	Uzbekistan	");
//        typeAnswer.sendKeys("	Vanuatu	");
//        typeAnswer.sendKeys("	Venezuela	");
//        typeAnswer.sendKeys("	Vietnam	");
//        typeAnswer.sendKeys("	Yemen	");
//        Thread.sleep(3000);
//        typeAnswer.sendKeys("	Zambia	");
//        typeAnswer.sendKeys("	Zimbabwe	");
//
//
//        Thread.sleep(7000);
//
//
//
//    }

}
