package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

public class Q06_Assertions extends TestBaseEach {

    // 1) https://www.youtube.com adresine gidin
    // 2) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
    //   ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    //   ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //   ○ searchBoxTest => Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //   ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    @BeforeEach
    public void driverGet(){
        // 1) https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
    }

    @Test
    public void titleTest(){
        //   ○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void imageTest(){
        //   ○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement resimElementi = driver.findElement(By.xpath("(//*[@id='logo'])[1]"));

        Assertions.assertTrue(resimElementi.isDisplayed());
    }

    @Test
    public void searchBoxTest(){
        //   ○ searchBoxTest => Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxElementi = driver.findElement(By.id("search-input"));

        Assertions.assertTrue(searchBoxElementi.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        //   ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();

        Assertions.assertNotEquals(expectedTitle, actualTitle);

    }

}
