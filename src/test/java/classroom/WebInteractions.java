package classroom;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class WebInteractions extends WebDriverTest {

	@Test
	public void interacWithWeb() throws InterruptedException, IOException {
		//Open browser

		openBrowser("http://the-internet.herokuapp.com/upload");

		/*
		 * Dropdown
		 */

		WebElement dropdown = driver.findElementById("dropdown");
		Select dd = new Select(dropdown);
		dd.selectByVisibleText("Option 1");

		//get the list of options
		List<WebElement> dropdownOptions = dd.getOptions();

		for (WebElement webElement : dropdownOptions) {
			String dropdownoption = webElement.getText();
			System.out.println(dropdownoption);


		}
		/*
		 * Checkbox
		 */

		driver.findElementByXPath("//form[@id='checkboxes']/*[1]").click();
		//confirm whether the second checkbox is selected

		boolean is2nddropdownSelected = driver.findElementByXPath("//form[@id='checkboxes']/*[3]").isSelected();
		System.out.println("The dropdown is already selected "+is2nddropdownSelected);

		/*
		 * Handling window
		 */

		driver.findElement(By.linkText("Click Here")).click();
		driver.findElement(By.linkText("Elemental Selenium")).click();

		//Get the list of opened window
		Set<String> listOfWinHandles = driver.getWindowHandles();
		for (String window : listOfWinHandles) {
			System.out.println(window);
			driver.switchTo().window(window);
			String title = driver.getTitle();
			System.out.println(title);
			Thread.sleep(2000);
			if(title.equals("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro")) {
				driver.switchTo().window(window);
				boolean switched = driver.findElementByTagName("h2").getText().equals("A free, once-weekly e-mail on how to use Selenium like a Pro");
				System.out.println("The window switched to"+switched);
				break;
			}



		}


		/*
		 * Handling alerts
		 */
		driver.findElementByXPath("//button[text()='Click for JS Prompt']").click();

		//Switch to the alert
		driver.switchTo().alert().sendKeys("Im JS alert");
		driver.switchTo().alert().accept();

		/*
		 * Handling Frames
		 */

		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("Im a frame");

		/*
		 * Capture screenshot
		 */

		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./Screenshot/screenshot1.png"));

		/*
		 * File upload
		 */

		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\Local User\\eclipse-workspace\\training.jun19\\Screenshot\\Screenshot1.png");
		driver.findElement(By.id("file-submit")).click();

		//
	}

}
