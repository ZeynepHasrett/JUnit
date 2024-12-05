package day08_windowSwitch_actionsClass;

import utilies.TestBaseEach;

public class C11_ extends TestBaseEach {

    /*
        1-https://testotomasyonu.com/discount adresine gidin
        2- Elektronics Products yazisinin gorunur oldugunu test edin
        3- Dell bilgisayar urun isminin 'DELL Core I3 1 1th Gen' oldugunu test edin
        4- Dell bilgisayar'a tiklayip acilan sayfada urun fiyatinin $399.00 oldugunu test edin.
        5- Ilk window'a donun ve Fashion yazisinin gorunur oldugunu test edin
        6- Sayfayi kapatin
     */

    /*
    //https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");

    //Elektronics Products yazisinin gorunur oldugunu test edin
    WebElement iframe1 = driver.findElement(By.xpath("(//iframe)[1]"));

        driver.switchTo().frame(iframe1);
    //ReusableMethods.bekle(1);

    WebElement electronicProductYazisi = driver.findElement(By.xpath("//h2[text()='Electronics Products']"));
        Assertions.assertTrue(electronicProductYazisi.isDisplayed());
    //ReusableMethods.bekle(1);

    //Dell bilgisayar urun isminin 'DELL Core I3 11th Gen' oldugunu test edin
    String expectedDellUrunIsmi = "DELL Core I3 11th Gen";
    String actualDellUrunIsmi = driver.findElement(By.xpath("//span[text()='DELL Core I3 11th Gen ']")).getText();

        Assertions.assertEquals(actualDellUrunIsmi,expectedDellUrunIsmi);
    //ReusableMethods.bekle(1);

    //Dell bilgisayar'a tiklayip acilan sayfada urun fiyatinin $399.00 oldugunu test edin.
        driver.findElement(By.xpath("//*[@id='pictext1']")).click();
        ReusableMethods.bekle(1);

    String ilkSayfaWhd = driver.getWindowHandle();
    String ikinciSayfaWhd = "";
    Set<String> tumWhd = driver.getWindowHandles();

        for (String each : tumWhd){

        if ( ! each.equals(ilkSayfaWhd) ){
            ikinciSayfaWhd=each;
        }
    }
        driver.switchTo().window(ikinciSayfaWhd);

    // 2.yol: ReusableMethods.urlIleWindowDegistir(driver,"https://testotomasyonu.com/product/58");

    String expectedUrunFiyati = "$399.00";
    String actualUrunFiyati = driver.findElement(By.xpath("//*[@id='priceproduct']")).getText();

        Assertions.assertEquals(expectedUrunFiyati,actualUrunFiyati);
        ReusableMethods.bekle(1);

    //5- Ilk window'a donun ve Fashion yazisinin gorunur oldugunu test edin
        driver.switchTo().window(ilkSayfaWhd);
        ReusableMethods.bekle(2);

    WebElement iframe2 = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframe2);
        ReusableMethods.bekle(1);

    WebElement fashionYazisi = driver.findElement(By.xpath("//h2[text()='Fashion']"));
        Assertions.assertTrue(fashionYazisi.isDisplayed());
        ReusableMethods.bekle(1);


     */
}
