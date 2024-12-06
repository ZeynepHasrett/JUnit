package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class Q02_KeyboardActions extends TestBaseEach {

    @Test
    public void test01() {

        // 1- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        // 2- video’yu gorecek kadar asagi inin
        WebElement iframe = driver.findElement(By.xpath("(//iframe)[1]"));

        driver.switchTo().frame(iframe);

        // 3- videoyu izlemek icin Play tusuna basin
        Actions actions = new Actions(driver);
        ReusableMethods.bekle(1);

        WebElement playTusuElementi = driver.findElement(By.xpath("//*[@title='Oynat']"));

        actions.click(playTusuElementi).perform();

        // 4- videoyu calistirdiginizi test edin
        WebElement videoElementi = driver.findElement(By.xpath("//div[@*='html5-video-player ytp-exp-bottom-control-flexbox ytp-modern-caption ytp-livebadge-color-control ytp-title-enable-channel-logo ytp-fine-scrubbing-exp ytp-embed ytp-embed-playlist ytp-fit-cover-video playing-mode ytp-autohide']"));

        Assertions.assertTrue(videoElementi.isDisplayed());

    }

}
