package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected static WebDriver driver;
    protected ValidatableResponse Response;
    protected static void getDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }



}
