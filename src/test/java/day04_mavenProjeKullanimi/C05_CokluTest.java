package day04_mavenProjeKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilies.ReusableMethods;

import java.time.Duration;

public class C05_CokluTest {

    public static void main(String[] args) {

        testOtomasyonuTest();

    }

    public static void testOtomasyonuTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Testotomasyonu Testi PASSED");
        } else System.out.println("Testotomasyonu Testi FAILED");

        driver.quit();

    }

}