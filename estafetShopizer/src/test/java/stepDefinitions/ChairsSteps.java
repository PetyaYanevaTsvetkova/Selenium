package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.ChairsPage;

import java.net.MalformedURLException;

public class ChairsSteps {
    private ChairsPage chairsPage;

    @Given("Navigate to Chairs Page")
    public void navigateToChairsPage() {
        try {
            chairsPage = new ChairsPage();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        chairsPage.navigateToPage();
    }

    @Given("The products from Chairs Page are shown in table view. Chose option to show them in list")
    public void choseOptionListView() {
        chairsPage.setListView();
    }

    @When("Add Chair to Cart")
    public void addChairToCart() {
        chairsPage.setAddToCart();
    }

    @Then("Assert that the chair is added successfully and the quantity is {int}")
    public void assertThatTheChairIsAddedSuccessfully(Integer expectedQty) {
        Integer actualQty = chairsPage.getValueOfProduct();
        Assertions.assertEquals(expectedQty, actualQty,
                String.format("Test fail: Expected quantity: %d is different from Actual: %d",
                        expectedQty, actualQty));
    }

    @And("Increase the amount of chairs in the cart by one more")
    public void increaseTheAmountOfChairsInTheCartByOneMore() {
        chairsPage.increaseTheProductQntWithOneMore();
    }

    @And("Assert that the price of chairs is as expected {}")
    public void assertThatThePriceOfChairsIsAsExpected(String expectedPrice) {
        String actualTotalPrice = chairsPage.getTotalAmount();
        Assertions.assertEquals(expectedPrice, actualTotalPrice,
                String.format("The Expected price: %s is different from tne Actual: %s", expectedPrice, actualTotalPrice));
    }
}
