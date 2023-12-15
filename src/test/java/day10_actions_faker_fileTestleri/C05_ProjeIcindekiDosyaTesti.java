package day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_ProjeIcindekiDosyaTesti extends TestBase {


    @Test
    public void fileExistsTesti(){

        // projemiz icerisinde day10 package'i altinda
        // deneme.txt dosyasinin oldugunu test edin

        String dosyaYolu = "/Users/ahmedmuftu/Desktop/intellij projects/com.team127_JUnit1/src/test/java/day10_actions_faker_fileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // herkeste farkli olan kisim user.dir
        //        String dosyaYolu = "/Users/ahmedmuftu/Desktop/intellij projects/com.team127_JUnit1
        // herkeste ayni olan kisim ==> projenin icindeki dosya yolu
        //        /src/test/java/day10_actions_faker_fileTestleri/deneme.txt";
        String dinamikDosyaYolu = System.getProperty("user.dir") +
                                    "/src/test/java/day10_actions_faker_fileTestleri/deneme.txt";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }
}
