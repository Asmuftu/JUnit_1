package day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C06_KontrolsuzCokluWindowKullanimi extends TestBase {

    //● https://testotomasyonu.com/addremove/ adresine gidin.
    //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
    //● ‘Please click for Electronics Products’ linkine tiklayin.
    //● Electronics sayfasinin acildigini test edin
    //● Bulunan urun sayisinin 16 olduğunu test edin
    //● Ilk actiginiz addremove sayfasina donun
    //● Url’in addremove icerdigini test edin

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");

        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement yaziElementi = driver.findElement(By.tagName("h2"));
        String expectedYazi = "Add/Remove Elements";
        String actualYazi = yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        driver.findElement(By.linkText("Electronics Products")).click();

        /*
        driver bir webelement'e click yapildiginda
        ayni sayfada acilacagini varsayar

        eger tiklanan element yeni bir tab veya window aciyorsa
        bu durumda driver'i yeni acilan tab/window'a bizim gondermemiz gereki

        bizim driver'i baska bir tab/window'a yollamak icin 2 yolumuz var
        1- ya kontrollu yeni bir tab veya window acarak
        2- kontrolsuz acilan tab/window'un window handle degerini kullanarak

        burada java'dan yararlanarak mini bir bulmaca cozmeliyiz
         */
        String ilkSayfaWHD = driver.getWindowHandle();
        Set<String> wHDSeti = driver.getWindowHandles();

        System.out.println(ilkSayfaWHD);
        System.out.println(wHDSeti);
        String ikinciSayfaWhd = "";
        for (String each:wHDSeti) {

            if (!each.equals(ilkSayfaWHD)){
                ikinciSayfaWhd = each;
            }
        }

        driver.switchTo().window(ikinciSayfaWhd);

        String expectedTitleIcerik = "Electronics";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        WebElement sonucYaziElementi = driver.findElement(By.className("product-count-text"));
        String sonucSayisiStr = sonucYaziElementi.getText().replaceAll("\\D","");
        int sonucSayisi = Integer.parseInt(sonucSayisiStr);

        Assert.assertEquals(16,sonucSayisi);

        driver.switchTo().window(ilkSayfaWHD);

        String expectedUrlIcerik = "addremove";
        String actualURL = driver.getCurrentUrl();

        Assert.assertTrue(actualURL.contains(expectedUrlIcerik));


        ReusableMethods.bekle(2);

    }
}
