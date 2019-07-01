package classroom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTestCase extends WebDriverTest {

	@Test
	public void searchIphone() {
		openBrowser("https://www.amazon.com");

		//Search for iphone
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
		

		//Get the list of iphones
		List<WebElement> listOfPhones = driver.findElements(By.tagName("h2"));

		//Print the list of phones
		int i =1;
		for (WebElement webElement : listOfPhones) {
			String phoneTitle = webElement.getText();
			if(phoneTitle.contains("Slim Case Compatible")) {
				webElement.click();
				break;
			}

			System.out.println(i+". "+phoneTitle);
			i++;

		}

		//Get the price
		String priceInDol = driver.findElement(By.id("priceblock_ourprice")).getText();
		System.out.println("The price valuue is: "+priceInDol);
		Assert.assertEquals("$49.99", priceInDol);
		
		//Get only the actual price 
		
		//Method1 - Substring
		String priceBySubstring = priceInDol.substring(1);
		System.out.println(priceBySubstring);
		
		//Method - 2 Split
		String [] princeBySplit = priceInDol.split("\\$");
		System.out.println(princeBySplit[1]);
		
		//Method 3 - Replace
		String princeByReplace = priceInDol.replace("$", " ");
		System.out.println(princeByReplace.trim());
		
		//Covert the string to float
		float actualPrice = Float.parseFloat(princeByReplace);
		float increment = actualPrice+10;	
		System.out.println(increment);
		
		driver.close();
	}

}
