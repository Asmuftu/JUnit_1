package day07_TestBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_JsAlerts extends TestBase {

    // 3 test method’u olusturup asagidaki gorevi tamamlayin
    // 1. Test
    //  - https://testotomasyonu.com/javascriptAlert adresine gidin
    //  - 1.alert’e tiklayin
    //  - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
    //  - OK tusuna basip alert’i kapatin
    // 2.Test
    //  - https://testotomasyonu.com/javascriptAlert adresine gidin
    //  - 2.alert’e tiklayalim
    //  - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
    // 3.Test
    //  - https://testotomasyonu.com/javascriptAlert adresine gidin
    //  - 3.alert’e tiklayalim
    //  - Cikan prompt ekranina “Abdullah” yazdiralim
    //  - OK tusuna basarak alert’i kapatalim
    //  - Cikan sonuc yazisinin Abdullah icerdigini test edelim

    @Test
    public void jsBasicAlert(){
        driver.get("https://testotomasyonu.com/javascriptAlert");
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();

        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        ReusableMethods.bekle(2);
        driver.switchTo().alert().accept();

    }

    @Test
    public void jsConfirmAlert(){
        driver.get("https://testotomasyonu.com/javascriptAlert");
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

        ReusableMethods.bekle(2);

        driver.switchTo().alert().dismiss();

        WebElement resultYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedResultYazisi = "You clicked: Cancel";
        String actualResultYazisi = resultYaziElementi.getText();

        Assert.assertEquals(expectedResultYazisi,actualResultYazisi);
    }

    @Test
    public void jsPromptTesti(){
        driver.get("https://testotomasyonu.com/javascriptAlert");
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();

        driver.switchTo().alert().sendKeys("Abdullah");
        ReusableMethods.bekle(5);
        driver.switchTo().alert().accept();

        WebElement resultYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));

        String expectedResultIcerik = "Abdullah";
        String actualResultIcerik = resultYaziElementi.getText();

        Assert.assertTrue(actualResultIcerik.contains(expectedResultIcerik));

    }
}
