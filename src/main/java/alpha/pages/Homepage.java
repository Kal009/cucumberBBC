package alpha.pages;

import alpha.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Homepage extends Browser {

    @FindBy(linkText = "Homepage")
    WebElement homepagelink;


    public String varifyhomepage() {
        String title = driver.getTitle();
        return title;
    }

    public void age() {
        List<WebElement> ag = driver.findElements(By.cssSelector(".button"));

        for (WebElement age : ag) {

            if (age.getText().equalsIgnoreCase("13 or over")) {
                System.out.println(age.getText());
                age.click();

                break;

            }


        }
    }

    public void emailupdate() {
        List<WebElement> email = driver.findElements(By.cssSelector(".button__text-wrapper"));
        for (WebElement element : email) {
            if (element.getText().equalsIgnoreCase("No, thanks")) {
                element.click();
                break;

            }
        }
    }

    public String sucessmsg() {
        String msg = driver.findElement(By.cssSelector(".heading.u-padding-bottom-quad.u-padding-top-hex--tablet.header__title--success")).getText();
        return msg;

    }
    public void signout(){
        List<WebElement> signout = driver.findElements(By.cssSelector(".primary-nav__item-text"));
        for(WebElement sign : signout){
            if(sign.getText().equalsIgnoreCase("Sign out")){
                sign.click();
                break;
            }
        }
    }

            public int randomnumber(){
                Random random = new Random();
                return random.nextInt();

            }

}