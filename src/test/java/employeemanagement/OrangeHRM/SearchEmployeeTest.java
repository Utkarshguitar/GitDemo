package employeemanagement.OrangeHRM;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchEmployeeTest extends Base {

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
	public void searchemployee() throws IOException, InterruptedException {

		// d.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_pim_viewPimModule")));
		Thread.sleep(5000);
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.id("empsearch_employee_name_empName")));
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(prop.getProperty("Name"));
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(Keys.ENTER);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBtn")));
		driver.findElement(By.id("searchBtn")).click();
		Thread.sleep(5000);
		WebElement tableDriver = driver.findElement(By.id("frmList_ohrmListComponent"));

		tableDriver.findElements(By.tagName("a")).size();

		WebElement columnDriver = tableDriver
				.findElement(By.xpath("//div[4]/table/thead/following-sibling::tbody/tr/td[3]"));

		int n = columnDriver.findElements(By.tagName("a")).size();

		for (int i = 0; i < n; i++) {
			String firstName = columnDriver.findElements(By.tagName("a")).get(i).getText();

			if (firstName.equalsIgnoreCase("Utkarsh")) {
				System.out.println("Employee name is appeared in the filtered employee list");
			}
		}

	}

	@AfterTest

	public void teardown() {
		driver.quit();
	}
}
