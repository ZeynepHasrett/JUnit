package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

import javax.swing.*;
import java.util.Set;

public class C11_Practice extends TestBaseEach {

    @Test
    public void test01() {

        // 1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

        // 2- Elektronics Products yazisinin gorunur oldugunu test edin
        WebElement iframe1 = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iframe1);

        WebElement electronicsProductsYaziElementi = driver.findElement(By.tagName("h2"));
        Assertions.assertTrue(electronicsProductsYaziElementi.isDisplayed());

        // 3- Dell bilgisayar urun isminin 'DELL Core I3 11th Gen' oldugunu test edin
        WebElement dellUrunIsimElementi = driver.findElement(By.id("pictext1"));

        String expectedUrunIsmi = "DELL Core I3 11th Gen";
        String actualUrunIsmi = dellUrunIsimElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi, actualUrunIsmi);

        // 4- Dell bilgisayar'a tiklayip acilan sayfada urun fiyatinin $399.00 oldugunu test edin.
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        String ilkWindowWhd = driver.getWindowHandle();

        driver.findElement(By.id("pic1_thumb"))
                .click();

        Set<String> tumWindowsWhd = driver.getWindowHandles();
        String ikinciWindowWhd = "";

        for (String eachWhd : tumWindowsWhd) {
            if (!ilkWindowWhd.equals(eachWhd)) {
                ikinciWindowWhd = eachWhd;
            }
        }

        driver.switchTo().window(ikinciWindowWhd);

        WebElement fiyatElementi = driver.findElement(By.id("priceproduct"));

        String expectedFiyat = "$399.00";
        String actualFiyat = fiyatElementi.getText();

        Assertions.assertEquals(expectedFiyat, actualFiyat);

        // 5- Ilk window'a donun ve Fashion yazisinin gorunur oldugunu test edin
        driver.switchTo().window(ilkWindowWhd);

        WebElement iframe2 = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo().frame(iframe2);

        WebElement fashionYaziElementi = driver.findElement(By.tagName("h2"));

        Assertions.assertTrue(fashionYaziElementi.isDisplayed());

    }

}


