package day12_excel_getScreenShot_jsExecutors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import java.io.IOException;

public class C07_MethodIleScreenshot extends TestBaseEach {

    @Test
    public void test01() {

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
        WebElement logoutButonElementi = driver.findElement(By.xpath("//span[.='Logout']"));

        Assertions.assertTrue(logoutButonElementi.isDisplayed());

        // Logout butonunun fotografini cekin
        // ReusableMethods.webElementScreenshotIsimli(logoutButonElementi, "loginTesti");
        // ReusableMethods.webElementScreenshotTarihli(logoutButonElementi);
        ReusableMethods.webElementScreenshotTarihVeIsimli(logoutButonElementi, "loginTesti");

        // Logout butonuna basarak sistemden cikis yapin
        logoutButonElementi.click();

    }

}


