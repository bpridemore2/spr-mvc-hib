/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UITest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
//import static junit.framework.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 *
 * @author bpridemore
 */
public class Selenium2ExampleIT extends TestCase {

    private static final String SELENIUM_HUB_URL = "http://10.0.1.17:4444/wd/hub";
    private static final String TARGET_SERVER_URL = "http://www.ebay.com";

    
    //seleniumURL
    String myURL = System.getProperty("selenium.grid.url");
    @Test
    public void testIE() {
        System.out.println("testing IE");
    System.out.println("what is my property? "+ myURL);
   // System.out.println(System.getProperty("skip.unit.tests"));
    //System.out.println(System.getProperties().toString());

        DesiredCapabilities browser = DesiredCapabilities.internetExplorer();
        testCodesCrud(browser);
    }

    @Test
    public void testFirefox() {

        System.out.println("testing firefox");
   // System.out.println("what is my property? "+ myURL);

        DesiredCapabilities browser = DesiredCapabilities.firefox();
        testCodesCrud(browser);
    }

    @Test
    public void testChrome2() {
        System.out.println("testing chrome");
   // System.out.println("what is my property? "+ myURL);

        DesiredCapabilities browser = DesiredCapabilities.chrome();
        testCodesCrud(browser);
    }

    @Test
    public void testOpera() {
        System.out.println("testing opera");

        DesiredCapabilities browser = DesiredCapabilities.opera();
        testCodesCrud(browser);
    }

    public void testCodesCrud(DesiredCapabilities browser) {
        WebDriver driver = null;
        try {
            System.out.println("browser  " + browser.toString());

            System.out.println("connect to server @ " + SELENIUM_HUB_URL);

            driver = new RemoteWebDriver(new URL(SELENIUM_HUB_URL), browser);
            System.out.println("Driver " + driver.toString());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
System.out.println("Is JSP enabled? " +browser.isJavascriptEnabled());
            System.out.println("UI Testing being @  " + TARGET_SERVER_URL);

            driver.get(TARGET_SERVER_URL);
            System.out.println("checking for data [" + driver.getTitle() + "]");

            assertEquals("Electronics, Cars, Fashion, Collectibles, Coupons and More |eBay", driver.getTitle());

        } catch (MalformedURLException e) {
            e.printStackTrace();
            assertTrue(false);

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        } finally {
            if (driver != null) {
               // driver.quit();
            }else{
             assertTrue(true);   
            }
        }
    }

}
