package day08_windowSwitch_actionsClass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C08_Actions_MoveToElement extends TestBaseEach {

    @Test
    public void test01() {

        // 1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        // 2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        WebElement kidswearElementi = driver.findElement(By.xpath("//*[@class='has-sub'][7]"));

        actions.moveToElement(kidswearElementi).perform();

        // 3- “Boys” linkine basin
        driver.findElement(By.xpath("//*[.='Boys']")).click();

        // 4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]")).click();

        // 5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        WebElement urunIsımElementi = driver.findElement(By.xpath("//*[@class=' heading-sm mb-4']"));

        String expectedUrunIsmi = "Boys Shirt White Color";
        String actualUrunIsmi = urunIsımElementi.getText();

        Assertions.assertEquals(expectedUrunIsmi, actualUrunIsmi);

    }

}
