package com.example.StepDefinition;

import com.example.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class CucumberHooks extends BaseTest {
    @BeforeAll
    public static void beforeTest() {
        getDriver();

    }
    @AfterAll
    public static void afterTest() {
        driver.close();
    }

}
