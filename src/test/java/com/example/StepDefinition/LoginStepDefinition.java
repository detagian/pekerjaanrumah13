package com.example.StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.example.BaseTest;
import com.example.Page.LoginPage;


public class LoginStepDefinition extends BaseTest {

    protected LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @And("user input username {string}")
    public void userInputUsernameWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password {string}")
    public void userInputPasswordWith(String password) {
        loginPage.inputPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("user see error massage {string}")
    public void userAbleToSeeErrorMessage(String errorMessage) {
        loginPage.validateErrorAppear(errorMessage);
    }
}
