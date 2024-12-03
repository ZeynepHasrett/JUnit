package day06_assertions_dropdownMenu;

import org.junit.jupiter.api.Test;
import utilies.ReusableMethods;
import utilies.TestBaseEach;

public class C05_TestBaseKullanimi extends TestBaseEach {

    /*
        Java'da OOP koncept'in en buyuk avantaji REUSABILITY' dir

        @BeforeEach - @AfterEach
        @BeforeAll - @AfterAll
        method'lari her class'da ayni sekilde yeniden yazmak yerine
        baska bir class'da olusturabiliriz

        Baska bir class'da bulunan class uyelerine
        ulasmanin en kisa yolu inheritance'dir

        Biz de utilities altinda TestBase olusturup
        before ve after method'larini o class'a koyabiliriz
     */

    @Test
    public void test01() {
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.bekle(1);
    }

}
