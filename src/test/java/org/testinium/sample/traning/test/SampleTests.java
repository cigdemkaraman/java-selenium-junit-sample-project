package org.testinium.sample.traning.test;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SampleTests extends BaseTestKeyword{

    @Test
    public void signUpTest(){
        clickByXpath("//*[text()='veya Üye Ol']");
        signUp("Çiğdem", "Karaman", "cigdemcemrekaraman@gmail.com", "123445","05462222222");

    }
    @Test
    public void signInTest(){
        clickByXpath("//*[@title = 'Giriş Yap']");
        signIn("karamancigdem8@gmail.com","Testdenemedenemenemdmd");
    }
    @Test
    public void SearchAndAddtoCartTest() throws InterruptedException {
        SearchAndAddtoCart("bilgisayar");
    }

    @Test
    public void addAddressTest(){
        addAddress();
    }

}
