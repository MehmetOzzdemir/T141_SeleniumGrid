package stepDefinitions;

import io.cucumber.java.en.Given;
import manage.Hooks;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Youtube {


    WebDriver driver = Hooks.driver;

    @Given("Kullanici youtube anasayfasina gider")
    public void kullanici_youtube_anasayfasina_gider() {
        driver.get("https://www.youtube.com");

    }

    @Given("title {string} olduguğu kontrol eder")
    public void title_olduguğu_kontrol_eder(String title) {
        String actualTitle = driver.getTitle();
        String expectedTitle = title;
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Given("sayfayi kapatir")
    public void sayfayi_kapatir() {


    }
}
