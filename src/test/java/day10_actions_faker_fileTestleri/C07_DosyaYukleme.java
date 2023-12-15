package day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_DosyaYukleme extends TestBase {

    @Test
    public void dosyaYuklemeTesti(){

        /*
        Selenium'da webdriver ile islemlerimizi yapari
        webdriver bizim bilgisayarimizdaki dosyalara ulasamaz ve kullanamaz
        Dosya exists islemlerinde Java'dan yararlanip
        dosya yolunu kullanarak islemler yapabiliriz

        dosya yuklemede ise dosya sec butonuna bastigimizfa
        bilgisayarimizdaki dosya yapisi acilir
        Biz webdriver ile bilgisayarimizdaki dosya yapisinda islem yapamayacagimiz icin
        chooseFile butonuna sendKeys() ile dosya yolunu yollariz

         */
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim
        //3.Yuklemek istediginiz dosyayi secelim.
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));


        // testlerimizin butun takim uyelerinde calisabilmesi icin
        // dosya yolunu dinamik yapmaliyiz
        // biz bir onceki test'de downloads'a indirdigimiz
        // logo.png'yi yukleyelim

        String dinamikDosyaYolu = System.getProperty("user.home") +
                                    "/Downloads/logo.png";
        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //4.Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();
        //5.“File Uploaded!” textinin goruntulendigini test edelim

        WebElement uploadedYaziElementi = driver.findElement(By.tagName("h3"));
        String expectedText = "File Uploaded!";
        String actualText = uploadedYaziElementi.getText();
        Assert.assertEquals(expectedText,actualText);


        ReusableMethods.bekle(3);
    }
}
