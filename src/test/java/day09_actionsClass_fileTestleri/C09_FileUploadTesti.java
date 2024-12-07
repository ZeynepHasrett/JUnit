package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C09_FileUploadTesti extends TestBaseEach {

    @Test
    public void test01() {

        // 1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        // 2.chooseFile butonuna basalim
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        // 3.Yuklemek istediginiz dosyayi secelim.
        String hedefDosyaYolu = System.getProperty("user.home") + "\\Downloads\\deneme.txt";

        chooseFileButonu.sendKeys(hedefDosyaYolu);

        // 4.Upload butonuna basalim.
        driver.findElement(By.id("file-submit"))
                .click();

        // 5.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement sonucYazisi = driver.findElement(By.tagName("h3"));

        Assertions.assertTrue(sonucYazisi.isDisplayed());

    }

}
