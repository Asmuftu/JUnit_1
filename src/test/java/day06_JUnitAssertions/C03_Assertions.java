package day06_JUnitAssertions;

import org.junit.Assert;
import org.junit.Test;

public class C03_Assertions {

    @Test
    public void test01() {

        // emeklilik yasi 65 olsun

        // 70 yasindaki bir kisinin emekli olabildigini test edin

        int yas = 70;

        Assert.assertTrue(yas>65); // test passed


        int sayi1 = 20;
        int sayi2 = 30;

        // Assert.assertTrue(sayi1>sayi2); // test failed

        System.out.println("assertion failed olursa bu satir calismaz");

        Assert.assertFalse(sayi1>sayi2); // test passed

        String actualUrl = "https://testotomasyonu.com/";

        // Url'in testotomasyonu icerdigini test edin

        Assert.assertTrue(actualUrl.contains("testotomasyonu"));

        // Url'in wisequarter icermedigini test edin

        Assert.assertFalse(actualUrl.contains("wisequarter"));

        // Url'in "https://testotomasyonu.com/" oldugunu test edin

        Assert.assertEquals("https://testotomasyonu.com/",actualUrl);
        Assert.assertTrue("https://testotomasyonu.com/".equals(actualUrl));

        // Url'in "https://www.testotomasyonu.com/" olmadigini test edin


        Assert.assertNotEquals("https://www.testotomasyonu.com/",actualUrl);

    }
}
