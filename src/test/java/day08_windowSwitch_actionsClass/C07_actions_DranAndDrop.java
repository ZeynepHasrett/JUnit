package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C07_actions_DranAndDrop extends TestBaseEach {

    @Test
    public void test01() {

        // 1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        // 2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        WebElement acceptableButonElementi = driver.findElement(By.id("draggable2"));
        WebElement dropHereElementi = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(acceptableButonElementi, dropHereElementi).perform();

        // 3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement yaziElementi = driver.findElement(By.xpath("//*[text()='Dropped!']"));

        String expectedYazi = "Dropped!";
        String actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

        // 4- Sayfayi yenileyin
        driver.navigate().refresh();

        // 5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableButonElementi = driver.findElement(By.xpath("//*[text()='Not Acceptable']"));
        dropHereElementi = driver.findElement(By.id("droppable2"));

        actions.dragAndDrop(notAcceptableButonElementi, dropHereElementi).perform();

        // 6- “Drop Here” yazisinin degismedigini test edin
        yaziElementi = driver.findElement(By.xpath("//p[.='Drop Here']"));

        expectedYazi = "Drop Here";
        actualYazi = yaziElementi.getText();

        Assertions.assertEquals(expectedYazi, actualYazi);

    }

}
