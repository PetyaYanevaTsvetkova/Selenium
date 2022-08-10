package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.TablesPage;
import java.net.MalformedURLException;

public class TablesSteps {
    private TablesPage tablesPage;

    @Given("Navigate to Table Page")
    public void navigateToTablePage() {
        try {
            tablesPage = new TablesPage();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        tablesPage.navigateToPage();
    }

    @Given("The products from Table Page are shown in table view. Chose option to show them in list")
    public void theProductsFromTablePageAreShownInTableViewChoseOptionToShowThemInList() {
        tablesPage.setListView();
    }

    @When("Add Table to Cart")
    public void addTableToCart() {
        tablesPage.setAddToCart();
    }

    @Then("Assert that the table is added successfully and the quantity is {}")
    public void assertThatTheTableIsAddedSuccessfullyAndTheQuantityIs(String expectedQty) {
        String actualQty = tablesPage.getValueOfProduct();
        Assertions.assertEquals(expectedQty, actualQty,
                String.format("Test fail: Expected quantity: %s is different from Actual: %s",
                        expectedQty, actualQty));
    }

    @And("Increase the amount in the cart by one more")
    public void increaseTheAmountInTheCartByOneMore() {
        tablesPage.increaseTheProductQntWithOneMore();
    }

    @And("Assert that the price is as expected {}")
    public void assertThatThePriceIsAsExpected(String expectedPrice) {
        String actualTotalPrice = tablesPage.getTotalAmount();
        Assertions.assertEquals(expectedPrice, actualTotalPrice,
                String.format("The Expected price: %s is different from tne Actual: %s", expectedPrice, actualTotalPrice));
    }


}
