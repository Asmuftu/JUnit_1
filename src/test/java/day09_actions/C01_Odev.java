package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_Odev extends TestBase {

    /*
    kontrolsuz bir tab/window acildiginda
    eger yeni acilan ta/window'un title degeri biliniyorsa
    acilan sayfanin whd'ini bize donduren bir method olusturun

    input : yeniTitle , Test Otomasyonu - Electronics
    
     */

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        String ilkSayfaWhd = driver.getWindowHandle();
        //    //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h2"));
        String expectedText = "Add/Remove Elements";
        String actualText = yaziElementi.getText();
        Assert.assertEquals(expectedText,actualText);
        //    //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        //    //● ‘Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.linkText("Electronics Products")).click();
        //    //● Electronics sayfasinin acildigini test edin
        driver = ReusableMethods.titleIleSayfaDegistir(driver,"Test Otomasyonu - Electronics");
        //    //● Bulunan urun sayisinin 16 olduğunu test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        String sonucSayisiStr = sonucYaziElementi.getText().replaceAll("\\D","");
        int sonucSayisi = Integer.parseInt(sonucSayisiStr);
        int expectedSonucSayisi = 16;
        Assert.assertEquals(expectedSonucSayisi,sonucSayisi);
        //    //● Ilk actiginiz addremove sayfasina donun
        driver = driver.switchTo().window(ilkSayfaWhd);
        //    //● Url’in addremove icerdigini test edin
        String expectedUrlIcerik = "addremove";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        ReusableMethods.bekle(3);
    }
}
