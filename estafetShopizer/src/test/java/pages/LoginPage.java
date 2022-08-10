package pages;

import org.openqa.selenium.By;

import java.net.MalformedURLException;

/**
 * Child class: Login Page class with the necessary methods and locators
 */
public class LoginPage extends BasePage {
    private static final String LOGIN_PAGE_URL = "http://localhost/login";
    By cookies = By.id("rcc-confirm-button");
    By usernameEmailAddress = By.name("username");
    By password = By.name("loginPassword");
    By loginBtn = By.xpath("//span[1][text()='Login']");

    public LoginPage() throws MalformedURLException {
    }

    /**
     * Navigate to Login Page
     */
    @Override
    public void navigateToPage() {
        remoteWebDriver.get(LOGIN_PAGE_URL);
        remoteWebDriver.manage().window().maximize();
        remoteWebDriver.findElement(cookies).click();
    }

    /**
     * Set usernameEmail
     */
    public void setUsername(String strUsernameEmail) {
        waitElementToBeLoadedDOM(usernameEmailAddress).sendKeys(strUsernameEmail);
    }

    /**
     * Set Password
     */
    public void setPassword(String strPassword) {
        waitElementToBeLoadedDOM(password).sendKeys(strPassword);
    }

    /**
     * Click on login button
     */
    public void clickLogin() {
        waitElementBeClickable(loginBtn).click();
    }
}
