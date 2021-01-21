package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        //Set System Property to Chrom .exe file to invoke the browser below
        System.setProperty("webdriver.chrome.driver", "C:\\Work\\chromedriver.exe");

        //Invoke the test in Chrome Driver = creating an object for my driver
        WebDriver driver = new ChromeDriver();
        //Implicit Wait Machine - When your code/test executes faster than your browser, test works with elements that are not there.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/frames");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
//        //Find the number on frames -> How many frames are present in this execution.
        System.out.println(driver.findElements(By.tagName("frame")).size());

        System.out.println("********We are switch to the frame*******");
//        //Switch frame with index
//        driver.switchTo().parentFrame();
        System.out.println(driver.switchTo().frame(1));

        Actions actions = new Actions(driver);

        driver.switchTo().frame(driver.findElement(By.cssSelector("//frameset[1]/frame[2]")));
        System.out.println(driver.switchTo().frame(driver.findElement(By.xpath("/html[1]/body[1]/div[1]")).getText()));

    }
}
