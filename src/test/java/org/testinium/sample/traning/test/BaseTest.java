package org.testinium.sample.traning.test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    WebDriver driver;

    @Before
    public void startTest(){
        ChromeOptions options = new ChromeOptions(); //bildirimleri engellemesi için
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.gittigidiyor.com");
    }

    @After
    public void endTest() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    public void sendByDataCy(String dataCy, String value){
        driver.findElement(By.xpath("//*[@data-cy='"+dataCy+"']")).clear();
        driver.findElement(By.xpath("//*[@data-cy='"+dataCy+"']")).sendKeys(value);
    }

    public void clickByDataCy(String dataCy)  {
        driver.findElement(By.xpath("//*[@data-cy='"+dataCy+"']")).click();
    }

    public void sendById(String id, String value){
        driver.findElement(By.id(id)).sendKeys(value);
    }

    public void clickById(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickByXpath(String xpathh){
        driver.findElement(By.xpath(xpathh)).click();

    }
    public void sendByName(String text,String value){
        driver.findElement(By.xpath("//*[@name='"+text+"']")).sendKeys(value);
    }

    public void callHomePage() {
        driver.get("https://www.gittigidiyor.com/");
    }
    public void clickByClassName(String name) {
        driver.findElement(By.className(name)).click();
    }



}