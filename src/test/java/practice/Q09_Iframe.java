package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

public class Q09_Iframe extends TestBaseEach {

    @Test
    public void test01() {

        // 1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        // 2. “Our Products” butonuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe"));

        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//*[text()='Our Products']"))
                .click();

        // 3. “Cameras product”i tiklayin
        driver.findElement(By.id("container-product1"))
                .click();

        // 4. Popup mesajini yazdirin
        WebElement popupMesaji = driver.findElement(By.className("modal-content"));

        System.out.println(popupMesaji.getText());

        // 5. “close” butonuna basin
        driver.findElement(By.xpath("//*[.='Close']"))
                .click();

        // 6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();

        driver.findElement(By.linkText("WebdriverUniversity.com (IFrame)"))
                .click();

        // 7. "https://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl = "https://webdriveruniversity.com/index.html";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expectedUrl, actualUrl);

    }

}
