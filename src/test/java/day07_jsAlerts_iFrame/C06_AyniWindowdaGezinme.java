package day07_jsAlerts_iFrame;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilies.TestBaseEach;

public class C06_AyniWindowdaGezinme extends TestBaseEach {

    @Test
    public void test01() {

        // testotomasyonu sayfasina gidin
        driver.get("https://www.testotomasyonu.com");

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Ana sayfa window handle degeri : " + driver.getWindowHandle());
        System.out.println("Ana sayfa url : " + driver.getCurrentUrl());

        // Electronics linkini tiklayin
        driver.findElement(By.xpath("//*[@class='has-sub'][1]"))
                .click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Electronics window handle degeri : " + driver.getWindowHandle());
        System.out.println("Electronics url : " + driver.getCurrentUrl());

        // ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@class='product-box mb-2 pb-1'])[1]"))
                .click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("Ilk urun window handle degeri : " + driver.getWindowHandle());
        System.out.println("Ilk urun url : " + driver.getCurrentUrl());

        // account linkine tiklayin
        driver.findElement(By.xpath("//*[text()='Account']"))
                .click();

        // windowhandle degerini ve url'i yazdirin
        System.out.println("account window handle degeri : " + driver.getWindowHandle());
        System.out.println("account url : " + driver.getCurrentUrl());

    }

}
