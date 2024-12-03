package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilies.TestBaseEach;

public class C01_HTML_Alerts extends TestBaseEach {

    @Test
    public void test01() {
        // youtube.com anasayfaya gidin
        driver.get("https://www.google.com");

        // cookies kabul edin
        driver.findElement(By.xpath("//div[text()='Accept all']"))
                .click();

    }

}
