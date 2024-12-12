package day12_excel_getScreenShot_jsExecutors;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C08_JavaScriptExecutor extends TestBaseEach {

    @Test
    public void test01() {

        // https://testotomasyonu.com/form sayfasina gidiniz
        driver.get("https://testotomasyonu.com/form");

        // isitme kaybi checkbox gorunecek sekilde asagiya inin

            // 1. adim jse objesi olustur
        JavascriptExecutor jse = (JavascriptExecutor) driver;

            // 2. adim kullanmak istedigimiz WebElement'i locate edip kaydedin
        WebElement isitmeKaybiCheckBox = driver.findElement(By.id("hastalikCheck5"));

            // 3. adim jse.executeScript() ile istenen islemi yapin
        // jse.executeScript("arguments[0].scrollIntoView(true);", isitmeKaybiCheckBox);
        // bu kod webelementi gosterir ama tam ortalamaz

        jse.executeScript("arguments[0].scrollIntoView({block:'center'})", isitmeKaybiCheckBox);

        // jse kullanarak isitme kaybi checkbox'ini isaretleyin
        jse.executeScript("arguments[0].click();", isitmeKaybiCheckBox);

        jse.executeScript("alert('JUnit');");

    }

}
