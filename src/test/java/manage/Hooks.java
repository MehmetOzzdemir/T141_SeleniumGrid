package manage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utilities.ConfigReader;

public class Hooks {


    public static WebDriver driver;

    @Before
    public void driverSetup() {
        String browser = System.getProperty("browser", ConfigReader.getProperty("browser"));

        boolean isRemote = Boolean.parseBoolean(System.getProperty("isRemote", ConfigReader.getProperty("isRemote")));
        driver = DriverFactory.getDriver(browser, isRemote);

    }


    @After
    public void driverquit() {
        DriverFactory.quitDriver();
    }

}
