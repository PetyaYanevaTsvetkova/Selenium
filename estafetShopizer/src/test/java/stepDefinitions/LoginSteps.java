package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;

import java.net.MalformedURLException;

public class LoginSteps {
    private LoginPage loginPage;

    @Given("Navigate to Login Page")
    public void navigateToLoginPage(){
        try {
            loginPage = new LoginPage();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        loginPage.navigateToPage();
    }

    @Given("Username {} and Password {}")
    public void UsernamePassword(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @When("Try to Login")
    public void tryToLoginWithUsernameUsernameAndPasswordPassword() {
        loginPage.clickLogin();
    }

    @Then("Assert you are Logged in successfully and you are redirect to {} url")
    public void assertYouAreLoggedInSuccessfullyAndYouAreRedirectToHttpLocalhostMyAccountUrl(String expectedUrl) throws InterruptedException {
        Thread.sleep(500);
        String actualUrl = loginPage.remoteWebDriver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl,
                "Test fail: you logged in with incorrect credentials.");
    }

    @Then("Assert you are NOT Logged in successfully and you are still in {} url")
    public void assertYouAreNOTLoggedInSuccessfullyAndYouAreStillInHttpLocalhostLoginUrl(String expectedUrl) throws InterruptedException {
        String actualUrl = loginPage.remoteWebDriver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl, actualUrl,
                "Test fail: you logged in with incorrect credentials.");
    }


}
