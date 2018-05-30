package test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import alpha.Browser;

import java.net.MalformedURLException;

public class Hooks  {

    Browser bro = new Browser();

  @Before
    public void startup () throws MalformedURLException {
        bro.browseropen();
        bro.maximise();
        bro.navigate("https://www.bbc.co.uk");
        bro.waits(60);

    }

    @After
    public void teardown (){
        bro.quit();
    }

}
