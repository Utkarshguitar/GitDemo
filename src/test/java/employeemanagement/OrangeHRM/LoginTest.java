package employeemanagement.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends Base {
	@BeforeTest
	public void intialise() throws IOException {
		driver = initialiseDriver();

		driver.get(prop.getProperty("URL"));

		driver.findElement(By.id("txtUsername")).click();
		driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("UserID"));

		driver.findElement(By.id("txtPassword")).click();
		driver.findElement(By.id("txtPassword")).sendKeys(prop.getProperty("Password"));

		driver.findElement(By.id("btnLogin")).click();
	}

	@Test

	public void loginPage() throws IOException {

		WebElement listDriver = driver.findElement(By.id("mainMenuFirstLevelUnorderedList"));

		int l = listDriver.findElements(By.tagName("a")).size();

		for (int j = 1; j < l; j++) {
			String menuBar = listDriver.findElements(By.tagName("a")).get(j).getText();

			if (menuBar.equalsIgnoreCase("Dashboard")) {
				System.out.println("User login is granted and redirected to the dashboard after login successfully");
			}
		}

	}

	@AfterTest

	public void teardown() {
		driver.quit();
	}
}
