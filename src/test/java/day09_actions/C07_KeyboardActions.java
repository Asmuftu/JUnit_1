package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_KeyboardActions extends TestBase {


    @Test
    public void test01(){

        //2- https://www.testotomasyonu.com sayfasina gidelim
        driver.get("https://www.testotomasyonu.com");
        //3- Arama kutusuna actions method’larini kullanarak “DELL Core I3” yazdirin
        //   ve Enter’a basarak arama yaptirin

        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        Actions actions = new Actions(driver);

        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .sendKeys(Keys.ENTER)
                .perform();



        //4- Bulunan urun isminde “DELL Core I3” bulundugunu test edin
        String expectedUrunIsmi = "DELL Core I3";
        String actualUrunIsmi = driver.findElement(By.xpath("//*[@class='prod-title mb-3 ']")).getText();

        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIsmi));
        ReusableMethods.bekle(5);
    }
}
