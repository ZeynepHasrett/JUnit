package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.stylesheets.LinkStyle;
import utilies.TestBaseEach;

import java.util.List;

public class C05_IFrame extends TestBaseEach {

    @Test
    public void test01() {
        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        // 2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iframeListesi = driver.findElements(By.tagName("iframe"));

        System.out.println("Sayfadaki iframe sayisi : " + iframeListesi.size());

        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        driver.switchTo().frame(iframeListesi.get(0));

        WebElement playTusu = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        playTusu.click();

        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        // 5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        driver.switchTo().frame(iframeListesi.get(1));

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        driver.findElement(By.tagName("a"))
                .click();

    }

}
