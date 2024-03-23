package AutomationPractice.Selenium.Selenium4Examples.src.test.java.chromedevtools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.devtools.v101.emulation.Emulation;

public class TestOverrideTimeZone {

	public static void main(String[] args) throws InterruptedException {



		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://whatismytimezone.com/");
		
		Thread.sleep(5000);
		
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Emulation.setTimezoneOverride("EST"));
		driver.get("https://whatismytimezone.com/");
	

	}

}
