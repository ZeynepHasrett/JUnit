package practice;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

import java.util.List;

public class C09_Iframe extends TestBaseEach {

    @Test
    public void iframeTesti() {
        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        // 2) Cookies kabul edin
        // 3) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeList = driver.findElements(By.xpath("//iframe"));

        int iframesayisi = iframeList.size();

        // 4) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iframe1 = driver.findElement(By.xpath("(//iframe)[1]"));

        driver.switchTo().frame(iframe1);

        driver.findElement(By.xpath("//*[@title='Oynat']"))
                .click();

        // 5) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        // 6) ikinci iframe'deki (Jmeter Made Easy) linke
        // (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement iframe2 = driver.findElement(By.xpath("(//iframe)[2]"));

        driver.switchTo().frame(iframe2);

        driver.findElement(By.xpath("//*[@*='Jmeter720.png']"))
                .click();

    }

}
