import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class Login {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
      System.setProperty("webdriver.firefox.marionette","G:\\Selenium\\geckodriver-v0.10.0-arm7hf\\geckodriver.exe");
     // WebDriver wd = new FirefoxDriver();
       wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void Login() {
        wd.get("http://localhost/addressbook/");
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys("\\undefined");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");
        wd.findElement(By.cssSelector("html")).click();
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }
    
    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
          System.out.println("Error1");
            return true;
        } catch (NoAlertPresentException e) {
          System.out.println("Error2");
            return false;
        }
    }
}
