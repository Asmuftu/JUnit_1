package day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_KontrolluCokluWindowIleCalisma extends TestBase {

    @Test
    public void kontrolluWindowTesti(){

        // https://www.testotomasyonu.com anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        String anasayfaWHD = driver.getWindowHandle();

        // yeni bir tab olarak electronics linkini acin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        String electronicsWHD = driver.getWindowHandle();

        // acilan sayfanin electronics sayfasi oldugunu test edin
        // Title'da electronics oldugunu test edelim
        String expectedTitleIcerik = "Electronics";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // yeni bir window'da acilacak sekilde men fashion linkini tiklayin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Men Fashion'])[3]")).click();
        String menFashionWHD = driver.getWindowHandle();

        // men fashion sayfasinin acildigini test edin
         expectedTitleIcerik = "Men Fashion";
         actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // ilk actigimiz sayfaya donun
        driver.switchTo().window(anasayfaWHD);

        // eger bir testte acilan window'lar farkli tab veya window'larda aciliyorsa
        // ve testimizde bu sayfalar arasinda gecis isteniyorsa
        // gectigimiz her sayfanin windowHandleDegerini kaydetmeliyiz


        // test otomasyon anasayfada oldugumuzu test edin
        expectedTitleIcerik = "- Test Otomasyonu";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        ReusableMethods.bekle(10);
    }
}
