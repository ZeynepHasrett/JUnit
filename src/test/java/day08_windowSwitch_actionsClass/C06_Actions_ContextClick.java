package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C06_Actions_ContextClick extends TestBaseEach {

    @Test
    public void test01(){

        // 1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1); // sayfa kodlarinin yuklenmesi icin zaman taniyoruz

        WebElement dgiDronesElementi = driver.findElement(By.id("pic2_thumb"));

        actions.contextClick(dgiDronesElementi).perform();

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedAlertYazisi = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertYazisi = driver
                                        .switchTo()
                                        .alert()
                                        .getText();

        Assertions.assertEquals(expectedAlertYazisi, actualAlertYazisi);

        //4- Tamam diyerek alert’i kapatalim
        driver
                .switchTo()
                .alert()
                .accept();

    }

}
