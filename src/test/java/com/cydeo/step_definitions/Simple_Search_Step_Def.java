package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.concurrent.TimeUnit;

public class Simple_Search_Step_Def   {
    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get("http://etsy.com");

    }
    @When("I search for {string}")
    public void i_search_for(String search) {
        Driver.getDriver().findElement(By.cssSelector("[id*='search-query']")).sendKeys(search + Keys.ENTER);
    }

    @Then("I should see the results")
    public void i_should_see_the_results () throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("search"));

    }
}
