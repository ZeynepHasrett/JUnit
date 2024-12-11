package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.TestBaseEach;

import java.util.Set;

public class Q10_WindowHandle extends TestBaseEach {

    @Test
    public void test01() {

        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        String ilkWindowWhd = driver.getWindowHandle();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[.='LOGIN PORTAL']"))
                .click();

        //4.Diger window'a gecin
        Set<String> tumWindowWhd = driver.getWindowHandles();

        String ikinciWindowWhd = "";

        for (String eachWhd : tumWindowWhd){
            if (!eachWhd.equals(ilkWindowWhd)){
                ikinciWindowWhd = eachWhd;
            }
        }

        driver.switchTo().window(ikinciWindowWhd);

        //5."username" ve "password" kutularina deger yazdirin
        driver.findElement(By.id("text")).sendKeys("Zeynep");
        driver.findElement(By.id("password")).sendKeys("Hasret");

        //6."login" butonuna basin
        driver.findElement(By.id("login-button"))
                .click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String expectedPopupYazisi = "validation failed";
        String actualPopupYazisi = driver.switchTo().alert().getText();

        Assertions.assertEquals(expectedPopupYazisi, actualPopupYazisi);

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkWindowWhd);

        //10.Ilk sayfaya donuldugunu test edin
        Assertions.assertEquals(ilkWindowWhd, driver.getWindowHandle());

    }

}
