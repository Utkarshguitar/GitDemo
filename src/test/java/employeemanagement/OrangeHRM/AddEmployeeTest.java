package employeemanagement.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddEmployeeTest extends Base {

	public WebDriverWait d;

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

	public void addNewEmployee() throws IOException, InterruptedException {

		// d.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
		Thread.sleep(5000);
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys("Utkarsh");
		driver.findElement(By.id("lastName")).sendKeys("Gupta");
		WebElement upload = driver.findElement(By.id("photofile"));

		upload.sendKeys(System.getProperty("user.dir") + "\\IMG_2882.jpg");

		driver.findElement(By.id("btnSave")).click();
		d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.id("branding")));

		WebElement listDriver = driver.findElement(By.id("mainMenuFirstLevelUnorderedList"));

		int l = listDriver.findElements(By.tagName("a")).size();

		for (int j = 1; j < l; j++) {
			String menuBar = listDriver.findElements(By.tagName("a")).get(j).getText();

			if (menuBar.equalsIgnoreCase("Dashboard")) {
				System.out.println(
						"User login is granted and redirected to the dashboard after successfully adding employee details");
			}
		}

	}

	@AfterTest

	public void teardown() {
		driver.quit();
	}
}
