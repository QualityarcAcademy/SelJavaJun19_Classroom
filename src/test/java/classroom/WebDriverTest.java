package classroom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverTest {
	RemoteWebDriver driver;
	
	public void openBrowser(String URL) {
		WebDriverManager.chromedriver().setup();
		
		//Create the driver object
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//Search for iphone
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
	

	}

}
