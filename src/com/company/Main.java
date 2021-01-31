package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        //Set System Property to Chrom .exe file to invoke the browser below
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aisha Hlatshwayo\\Desktop\\chromedriver.exe");

        //Invoke the test in Chrome Driver = creating an object for my driver
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/frames");//Simply opening the website
        driver.manage().window().maximize();//Maximizing the browser

        //Implicit Wait Machine - When your code/test executes faster than your browser, test works with elements that are not there.
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Clicking the nested Frames link
        driver.findElement(By.linkText("Nested Frames")).click();
        //Getting the number of Frames
       int number_of_iframes =  driver.findElements(By.tagName("frame")).size();//Instantiating a variable for the size of the frames there in in the browser
        System.out.println("Number of frames: " + number_of_iframes);//Printing out the number of frames
        driver.switchTo().frame("frame-top");//Switch to Top-Frame
        System.out.println("Switch to Top-Frame");

//        driver.switchTo().defaultContent(); //Swithing to main page
//        driver.switchTo().frame(driver.findElement(By.xpath("//frameset[@name='frameset-middle']")));//frameset-middle
        driver.switchTo().defaultContent(); //Swithing to main page
        driver.switchTo().frame(driver.findElement(By.xpath("//frameset[1]/frame[1]")));//Swithch to To
        driver.switchTo().defaultContent(); //Swithing to main page
        System.out.println(driver.switchTo().frame(driver.findElement(By.xpath("//frameset[1]/frame[2]")).getText()));

    }
}
