import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class Login {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
      System.setProperty("webdriver.firefox.marionette","G:\\Selenium\\geckodriver-v0.10.0-arm7hf\\geckodriver.exe");
     // WebDriver wd = new FirefoxDriver();
       wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      System.out.println("test1");
        wd.get("http://localhost/addressbook/");
      System.out.println("test2");
        login("admin", "secret");
      System.out.println("test3");
    }
    
    @Test
    public void login(String username, String password) {

        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).sendKeys("\\undefined");
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
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
