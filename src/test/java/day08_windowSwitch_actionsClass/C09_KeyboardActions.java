package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C09_KeyboardActions extends TestBaseEach {

    @Test
    public void test01() {

        // 1- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");

        //2- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin
        //   ve Enter’a basarak arama yaptirin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        WebElement aramaKutusuElementi = driver.findElement(By.id("global-search"));

        actions.click(aramaKutusuElementi)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER).perform();

        //3- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
        String expectedUrunIsmi = "DELL Core I3";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']")).getText();

        Assertions.assertTrue(actualUrunIsmi.contains(expectedUrunIsmi));

    }

}
