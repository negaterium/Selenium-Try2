package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
    WebDriver cDriver;

    @Test
    public void runMultipletTests() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver cDriver = new ChromeDriver();
        loginTest();
        wishList();
        registerNewUser();
        cDriver.quit();
    }


    @Test
    public void loginTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver cDriver = new ChromeDriver();
        cDriver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("---------------------------------------");
        System.out.println("Running login web test");
        WebElement accountButton = cDriver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        WebElement loginLink = cDriver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));

        accountButton.click();
        wait(1);
        loginLink.click();
        cDriver.findElement(By.cssSelector("#email")).sendKeys("negaterium@yahoo.com");
        cDriver.findElement(By.cssSelector("#pass")).sendKeys("q1w2e3r4t5");
        wait(1);
        cDriver.findElement(By.cssSelector("#send2")).click();
        wait(2);
        System.out.println("Login web test completed");
        System.out.println("---------------------------------------");
        cDriver.quit();
    }

    @Test
    public void wishList() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver cDriver = new ChromeDriver();
        cDriver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("---------------------------------------");
        System.out.println("Running wishlist web test");
        WebElement saleButton = cDriver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent > a"));
        saleButton.click();
        wait(1);
        cDriver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1) > div > div.actions > a")).click();
        wait(1);
        cDriver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > ul.add-to-links > li:nth-child(1) > a")).click();
        wait(2);
        System.out.println("Wishlist web test completed");
        System.out.println("---------------------------------------");
        cDriver.quit();
    }

    @Test
    public void registerNewUser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver cDriver = new ChromeDriver();
        System.out.println("---------------------------------------");
        System.out.println("Running register web test");
        cDriver.get("https://fasttrackit.org/selenium-test/");
        WebElement accountButton = cDriver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        WebElement registerLink = cDriver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a"));

        accountButton.click();
        wait(1);
        registerLink.click();
        cDriver.findElement(By.cssSelector("#firstname")).sendKeys("John");
        cDriver.findElement(By.cssSelector("#middlename")).sendKeys("Midie");
        cDriver.findElement(By.cssSelector("#lastname")).sendKeys("Doe");
        cDriver.findElement(By.cssSelector("#email_address")).sendKeys("negaterium@yahoo.com");
        cDriver.findElement(By.cssSelector("#password")).sendKeys("test1234");
        cDriver.findElement(By.cssSelector("#confirmation")).sendKeys("test1234");
        cDriver.findElement(By.cssSelector("#is_subscribed")).click();
        wait(2);
        cDriver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();
        wait(2);

        System.out.println("Register web test completed");
        System.out.println("---------------------------------------");
        cDriver.quit();
    }

    private static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
            System.out.println("Waiting ...");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

}
