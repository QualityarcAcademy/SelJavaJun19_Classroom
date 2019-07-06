package classroom;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverTest {
	public RemoteWebDriver driver;

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

	//switch to a child window
	public void switchToChildWin() {
		Set<String> windowHandles =driver.getWindowHandles();
		int i=0;
		for (String winHandle : windowHandles) {
			if(i==1) {
				driver.switchTo().window(winHandle);
				break;
			}
			i++;
		}

	}


	/*
	 * Function for dropdown
	 */

	public void selectValByVisibileText(WebElement dropdown, String value) {
		Select dp = new Select(dropdown);
		dp.selectByVisibleText(value);
	}

	// 

}
