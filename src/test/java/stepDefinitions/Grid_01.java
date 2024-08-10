package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Grid_01 {

    static WebDriver driver;

    public static void main(String[] args) throws MalformedURLException {

        driver = new RemoteWebDriver(new URL("http://192.168.1.68:4444"), new ChromeOptions());

        //Ust satirda class seviyesinde create ettigimiz driver in icerisine RemoteWebDriver sset edilmesi atamasi yapildi
        //Herhangi spesifik bir capabilities girmedik onun yerine Node icinde var olan Chrome browser ile calis dedik

        //Asagiya test kodlarini yazdik
        driver.get("https://www.wisequarter.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


    }

    @Test
    void firefoxTest() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.1.68:4444"), new FirefoxOptions());

        driver.get("https://qa.flavorfetch.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

    }
}
