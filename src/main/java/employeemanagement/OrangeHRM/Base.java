package employeemanagement.OrangeHRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initialiseDriver() throws IOException {
		prop = new Properties();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\employeemanagement\\OrangeHRM\\data.properties");
		
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}
	

}
