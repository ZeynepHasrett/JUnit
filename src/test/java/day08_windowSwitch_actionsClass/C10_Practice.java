package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C10_Practice extends TestBaseEach {

    @Test
    public void test01() {

        // https://testotomasyonu.com/click sayfasina gidin.
        driver.get("https://testotomasyonu.com/click");

        // "Double Click" ve "Don't release me!" yazilarinin gorunur oldugunu kontrol edin.
        WebElement doubleClickElementi = driver.findElement(By.xpath("//*[@id='btn1']"));
        Assertions.assertTrue(doubleClickElementi.isDisplayed());

        WebElement dontReleaseMeElementi = driver.findElement(By.id("btn2"));
        Assertions.assertTrue(dontReleaseMeElementi.isDisplayed());

        // "Double Click" üzerine cift tıklayarak renginin degistiğini kontrol edin.
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.doubleClick(doubleClickElementi).perform();
        
        WebElement doubleClickSonrasiElement = driver.findElement(By.xpath("//*[@class='mystyle']"));
        Assertions.assertTrue(doubleClickSonrasiElement.isDisplayed());
        
        // "Don't release me!" uzerine gelerek basili tutun. "Well done yazisinin gorunur oldugunu kontrol edin.



    }

}

/*
        //https://testotomasyonu.com/click sayfasına gidin.
        driver.get("https://testotomasyonu.com/click");

        ReusableMethods.bekle(1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);

        //double click ve don't release me yazılarının görünürlülüğünü kontrol ediniz.

        WebElement doubleClickYazisi = driver.findElement(By.xpath("//*[@id='btn1']"));
        WebElement releaseMeYazisi = driver.findElement(By.id("btn2"));

        Assertions.assertTrue(doubleClickYazisi.isDisplayed());
        Assertions.assertTrue(releaseMeYazisi.isDisplayed());
        ReusableMethods.bekle(1);

        //Double click' üzerine çift tıkla ve renginin değiştiğini kontrol et.
        actions.doubleClick(doubleClickYazisi).perform();
        ReusableMethods.bekle(1);

        WebElement basiliDoubleClick = driver.findElement(By.xpath("//*[@class='mystyle']"));
        Assertions.assertTrue(basiliDoubleClick.isDisplayed());
        ReusableMethods.bekle(1);

        //don't release me üzerine gel ve basılı tut. Well done yazısının görünür olduğunu kontrol ediniz.
        actions.clickAndHold(releaseMeYazisi).perform();
        ReusableMethods.bekle(3);

        WebElement WellDoneYazisi = driver.findElement(By.xpath("//*[text()='Well done!.....']"));
        Assertions.assertTrue(WellDoneYazisi.isDisplayed());

        ReusableMethods.bekle(3);

    }

}
 */

