package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

public class Q04_Locators extends TestBaseEach {

    @Test
    public void test01() {

        // 1- https://www.testotomasyonu.com/ sayfasına gidin.
        driver.get("https://www.testotomasyonu.com/");

        // 2- Arama kutusuna “dress” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='global-search']"));

        aramaKutusu.sendKeys("dress" + Keys.ENTER);

        // 3- Görüntülenen sonuçların sayısını yazdırın
        String sonucSayisiStr = driver.findElement(By.xpath("//*[@*='product-count-text']")).getText();

        sonucSayisiStr = sonucSayisiStr.replaceAll("\\D", "");
        System.out.println("Goruntulenen Sonuc Sayisi : " + sonucSayisiStr);

        // 4- Listeden ilk urunun resmine tıklayın.
        driver.findElement(By.xpath("(//*[@*='prod-img'])[1]"))
                .click();

        // 5- Urun detayinda "dress" kelimesi geçtiğini test edin.
        WebElement urunDetayYazisi = driver.findElement(By.className("prod-detail"));

        String expectedUrunDetayIcerik = "dress";
        String actualUrunDetay = urunDetayYazisi.getText();

        Assertions.assertTrue(actualUrunDetay.contains(expectedUrunDetayIcerik));

    }

}
