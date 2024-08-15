package stepDefinitions;

import manage.DriverManage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Grid_02 {

    DriverManage driverManage = new DriverManage();

    static WebDriver driver ;


    @Test
    void chromeTest(){

        driver = driverManage.setupChromeDriver();

        driver.get("https://www.ebay.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test
    void firefoxTest(){
        driver = driverManage.setupFirefoxDriver();

        driver.get("https://www.youtube.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

    @Test
    void edgeTest(){
        driver = driverManage.setupEdgeDriver();

        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}
