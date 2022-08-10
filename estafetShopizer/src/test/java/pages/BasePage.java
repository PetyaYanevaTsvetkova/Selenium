package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.hook.Hooks;

import java.net.MalformedURLException;
import java.time.Duration;

/**
 * Parent class: Create instance of RemoteWebDriver and Wait
 */
public abstract class BasePage {
    public RemoteWebDriver remoteWebDriver;
    public WebDriverWait wait;

    /**
     * Constructor
     * Create instance of RemoteWebDriver and Wait
     */
    public BasePage() throws MalformedURLException {
        this.remoteWebDriver = Hooks.remoteWebDriver;
        this.wait = new WebDriverWait(remoteWebDriver, Duration.ofSeconds(5));
    }

    /**
     * An expectation for checking an element is visible and enabled such that you can click it.
     * @return - web element by locator
     */
    public WebElement waitElementBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page.
     * This does not necessarily mean that the element is visible.
     * @return - web element by locator
     */
    public WebElement waitElementToBeLoadedDOM(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Navigate to Page
     */
    public abstract void navigateToPage();

       /**
     * Browser Quit
     */
    public void browserQuit() {
        remoteWebDriver.quit();
    }
}
