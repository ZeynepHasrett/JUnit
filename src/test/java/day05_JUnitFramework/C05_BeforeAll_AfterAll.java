package day05_JUnitFramework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.security.Key;
import java.time.Duration;
import java.util.List;

public class C05_BeforeAll_AfterAll {

    // 3 farkli test method'u olusturarak asagidaki testleri gerceklestirin
    // 1- Test otomasyonu anasayfaya gidin
    //    Url'in test otomasyonu icerdigini test edin
    // 2- phone icin arama yapin
    //    ve arama sonucunda urun bulunabildigini test edin
    // 3- ilk urunu tiklayin
    //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin

    /*
        Bu gorev icin
        her test method'undan sonra driver'i kapatmak (@AfterEach) mantikli olmaz

        bunun yerine
        class calismaya basladiginda hicbir method calismadan once driver'i olusturmak
        ve tum @Test method'lari calisip bittikten sonra
        calisacak @Test method'u kalmadiginda
         driver'i kapatmak daha mantikli olur

         Bu tur birbirinin sonucuna bagli test method'lari oldugunda
         JUnit ile method'lari tek tek run edebiliriz
         ancak method'un yapmasi gereken islevi yapmasi mumkun olmayabilir

         @BeforeAll ve @afterAll notasyonu kullanan method'larin
         mutlaka static olmasi gerekir
     */

    static WebDriver driver;

    @BeforeAll
    static void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterAll
    static void teardown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // anasayfaTesti
        // 1- Test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)) {
            System.out.println("Anasayfa testi PASSED");
        } else System.out.println("Anasayfa testi FAILED");
    }

    @Test
    public void test02() {
        // urunAramaTesti
        // 2- phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        // ve arama sonucunda urun bulunabildigini test edin
        List<WebElement> bulunanUrunElementleriList = driver.findElements(By.xpath("//*[@*='prod-img']"));

        int actualBulunanUrunSayisi = bulunanUrunElementleriList.size();

        if (actualBulunanUrunSayisi > 0) {
            System.out.println("Urun bulma testi PASSED");
        } else System.out.println("Urun bulma testi FAILED");
    }

    @Test
    public void test03() {
        // ilkUrunIsimTesti
        // 3- ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();

        //    ve acilan sayfadaki urun isminde case sensitive olmadan "phone" bulundugunu test edin
        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        if (actualUrunIsmi.contains(expectedUrunIsimIcerik)) {
            System.out.println("Ilk urun isim testi PASSED");
        } else System.out.println("Ilk urun isim testi FAILED");
    }

}
