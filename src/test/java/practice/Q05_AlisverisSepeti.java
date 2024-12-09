package practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilies.TestBaseEach;

public class Q05_AlisverisSepeti extends TestBaseEach {

    @Test
    public void test01() {

        // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

        // 2. Username kutusuna “standard_user” yazdirin
        WebElement usernameKutusu = driver.findElement(By.id("user-name"));

        usernameKutusu.sendKeys("standard_user" + Keys.ENTER);

        // 3. Password kutusuna “secret_sauce” yazdirin
        WebElement passwordKutusu = driver.findElement(By.xpath("//*[@id='password']"));

        passwordKutusu.sendKeys("secret_sauce" + Keys.ENTER);

        // 4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunIsmi = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));

        String ilkUrunIsmiStr = ilkUrunIsmi.getText();

        ilkUrunIsmi.click();

        // 6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart")).click();

        // 7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();

        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String actualUrunIsmi = driver.findElement(By.id("item_4_title_link")).getText();

        Assertions.assertEquals(ilkUrunIsmiStr, actualUrunIsmi);

    }

}
