package Add;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class addapikey {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		login credentials = new login();
		credentials.logindetails(driver);
		sidebarmenu sd = new sidebarmenu();
		sd.sidebar(driver, "Applications", "API Keys");
		driver.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='application name']")).sendKeys("APP12");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='enter URL']")).sendKeys("URL1");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.close();
	}
}