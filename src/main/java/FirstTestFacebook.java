import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTestFacebook {
    @Test
    public void checkLoginFacebook() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        By urlMistake = By.xpath("//div[@id='login_link']/div/a");
        By login = By.xpath("//input[@data-testid='royal_email']");
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);

        driver.manage().window().maximize();

        driver.findElement(login).sendKeys("your.email@gmail.com");
        driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("Wrongpassword");
        driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
        Thread.sleep(3000);

        System.out.println("Log in unsuccessfully - check your password");
        Assert.assertEquals("Forgotten password?", driver.findElement(urlMistake).getText());

        driver.navigate().back();
        driver.findElement(login).clear();
        driver.findElement(login).sendKeys("your.email@gmail.com");
        driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("YourPassword");
        driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@role='navigation'])/span/div/div[@role='button']")).click();
        Thread.sleep(3000);
      driver.findElement(By.xpath("//footer[@aria-label='Facebook']/parent::div/preceding-sibling::div/following-sibling::div[2]/div/div[4]/div")).click();

        System.out.println("Logged out successfully");

    }
}
