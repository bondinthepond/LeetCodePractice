package AutomationPractice.Selenium.SeleniumPracticePersonal.Features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBasicAuth {

    public static void main(String[] args) {



        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        ((HasAuthentication) driver).register(UsernameAndPassword.of("admin", "admin"));

        driver.get("https://the-internet.herokuapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }
}
