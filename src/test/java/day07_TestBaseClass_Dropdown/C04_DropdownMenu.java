package day07_TestBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.lang.annotation.Target;

public class C04_DropdownMenu extends TestBase {

    //1. http://zero.webappsecurity.com/ Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password” yazin
    // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
    // 6. Online banking menusunden Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. “amount” kutusuna bir sayi girin
    // 10. “US Dollars” in secilmedigini test edin
    // 11. “Selected currency” butonunu secin
    // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
    @Test
    public void dropdownTesti(){
        driver.get("http://zero.webappsecurity.com/");
         driver.findElement(By.id("signin_button")).click();

         WebElement loginKutusu = driver.findElement(By.id("user_login"));
        loginKutusu.sendKeys("username"+ Keys.ENTER);

        WebElement passwordKutusu = driver.findElement(By.id("user_password"));
        passwordKutusu.sendKeys("password"+ Keys.ENTER);

        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();

        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        WebElement currencyDdm = driver.findElement(By.id("pc_currency"));
        Select selectCurrency = new Select(currencyDdm);
        selectCurrency.selectByValue("EUR");

         driver.findElement(By.id("pc_amount")).sendKeys("100");

         String unexpectedOption = "US Dollars";
         String actualOption = selectCurrency.getFirstSelectedOption().getText();
         Assert.assertNotEquals(unexpectedOption,actualOption);

         driver.findElement(By.id("pc_inDollars_false")).click();

         driver.findElement(By.id("pc_calculate-costs")).click();
         driver.findElement(By.id("purchase_cash")).click();

         WebElement uyariYazisiElementi = driver.findElement(By.id("alert-content"));
         String expectedYazi = "Foreign currency cash was successfully purchased.";
         String actualUyariyazisi = uyariYazisiElementi.getText();

         Assert.assertEquals(expectedYazi,actualUyariyazisi);



        ReusableMethods.bekle(3);
    }

}
