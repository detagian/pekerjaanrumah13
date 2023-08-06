package com.example.StepDefinition;

import io.cucumber.java.en.Then;
import com.example.BaseTest;
import com.example.Page.HomePage;
import io.cucumber.java.en.When;

public class HomeStepDefinition extends BaseTest {
    HomePage homePage;

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        homePage = new HomePage(driver);
        homePage.validateOnHomePage();
    }

    @When("user click sort item by character descending")
    public void userClickSortItemByCharacterDescending() {
        homePage.clickSortOptionByCharacterDescending();
    }

    @Then("item is sorted descendingly by character")
    public void itemIsSortedDescendinglyByCharacter() {
        homePage.verifySortByCharacterDescending();
    }

    @Then("user see all items price is under ${int} dollar")
    public void userSeeAllItemsPriceIsUnder$Dollar(int price) {
        homePage.verifyPriceUnderPromo(price);
    }
}
