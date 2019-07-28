package org.fasttrackit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {

    private static WebDriver cDriver;

    @BeforeClass
    public static void initDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        cDriver = new ChromeDriver();
    }

    @AfterClass
    public static void deactivateDriver() {
        cDriver.quit();
    }

    @Test
    public void runMultipletTests() {

        //initDriver();
        cDriver.manage().window().maximize();
        loginTest();
        //wishList();
        //registerNewUser();
        //testSelectors();
        logoutTest();
        deactivateDriver();
    }


    @Test
    public void loginTest() {
        Assert.assertNotNull(cDriver);
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
        WebElement userName = cDriver.findElement(By.className("hello"));
        Assert.assertTrue(userName.getText().contentEquals("Hello, TesterFN TesterLN!"));
        System.out.println("User name text content = " + userName.getText());
        wait(2);
        System.out.println("Login web test completed");
        System.out.println("---------------------------------------");
    }

    @Test
    public void addItemsToCart() {
        Assert.assertNotNull(cDriver);
        cDriver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("---------------------------------------");
        System.out.println("Running test to add items to the shopping cart");
        WebElement logo = cDriver.findElement(By.className("logo"));
        logo.click();
        WebElement saleButton = cDriver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent"));
        System.out.println("Sale text = " + saleButton.getText());
        Assert.assertTrue(saleButton.getText().contentEquals("SALE"));
        saleButton.click();
        // Select first product
        WebElement firstImage = cDriver.findElement(By.cssSelector("#product-collection-image-423"));
        System.out.println("Image size = " + firstImage.getSize());
        Assert.assertTrue(firstImage.getSize().toString().equals("(153, 153)"));
        firstImage.click();
        //Set color and size
        cDriver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        cDriver.findElement(By.cssSelector("#option80")).click();
        // Click add to cart
        WebElement addToCartButton = cDriver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button"));
        addToCartButton.click();
        wait(3);
        // Select the second product
        cDriver.get("https://fasttrackit.org/selenium-test/");
        wait(5);
        saleButton = cDriver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent"));
        saleButton.click();
        WebElement secondImage = cDriver.findElement(By.cssSelector("#product-collection-image-403"));
        secondImage.click();
        //Set color and size
        cDriver.findElement(By.cssSelector("#swatch27 > span.swatch-label")).click();
        cDriver.findElement(By.cssSelector("#swatch81 > span.swatch-label")).click();
        // Click add to cart
        addToCartButton = cDriver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button"));
        addToCartButton.click();
        wait(5);
        // Selecting the first trash button
        WebElement firstTrashButton = cDriver.findElement(By.cssSelector("#shopping-cart-table > tbody >  tr.first.odd > td.a-center.product-cart-remove.last > a"));
        firstTrashButton.click();

        wait(5);
        System.out.println("Add items to cart test completed");
        System.out.println("---------------------------------------");
    }

    @Test
    public void proceedToCheckout() {
        Assert.assertNotNull(cDriver);
        cDriver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("---------------------------------------");
        System.out.println("Running test to add one item to the shopping cart and proceed to checkout");
        WebElement logo = cDriver.findElement(By.className("logo"));
        logo.click();
        WebElement saleButton = cDriver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent"));
        saleButton.click();
        // Select first product
        WebElement firstImage = cDriver.findElement(By.cssSelector("#product-collection-image-423"));
        firstImage.click();
        //Set color and size
        cDriver.findElement(By.cssSelector("#swatch18 > span.swatch-label > img")).click();
        cDriver.findElement(By.cssSelector("#option80")).click();
        // Click add to cart
        WebElement addToCartButton = cDriver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button"));
        addToCartButton.click();
        wait(3);
        // Click add to cart
        WebElement proceedToCheckoutButton = cDriver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.cart.display-single-price > div.cart-totals-wrapper > div > ul > li > button"));
        System.out.println("Proceed to checkout button text = " + proceedToCheckoutButton.getText());
        Assert.assertTrue(proceedToCheckoutButton.getText().contentEquals("PROCEED TO CHECKOUT"));
        proceedToCheckoutButton.click();
        wait(5);
        System.out.println("Proceed to checkout test completed");
        System.out.println("---------------------------------------");
    }

    @Test
    public void sortBy() {
        Assert.assertNotNull(cDriver);
        cDriver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("---------------------------------------");
        System.out.println("Running test to check the sort by selector");
        WebElement logo = cDriver.findElement(By.className("logo"));
        logo.click();
        WebElement saleButton = cDriver.findElement(By.cssSelector("#nav > ol > li.level0.nav-5.parent"));
        saleButton.click();
        WebElement sortByButton = cDriver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > div.toolbar > div.sorter > div > select"));
        Assert.assertNotNull(sortByButton);
        System.out.println("Sort by list content = " + sortByButton.getText());
        sortByButton.click();
        Assert.assertNotNull(sortByButton);
        wait(5);
        System.out.println("Sort by test completed");
        System.out.println("---------------------------------------");
    }

    @Test
    public void testSelectors() {
        cDriver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("---------------------------------------");
        System.out.println("Running selectors check web test");
        System.out.println("-------");
        System.out.println("Checking the Search button");
        WebElement searchIcon = cDriver.findElement(By.className("search-button"));
        cDriver.findElement(By.cssSelector("#search")).sendKeys("test");
        searchIcon.click();
        System.out.println("Checking the first Delete button, after adding items to cart");
        addItemsToCart();
        wait(3);
        System.out.println("Checking the second Proceed to checkout button");
        proceedToCheckout();
        wait(3);
        System.out.println("Checking the sort by selector");
        sortBy();
        wait(3);
    }

    @Test
    public void logoutTest() {
        Assert.assertNotNull(cDriver);
        cDriver.get("https://fasttrackit.org/selenium-test/");
        System.out.println("---------------------------------------");
        System.out.println("Running logout web test");
        WebElement accountButton = cDriver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        WebElement logoutLink = cDriver.findElement(By.cssSelector("#header-account > div > ul > li.last > a"));
        System.out.println("Logout text font size = " + logoutLink.getCssValue("font-size"));
        Assert.assertTrue(logoutLink.getCssValue("font-size").contentEquals("14px"));
        accountButton.click();
        wait(1);
        Assert.assertTrue(logoutLink.getText().contentEquals("Log Out"));
        try {
            logoutLink.click();
        } catch (Exception e) {
            System.out.println("Can't logout! Error: " + e.toString());
        }
        wait(2);
        System.out.println("Logout web test completed");
        System.out.println("---------------------------------------");
    }


    @Test
    public void wishList() {
        Assert.assertNotNull(cDriver);
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
    }

    @Test
    public void registerNewUser() {
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