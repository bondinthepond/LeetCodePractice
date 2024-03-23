package AutomationPractice.Selenium.Selenium4Examples.src.test.java.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestEnhancement {

	public static void main(String[] args) {


		
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement link = driver.findElement(By.linkText("Gmail"));
		
		int x = link.getRect().getX();
		int y = link.getRect().getY();
		
		
		Actions action = new Actions(driver);
		action.moveByOffset(x, y).click().perform();
		action.click();


		Actions actionProvider = new Actions(driver);
		Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build(); //Key Down is used to simulate action of depressing a key
		keydown.perform();

		Actions actionProvider2 = new Actions(driver);
		WebElement search = driver.findElement(By.name("q"));
		actionProvider2.keyDown(Keys.SHIFT).sendKeys(search,"qwerty").keyUp(Keys.SHIFT).sendKeys("qwerty").perform();// QWERTYqwerty
		//Key up is used to simulate key-up (or) key-release action



	}

}
