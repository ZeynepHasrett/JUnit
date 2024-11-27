package day04_mavenProjeKullanimi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilies.ReusableMethods;

import java.time.Duration;

public class C01_MavenIlkTestOtomasyonu {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");


        // phone icin arama yapin


        // arama sonucunda urun bulunabildigini test edin


        // sayfayi kapatin
        ReusableMethods.bekle(3);
        driver.quit();

    }

}
