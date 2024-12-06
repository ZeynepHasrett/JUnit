package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import java.util.Set;

public class C01_WindowDegistirme extends TestBaseEach {

    @Test
    public void test01() {

        // https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        // Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement textElementi = driver.findElement(By.tagName("h2"));

        String expectedSayfaYazisi = "Add/Remove Elements";
        String actualSayfaYazisi = textElementi.getText();

        Assertions.assertEquals(expectedSayfaYazisi, actualSayfaYazisi);

        // Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedSayfaYazisi, actualSayfaYazisi);

        String ilkWindowWhd = driver.getWindowHandle();

        // ’Please click for Electronics Products’ linkine tiklayin.
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.xpath("//*[.='Electronics Products']"))
                .click();

        // Electronics sayfasinin acildigini test edin
        String ikinciWindowWhd = "";

        Set<String> tumWhd = driver.getWindowHandles();

        for (String eachWhd : tumWhd) {
            if (!eachWhd.equals(ilkWindowWhd)) {
                ikinciWindowWhd = eachWhd;
            }
        }

        driver.switchTo().window(ikinciWindowWhd);

        String expectedUrl = "https://testotomasyonu.com/category/7/products";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl, actualUrl);

        // Bulunan urun sayisinin 16 olduğunu test edin
        WebElement sonucYazisiElementi = driver.findElement(By.xpath("//*[text()='16 Products Found']"));

        String sonucYazisi = sonucYazisiElementi.getText();

        sonucYazisi = sonucYazisi.replaceAll("\\D", "");

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = Integer.parseInt(sonucYazisi);

        Assertions.assertEquals(expectedUrunSayisi, actualUrunSayisi);

        // Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkWindowWhd);

        // Url’in addremove icerdigini test edin
        String expectedUrlIcerik = "addremove";
        actualUrl = driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));

    }

}
