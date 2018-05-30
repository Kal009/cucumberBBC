package alpha;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;
    public String browser = "chrome";

    DesiredCapabilities des;

    public static final String USERNAME = "kalpesh72";
    public static final String AUTOMATE_KEY = "qVdpf6bjJwnPjbZgLHbb";
    public static final String urL1 = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    public void Homepage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public void browseropen() throws MalformedURLException {


      /*  switch (browser) {
            case "chrome":
                des = DesiredCapabilities.chrome();
                des.setPlatform(Platform.WINDOWS);
                driver = new RemoteWebDriver(new URL(urL1), des);
                break;
            case "ie":
                des = DesiredCapabilities.edge();
                des.setPlatform(Platform.WIN10);
                driver = new RemoteWebDriver(new URL(urL1), des);
                break;
            default:
                des = DesiredCapabilities.firefox();
                des.setPlatform(Platform.WIN10);
                driver = new RemoteWebDriver(new URL(urL1), des);
                break;
        }*/

        switch (browser) {
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case "ie":
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
        }

    }

    public void waits(int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }

    public void maximise() {
        driver.manage().window().maximize();
    }


    public void quit() {
        driver.quit();
    }

    public void navigate(String url) {

        driver.get(url);

    }

}
