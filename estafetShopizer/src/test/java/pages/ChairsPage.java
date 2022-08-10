package pages;
import org.openqa.selenium.By;
import java.net.MalformedURLException;

/**
 * Child class: Chairs Page class with the necessary methods and locators
 */
public class ChairsPage extends BasePage {
    private static final String LOGIN_CHAIRS_URL = "http://localhost/category/chairs";
    private static final String CART_URL = "http://localhost/cart";
    By cookies = By.xpath("//*[@id=\"rcc-confirm-button\"]");
    By listView = By.className("fa-list-ul");
    By addToCart = By.xpath("//p[.='Chair from Thailand']//../div/div/button");
    By productValue = By.className("cart-plus-minus-box");
    By increaseQntBtn = By.xpath("//button[text()='+']");
    By totalAmount = By.className("product-subtotal");

    public ChairsPage() throws MalformedURLException {
    }

    /**
     * Navigate to ChairsPage
     */
    @Override
    public void navigateToPage() {
        remoteWebDriver.get(LOGIN_CHAIRS_URL);
        remoteWebDriver.manage().window().maximize();
        remoteWebDriver.findElement(cookies).click();
    }

    /**
     * Set List View
     */
    public void setListView() {
        waitElementBeClickable(listView).click();
    }

    /**
     * Add chair to cart
     */
    public void setAddToCart() {
     waitElementBeClickable(addToCart).click();
    }

    /**
     * Go To Cart
     */
    public Integer getValueOfProduct() {
        remoteWebDriver.get(CART_URL);
        String quantity = waitElementToBeLoadedDOM(productValue).getAttribute("value");
        return Integer.parseInt(quantity);
    }

    /**
     * Increase The Product Qnt With One More
     */
    public void increaseTheProductQntWithOneMore() {
        waitElementBeClickable(increaseQntBtn).click();
    }

    /**
     * Get the Total Amount
     */
    public String getTotalAmount() {
        return waitElementToBeLoadedDOM(totalAmount).getText();
    }
}
