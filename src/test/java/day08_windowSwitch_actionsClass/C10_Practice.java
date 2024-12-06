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

        // "Don't release me!" uzerine gelerek basili tutun. "Well done!....." yazisinin gorunur oldugunu kontrol edin.
        actions.clickAndHold(dontReleaseMeElementi).perform();

        WebElement wellDoneYaziElementi = driver.findElement(By.xpath("//*[text()='Well done!.....']"));
        Assertions.assertTrue(wellDoneYaziElementi.isDisplayed());

    }

}


