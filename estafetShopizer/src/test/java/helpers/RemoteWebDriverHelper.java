package helpers;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * Creates instance of RemoteWebDriver through Singleton Design Pattern
 */
public class RemoteWebDriverHelper {
    private static final String DRIVER_URL = "http://localhost:4545";

    private RemoteWebDriverHelper() {
    }
    public static RemoteWebDriver getInstanceRemoteWebDriver() throws MalformedURLException {
        return new RemoteWebDriver(new URL(DRIVER_URL), new ChromeOptions());
    }
}
