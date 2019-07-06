package servicenow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import classroom.WebDriverTest;
import utility.ReadExcel;

public class CreateIncident extends WebDriverTest {

	@Test()
	public void createNewIncident() {
		/*
		 * This test case creates a new incident
		 * @ Data - User credential 
		 */	

		//Read the data
		String[][] testData = ReadExcel.readExcelData("TestData");

		//Launch application
		openBrowser("https://dev61245.service-now.com/");

		//Switch to frame
		driver.switchTo().frame("gsft_main");

		//Login
		driver.findElement(By.id("user_name")).clear();
		driver.findElement(By.id("user_name")).sendKeys(testData[0][0]);
		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys(testData[0][1]);
		driver.findElement(By.id("sysverb_login")).click();

		//Verify login is successful
		boolean isLoginSucceeded = driver.findElement(By.xpath("//span[text()='System Administrator']")).isDisplayed();
		if(isLoginSucceeded) {
			System.out.println("****Login Sucessful*****");
		}else {
			System.out.println("****Login failed******");
		}

		//Search the keyword 'incident'
		driver.findElement(By.id("filter")).click();
		driver.findElement(By.id("filter")).sendKeys("Incident");
		driver.findElement(By.linkText("Create New")).click();

		//Store the parent window
		String parentWindow = driver.getWindowHandle();
		System.out.println("**The parent window is "+parentWindow);

		//Switch to frame
		driver.switchTo().frame("gsft_main");

		//Fill in the form 
		String incidentNumReInitial = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println("The incident number is "+incidentNumReInitial);
		driver.findElement(By.id("lookup.incident.caller_id")).click();

		//Switch to child window
//				Set<String> winHandles = driver.getWindowHandles();
//				System.out.println("Total window opened "+winHandles.size());
//				for (String winHandle : winHandles) {
//					if(driver.switchTo().window(winHandle).getTitle().equals("Users | ServiceNow")){
//						driver.switchTo().window(winHandle);
//		
//					}
//				}


		//Switch to child window

		switchToChildWin();
		driver.findElement(By.xpath("//tbody[@class='list2_body']/*[1]/td/a")).click();

		//Switch back to the parent window and frame
		driver.switchTo().window(parentWindow);
		driver.switchTo().frame("gsft_main");

		//Select category
		WebElement categoryDropdown = driver.findElement(By.id("incident.category"));
		selectValByVisibileText(categoryDropdown, "Software");
//
//		//Select sub category 
//		WebElement subcategoryDropdown = driver.findElement(By.id("incident.subcategory"));
//		selectValByVisibileText(subcategoryDropdown, "Email");
//
//		//Click on lookup Business icon
//		driver.findElement(By.id("lookup.incident.business_service")).click();
//
//		//Switch to the child window and search for 'Outlook'
//		switchToChildWin();
//		driver.findElement(By.xpath("//input[@placeholder='Search' and @class='form-control']"))
//		.sendKeys("Outlook", Keys.ENTER);
//		driver.findElement(By.xpath("//a[text()='Outlook Web Access (OWA)']")).click();
//
//		//Switch back to the parent window and frame
//		driver.switchTo().window(parentWindow);
//		driver.switchTo().frame("gsft_main");
//
//		//Select contact type
//		WebElement contactType = driver.findElement(By.id("incident.contact_type"));
//		selectValByVisibileText(contactType, "Email");
//
//		//Select impact
//		WebElement impact = driver.findElement(By.id("incident.impact"));
//		selectValByVisibileText(impact, "1 - High");
//
//		//Select urgency
//		WebElement urgency = driver.findElement(By.id("incident.urgency"));
//		selectValByVisibileText(urgency, "1 - High");
//
//		//Verify the priority field is disabled
//		boolean isPriorityEnabled = driver.findElement(By.id("incident.priority")).isEnabled();
//		Assert.assertTrue(isPriorityEnabled, "The priority field is not disabled");
//
//		//Enter description 
//		driver.findElement(By.id("incident.description"))
//		.sendKeys("Email could not be configured for my machine");
//
//		//Click on submit 
//		driver.findElement(By.id("sysverb_insert_bottom")).click();
//
//		//Verify alert message
//		String alertMessage = driver.findElement(By.xpath("(//div[@role='alert']/span)[2]")).getText();
//		Assert.assertTrue(alertMessage.equals("The following mandatory fields are not filled in: Short description"), "Alert message is not verified");
//
//		//Re-submit 
//		driver.findElement(By.id("incident.short_description")).sendKeys("Email issue");
//		driver.findElement(By.id("sysverb_insert_bottom")).click();
//
//		//Store the incident number to property file
//		writeToPropertyFile(incidentNumReInitial);
//		
//		//Close the driver
//		driver.close();
	}

}
