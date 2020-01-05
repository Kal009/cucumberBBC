package test.steps;

import alpha.Browser;
import alpha.pages.Homepage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Test extends Browser {

    Homepage hp = new Homepage();


    @Given("^i am on home page$")
    public void iAmOnHomePage() throws Throwable {
        Assert.assertEquals("BBC - Home", hp.varifyhomepage());
    }

    @When("^i click on sing in$")
    public void iClickOnSingIn() throws Throwable {
        driver.findElement(By.linkText("Sign in")).click();
    }

    @Then("^i should navigate to login page$")
    public void iShouldNavigateToLoginPage() throws Throwable {
        //driver.findElement(By.linkText("Register now")).click();
        Thread.sleep(1000);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, "BBC – Sign in");

    }

    @When("^i click on weatherlink$")
    public void iClickOnWeatherlink() throws Throwable {
        driver.findElement(By.linkText("Weather")).click();

    }

    @Then("^I should navigate to weather page$")
    public void iShouldNavigateToWeatherPage() throws Throwable {
        String actual = driver.getTitle();
        Assert.assertEquals(actual, "BBC Weather");
        Thread.sleep(2000);


    }

    @When("^i click on newslink$")
    public void iClickOnNewslink() throws Throwable {
        driver.findElement(By.linkText("News")).click();
        String actual = driver.getTitle();
        Assert.assertEquals(actual, "Home - BBC News");

    }

    @When("^i click on sportslink$")
    public void iClickOnSportslink() throws Throwable {
        driver.findElement(By.linkText("Sport")).click();

    }

    @Then("^I should navigate to sport page$")
    public void iShouldNavigateToSportPage() throws Throwable {
        String actual = driver.getTitle();
        Assert.assertEquals(actual, "Home - BBC Sport");
    }


    @Given("^I am on singin page$")
    public void iAmOnSinginPage() throws Throwable {
        Assert.assertEquals("BBC - Home", hp.varifyhomepage());
        driver.findElement(By.cssSelector("#idcta-username")).click();

    }

    @When("^I click on register$")
    public void iClickOnRegister() throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".link.link--primary>span")).click();
    }

    @Then("^I should navigate to register page$")
    public void iShouldNavigateToRegisterPage() throws Throwable {
        Thread.sleep(1000);
        String actual = driver.getTitle();
        Assert.assertEquals(actual, "BBC – Register");
    }

    @And("^I confirm my age$")
    public void iConfirmMyAge() throws Throwable {
        Thread.sleep(2000);
        hp.age();
    }


    @Then("^I should navigate to news page$")
    public void iShouldNavigateToNewsPage() throws Throwable {

    }


    @And("^I enter my age as \"([^\"]*)\" and \"([^\"]*)\"and \"([^\"]*)\"$")
    public void iEnterMyAgeAsAndAnd(String day, String month, String year) throws Throwable {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#day-input")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#day-input")).sendKeys(day);
        driver.findElement(By.cssSelector("#month-input")).sendKeys(month);
        driver.findElement(By.cssSelector("#year-input")).sendKeys(year);
        driver.findElement(By.cssSelector("#submit-button")).click();
    }

    @And("^I enter my email as \"([^\"]*)\" and password as \"([^\"]*)\" and postcode\"([^\"]*)\"$")
    public void iEnterMyEmailAsAndPasswordAsAndPostcode(String email, String pass1, String pass2) throws Throwable {
        driver.findElement(By.cssSelector("#user-identifier-input")).sendKeys(hp.randomnumber() + email);
        driver.findElement(By.cssSelector("#password-input")).sendKeys(pass1);
        driver.findElement(By.cssSelector("#postcode-input")).sendKeys(pass2);
        new Select(driver.findElement(By.cssSelector("#gender-input"))).selectByValue("male");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#submit-button")).click();
        Assert.assertEquals(hp.sucessmsg(), "OK you’re signed in. Now, want to keep up to date?");
        hp.emailupdate();
        driver.findElement(By.cssSelector("#submit-button")).click();
        driver.findElement(By.cssSelector("#idcta-username")).click();
        Thread.sleep(2000);
        String ms1 = driver.findElement(By.cssSelector(".heading.heading--hero.u-padding-bottom-double")).getText();
        Assert.assertEquals(ms1, "Lovely to see you here");
        hp.signout();
        String ms2 = driver.findElement(By.cssSelector(".heading.u-padding-bottom-quad")).getText();
        Assert.assertEquals(ms2, "You've signed out, sorry to see you go.");


    }

    @And("^I search for city \"([^\"]*)\"$")
    public void iSearchForCity(String arg0) throws Throwable {
        driver.findElement(By.cssSelector("#ls-c-search__input-label")).sendKeys(arg0);
        driver.findElement(By.cssSelector(".ls-c-search__submit")).click();
        Thread.sleep(1000);
        String cityname = driver.findElement(By.cssSelector("#wr-location-name-id")).getText();
        System.out.println(cityname);
        Assert.assertEquals(cityname,arg0);
    }


    @Then("^I should get weather report$")
    public void iShouldGetWeatherReport() throws Throwable {
        String day = driver.findElement(By.cssSelector(".wr-date")).getText();
        String tem = driver.findElement(By.cssSelector(".wr-value--temperature--c")).getText();
        System.out.println(day);
        System.out.println(tem);
    }
}
