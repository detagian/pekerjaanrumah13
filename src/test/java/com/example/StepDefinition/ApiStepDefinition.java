package com.example.StepDefinition;

import com.example.BaseTest;
import com.example.apiAutomation.TestReqRes;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ApiStepDefinition extends BaseTest {

    protected TestReqRes TestApi;
    protected String valueEmail,valuePassword,valueUrl;
    @Given("I set service api")
    public void iSetServiceApi() {
        TestApi = new TestReqRes(Response);
        TestApi.setup();

    }
    @When("I set Header method GET using Endpoint {string}")
    public void iSetHeaderMethodGETUsingEndpoint(String url) {
        valueUrl = url;
        TestApi.setEndpointMethodGet(valueUrl);
    }

    @Then("I received a valid HTTP response code {int}")
    public void iReceivedAValidHTTPResponseCode(int httpsResponse) {
        TestApi.verifyResponseCode(httpsResponse);
    }

    @And("I received a valid total {int} user")
    public void iReceivedAValidTotalUser(int totalUser) {
        TestApi.verifyTotal(totalUser);
    }

    @And("I received a valid {string}")
    public void iReceivedAValid(String jsonScheme) {
        TestApi.verfiyJSONScheme(jsonScheme);

    }

    @When("I set Email value {string}")
    public void iSetEmailValue(String email) {
        valueEmail = email;
    }

    @And("I set Password value {string}")
    public void iSetPasswordValue(String password) {
        valuePassword = password;

    }

    @And("I set Header method POST using Endpoint {string}")
    public void iSetHeaderMethodPOSTUsingEndpoint(String url) {
        valueUrl = url;
    }

    @Then("I received a login response")
    public void iReceivedALoginResponse() {
        TestApi.setEndpointPOSTForLogin(valueUrl,valueEmail,valuePassword);
    }
}
