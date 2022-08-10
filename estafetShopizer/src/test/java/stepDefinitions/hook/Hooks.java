package stepDefinitions.hook;
import helpers.RemoteWebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;

/**
 * Helper class: use @Before and @After for launching and closing a browser
 */
public class Hooks {
public static RemoteWebDriver remoteWebDriver;

    @Before
    public void setupBrowser() {
        try {
            remoteWebDriver = RemoteWebDriverHelper.getInstanceRemoteWebDriver();
                 } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @After
    public void quitBrowser() {
        remoteWebDriver.manage().deleteAllCookies();
        remoteWebDriver.quit();
    }
}
