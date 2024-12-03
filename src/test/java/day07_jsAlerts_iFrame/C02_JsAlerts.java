package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

public class C02_JsAlerts extends TestBaseEach {

//    3 test method'u olusturup asagidaki gorevi tamamlayin

/*
    Bir Webelement'e click yaptigimizda
    driver objesi ortam degisikligi beklemez

    ayni window'da kalip farkli bir url'e gitmeyi bekler

    ANCAK bazi islemler yapildiginda
    farkli bir ortam olusabilir

    driver'i bu farkli ortama gecirmek icin
    driver.switchTo() kullanmamiz gerekir

    Bu durumlardan birisi JavaScript alert'lerdir
    jsAlert calistiginda normal window uzerinde islem yapamayiz
    sag tus yapip locate alamadigimiz icin alert uzerinde driver'i calistiramayiz

    driver'in jsAlert'e gecmesi ve orada islem yapabilmesi icin oncelikle
    jsAlert evrenine switch yapmasi gerekir
 */

    @Test
    public void jsAlertsTest() {
        //    1. Test
        //    -  https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //            - 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']"))
                .click();

        //            -  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedAlertYazi = "I am a JS Alert";
        String actualAlertYazi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedAlertYazi, actualAlertYazi);

    //            -  OK tusuna basip alert'i kapatin
        driver.switchTo()
                .alert()
                .accept();

    }

    @Test
    public void jsConfirmTest() {
        //    2.Test
        //    - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //            - 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']"))
                .click();

        //            - Cancel'a basip,
        driver.switchTo()
                .alert()
                .dismiss();

        // cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.id("result"));

        String expectedSonucYazisi = "You clicked: Cancel";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi, actualSonucYazisi);

    }

    @Test
    public void jsPromptTest() {
        //    3.Test
        //    - https://testotomasyonu.com/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu.com/javascriptAlert");

        //            - 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']"))
                .click();

        //            - Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo()
                .alert()
                .sendKeys("Abdullah");

        //    - OK tusuna basarak alert'i kapatalim
        driver.switchTo()
                .alert()
                .accept();

        //    - Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.id("result"));

        String expectedSonucYazisiIcerik = "Abdullah";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assertions.assertTrue(actualSonucYazisi.contains(expectedSonucYazisiIcerik));

    }

}
