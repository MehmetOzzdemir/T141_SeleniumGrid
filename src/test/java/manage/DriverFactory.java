package manage;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {
    static WebDriver driver;
    static Capabilities options;

    public static WebDriver getDriver(String browser, boolean isRemote) {

        if (isRemote) {
            return getRemoteDriver(browser);
        } else {
            return getLocalDriver(browser);
        }

    }

    private static WebDriver getRemoteDriver(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        switch (browser.toLowerCase()) {
            case "chrome":
                capabilities.setPlatform(Platform.ANY);
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("126.0.6478.127");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.merge(capabilities);
                options = chromeOptions;
                System.out.println("***** Remote Chrome Driver *****");
                break;
            case "firefox":
                capabilities.setPlatform(Platform.ANY);
                capabilities.setBrowserName("firefox");
                capabilities.setVersion("128.0");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.merge(capabilities);
                options = firefoxOptions;
                System.out.println("***** Remote Firefox Driver *****");
                break;
            case "edge":
                capabilities.setPlatform(Platform.ANY);
                capabilities.setBrowserName("edge");
                capabilities.setVersion("126.0.2592.87");
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.merge(capabilities);
                options = edgeOptions;
                System.out.println("***** Remote Edge Driver *****");
                break;

            case "ie":
                capabilities.setPlatform(Platform.ANY);
                capabilities.setBrowserName("ie");
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.merge(capabilities);
                options = internetExplorerOptions;
                System.out.println("***** Remote IE Driver *****");
                break;

        }
        try {
            driver = new RemoteWebDriver(new URL(ConfigReader.getProperty("remoteURL")), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;


    }

    private static WebDriver getLocalDriver(String browser) {


        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/browserDrivers/geckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                System.out.println("***** Local Firefox Driver *****");
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/browserDrivers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                System.out.println("***** Local Chrome Driver *****");
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/test/resources/browserDrivers/msedgedriver.exe");
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                System.out.println("***** Local Edge Driver *****");
                break;

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();


        return driver;


    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


}
