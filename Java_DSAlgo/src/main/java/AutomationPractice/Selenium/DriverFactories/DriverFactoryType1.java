package AutomationPractice.Selenium.DriverFactories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactoryType1 {

    public void initiateDriver1() {
        WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
        driver.get("https://www.educative.io/learn");
    }
}
