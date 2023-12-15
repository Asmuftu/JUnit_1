package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_MoveToElement extends TestBase {

    @Test
    public void moveToElement() {

        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement kidsWearElementi = driver.findElement(By.xpath("(//*[@class='has-sub'])[7]"));
        actions.moveToElement(kidsWearElementi).perform();
        //3- “Boys” linkine basin
        WebElement boysLinki = driver.findElement(By.xpath("(//ul[@class='submenu-link'])[2]"));
        boysLinki.click();
        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElement(By.xpath("(//div[@class='product-box mb-2 pb-1'])[1]")).click();
        //4- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        String expectedUrunIsmi = "Boys Shirt White Color";
        String actualUrunIsmi = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']")).getText();
        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);
        ReusableMethods.bekle(2);
    }
}
