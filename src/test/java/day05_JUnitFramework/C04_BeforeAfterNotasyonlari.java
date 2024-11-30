package day05_JUnitFramework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilies.ReusableMethods;

import java.time.Duration;

public class C04_BeforeAfterNotasyonlari {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        // Webdriver olusturup ayarlari yapin
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {
        ReusableMethods.bekle(2);
        driver.quit();
    }

    @Test
    public void testOtomasyonuTest() {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Testotomasyonu Testi PASSED");
        } else System.out.println("Testotomasyonu Testi FAILED");

    }

    @Test @Disabled
    public void youtubeOtomasyonuTest() {

        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        // url'in youtube icerdigini test edin
        String expectedUrlIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("youtube Testi PASSED");
        } else System.out.println("youtube Testi FAILED");

    }

    @Test
    public void wisequarterTest() {

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        // url'in wisequarter icerdigini test edin
        String expectedUrlIcerik = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("wisequarter Testi PASSED");
        } else System.out.println("wisequarter Testi FAILED");

    }


}
