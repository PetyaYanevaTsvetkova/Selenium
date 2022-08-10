package pages;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

/**
 * Child class: Chairs Page class with the necessary methods and locators
 */
public class ChairsPage extends BasePage {
    private static final String LOGIN_CHAIRS_URL = "http://localhost/category/chairs";
    private static final String CART_URL = "http://localhost/cart";

    By listView = By.className("fa-list-ul");
    By addToCart = By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div/div[3]/div/button");
    //By.tagName("p");
    //*[@id="root"]/div[4]/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div/p
    // By.xpath("//div/div[1]/div[2]/div[@class='row']//div[@class='shop-list-content']//button[@title='Add to cart']");
    //By.cssSelector("div:nth-of-type(1) > .mb-30.shop-list-wrap > .row > .col-md-7.col-sm-6.col-xl-8 > .shop-list-content > .align-items-center.d-flex.shop-list-actions > .shop-list-btn > button[title='Add to cart']");
    //By.xpath("//button[@title= 'Add to cart']");
    //;
    //div[3][@class= 'shop-list-actions']
    By productValue = By.className("cart-plus-minus-box");
    By increaseQntBtn = By.xpath("//button[text()='+']");
    By totalAmount = By.className("product-subtotal");

    public ChairsPage() throws MalformedURLException {
    }

    /**
     * Navigate to  ChairsPage
     */
    @Override
    public void navigateToPage() {
        remoteWebDriver.get(LOGIN_CHAIRS_URL);
        remoteWebDriver.manage().window().maximize();
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
