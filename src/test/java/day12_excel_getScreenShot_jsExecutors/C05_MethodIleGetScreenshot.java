package day12_excel_getScreenShot_jsExecutors;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import java.io.File;

public class C05_MethodIleGetScreenshot extends TestBaseEach {

    @Test
    public void test01() {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone icin arama yapin
        driver.findElement(By.id("global-search")).sendKeys("phone" + Keys.ENTER);

        // arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unexpectedAramaSonucu = "0 Products Found";
        String actualAramaSonucu = aramaSonucElementi.getText();

        Assertions.assertNotEquals(unexpectedAramaSonucu, actualAramaSonucu);

        // tum sayfa screenshot alin
        // ReusableMethods.tumSayfaScreenshotIsimli(driver, "aramaTesti");
        // ReusableMethods.tumSayfaScreenshotTarihli(driver);
        ReusableMethods.tumSayfaScreenshotIsimVeTarihli(driver, "aramaTesti");

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='prod-img'])[1]"))
                .click();

        // acilan sayfadaki urun isminde case sensitive olmadan phone bulundugunu test edin
        WebElement ilkUrunIsimElementi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));

        String expectedUrunIsimIcerik = "phone";
        String actualUrunIsmi = ilkUrunIsimElementi.getText().toLowerCase();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsimIcerik));

        // sayfanin fotografini cekin
        // ReusableMethods.tumSayfaScreenshotIsimli(driver, "ilkUrunIsimTesti");
        // ReusableMethods.tumSayfaScreenshotTarihli(driver);
        ReusableMethods.tumSayfaScreenshotIsimVeTarihli(driver, "C05_MethodIleGetScreenshot");

    }

}
