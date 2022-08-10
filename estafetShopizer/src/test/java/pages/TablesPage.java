package pages;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

/**
 * Child class: Tables Page class with the necessary methods and locators
 */
public class TablesPage extends BasePage {
    private static final String TABLES_PAGE_URL = "http://localhost/category/tables";
    private static final String CART_URL = "http://localhost/cart";
    By cookies = By.xpath("//*[@id=\"rcc-confirm-button\"]");
    By listView = By.className("fa-list-ul");
    By addToCart = By.xpath("//*[@id=\"root\"]/div[3]/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div/div[3]/div/button");
    // By.xpath("//button[1][text()='Add to cart']");
    //By.xpath("//*[@id=\"root\"]/div[3]/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div/div[3]/div/button");
    By productValue = By.className("cart-plus-minus-box");
    By increaseQntButton = By.xpath("//button[text()='+']");
    By totalAmount = By.className("product-subtotal");

    public TablesPage() throws MalformedURLException {
    }

    /**
     * Navigate to Tables Page
     */
    @Override
    public void navigateToPage() {
        remoteWebDriver.get(TABLES_PAGE_URL);
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
     * Add to cart
     */
    public void setAddToCart() {
        waitElementBeClickable(addToCart).click();
        //remoteWebDriver.findElement(addToCart).click();
    }

    /**
     * Go To Cart
     */
    public String getValueOfProduct() {
        remoteWebDriver.get(CART_URL);
        return waitElementToBeLoadedDOM(productValue).getAttribute("value");
        //remoteWebDriver.findElement(productValue).getAttribute("value");
    }

    /**
     * Increase The Product Qnt With One More
     */
    public void increaseTheProductQntWithOneMore() {
        waitElementBeClickable(increaseQntButton).click();
        //remoteWebDriver.findElement(increaseQntButton).click();
    }

    /**
     * Get the Total Amount
     */
    public String getTotalAmount() {
        return waitElementToBeLoadedDOM(totalAmount).getText();
    }
}

