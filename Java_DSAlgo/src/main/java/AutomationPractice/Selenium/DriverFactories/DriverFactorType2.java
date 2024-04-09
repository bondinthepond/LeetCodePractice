package AutomationPractice.Selenium.DriverFactories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactorType2 {
    public void initiateDriver2() {
        System.setProperty("webdriver.chrome.driver","/Users/amallela/PracticeRepos/JAVAPractice/DSAlgo/src/main/java/AutomationPractice/Selenium/Drivers/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.educative.io/learn");
    }
}
