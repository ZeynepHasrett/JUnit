package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

public class C03_BasicAuthentication extends TestBaseEach {

    @Test
    public void test01() {
        // 1- https://testotomasyonu.com/basicauth sayfasina gidin
        // 2- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //      Html komutu : https://username:password@URL
        //      Username    : membername
        //      password     : sunflower

        // driver.get("https://testotomasyonu.com/basicauth");
        // sadece url'e gidersek UI ile kullanici adi ve sifre girmemiz gerekir
        // ancak otomasyon ile gittigimizde
        // kullanici adi ve sifresi bolumunu locate edemedigimizden kullanamayiz
        // bunun yerine kullandigimiz url'in sahibi olan sirketin
        // bize verecegi kullanici adi ve sifresini
        // yine sirketin bize tarif edecegi yontemle URL'e eklemeliyiz

        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        // 3- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[text()='Congratulations! You are logged in as: membername']"));

        Assertions.assertTrue(sonucYaziElementi.isDisplayed());

    }

}