package day12_excel_getScreenShot_jsExecutors;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C06_WebElementScreenshot extends TestBaseEach {

    @Test
    public void test01() throws IOException {

        // testotomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // account linkine tiklayin
        driver.findElement(By.xpath("//span[.='Account']"))
                .click();

        // kullanici adi olarak wise@gmail.com girin
        driver.findElement(By.id("email")).sendKeys("wise@gmail.com");

        // password olarak 12345 girin
        driver.findElement(By.id("password")).sendKeys("12345");

        // sign in butonuna basarak sisteme giris yapin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();

        driver.findElement(By.id("submitlogin"))
                .click();

        // giris yapilabildigini test etmek icin
        // Logout butonunun gorunur oldugunu test edin
        actions.sendKeys(Keys.TAB).perform();

        WebElement logoutButonElementi = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonElementi.isDisplayed());
        ReusableMethods.bekle(2);

        // Logout butonunun fotografini cekin

        // 1.adim screenshot alacagimiz webelementi locate edip kaydedelim
        //        biz yukarda Logout butonunu locate ettik

        // 2.adim resmi kaydedecegimiz File'i olusturalim
        File asilResim = new File("target/screenshots/webElementScreenshot.jpeg");

        // 3.adim webElement'i kullanarak screenshot'i alip gecici bir dosya olarak kaydedelim
        File geciciDosya = logoutButonElementi.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim
        FileUtils.copyFile(geciciDosya, asilResim);

        // Logout butonuna basarak sistemden cikis yapin
        logoutButonElementi.click();

    }

}
