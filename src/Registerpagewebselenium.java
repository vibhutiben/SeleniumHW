import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Registerpagewebselenium {

    protected static WebDriver driver;

    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","src\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://demo.nopcommerce.com");
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("veer");
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("satasiya");
        String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
        String emailID = "vintagenoirfashion"+userName+"@hotmail.com";
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailID);
        //driver.findElement(By.xpath("//input[@name='UserName']")).sendKeys("veersat");
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("veer123");
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("veer123");
        driver.findElement(By.xpath("//input[@name='register-button']")).click();
        String actualRegistrationSuccessMessage = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
        Assert.assertEquals("Your registration completed",actualRegistrationSuccessMessage);
       // @Test ;

        driver.quit();
}}
