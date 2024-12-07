package day09_actionsClass_fileTestleri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C05_Actions extends TestBaseEach {

    @Test
    public void test01() {

        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        WebElement hoverMeKutusu = driver.findElement(By.xpath("//*[.='Hover Over Me First!']"));

        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        actions.moveToElement(hoverMeKutusu).perform();

        // 3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();

        // 4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo()
                .alert()
                .accept();

        // 6- “Click and hold" kutusuna basili tutun
        WebElement clickBoxElementi = driver.findElement(By.id("click-box"));

        actions.clickAndHold(clickBoxElementi).perform();

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickBoxElementi.getText());

        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClickMeButonu = driver.findElement(By.id("double-click"));

        actions.doubleClick(doubleClickMeButonu).perform();

        // cift tiklandigini test edin
        String expectedClassAttributeDegeri = "div-double-click double";
        String actualClassAttributeDegeri = doubleClickMeButonu.getAttribute("class");

        Assertions.assertEquals(expectedClassAttributeDegeri, actualClassAttributeDegeri);

    }

}
