package Add;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class editcategory {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/rahulmittapalli/Downloads/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://dev-pim.dermalogica.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("mittapalli.rahul@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		String valuechild = null;
		// System.out.println(driver.findElement(By.id("sidebar")).isDisplayed());
		WebElement nav = driver.findElement(By.id(("sidebar")));
		List<WebElement> list = nav.findElements(By.xpath("//ul[@class='list-unstyled components']/li"));
		System.out.println(list.size());
		for (int i = 1; i < list.size(); i++) {
			// list.get(i).click();
			Thread.sleep(2000);
			System.out.println(list.get(i).findElement(By.tagName("a")).getText());
			if (list.get(i).findElement(By.tagName("ul")) != null) {
				List<WebElement> child = list.get(i).findElements(By.tagName("li"));
				for (int j = 0; j < child.size(); j++) {
					// child.get(j).click();
					Thread.sleep(2000);
					// System.out.println(child.get(j).getText());
					if (child.get(j).getText().equals("Categories")) {
						child.get(j).click();
						Thread.sleep(5000);
						WebElement cat = driver.findElement(By.className("prods-box"));
						System.out.println(driver.findElement(By.cssSelector("#Categories"))
								.findElements(By.cssSelector("div.treeview>ul")).size());
						List<WebElement> category = cat.findElements(By.cssSelector("div.treeview>ul"));
						System.out.println(category.size());
						for (int k = 0; k < category.size(); k++) {
							System.out.println(k);
							System.out.println(category.get(k).getText());
							// System.out.println((category.get(k).getText().toString()).split(""));
							System.out.println(category.get(k).getText().replaceAll("[^a-zA-Z0-9\\s+]", "")
									.replaceAll("[-+.^:,]", "").trim());
							category.get(k).click();
							Thread.sleep(2000);
							System.out.println("parent clicked");
							// System.out.println(category.get(k).findElements(By.cssSelector("li>ul>li")).size());
							List<WebElement> catchild = category.get(k).findElements(By.cssSelector("li>ul>li"));
							System.out.println("child size is " + catchild.size());
							for (int l = 0; l < catchild.size(); l++) {
								catchild.get(l).click();
								String childvalue = catchild.get(l).getText().replaceAll("[^a-zA-Z0-9\\s+]", "")
										.replaceAll("[-+.^:,]", "").trim();
								System.out.println(childvalue);
								WebDriverWait wait = new WebDriverWait(driver, 10);
								wait.until(
										ExpectedConditions.visibilityOfElementLocated(By.className("fa-arrow-left")));
								driver.findElement(By.className("fa-arrow-left")).click();
								Thread.sleep(2000);
								 System.out.println(catchild.get(l).getText().split("+")[1]);
								 System.out.println("l value is " + l);
								 System.out.println("K value is " + k);
								 Thread.sleep(2000);
								catchild.get(l).click();
								Thread.sleep(3000);
								// if(childvalue.equals("hahah"))
								// {
								// catchild.get(l).click();
								// Thread.sleep(3000);
								// driver.findElement(By.xpath("//input[@class='category name']")).clear();
								// Thread.sleep(2000);
								// driver.findElement(By.xpath("//input[@class='category
								// name']")).sendKeys("YOYOYYO");
								// driver.findElement(By.className("fa-check")).click();
								// Thread.sleep(2000);
								// }
								// JavascriptExecutor js = (JavascriptExecutor)driver;
								// //js.executeScript();
							}
							Thread.sleep(5000);
							category.get(k).click();
							Thread.sleep(2000);
						}
						// driver.findElement(By.xpath("//a[@href='#/categories/add/0']")).click();
						// driver.findElement(By.xpath("//input[@placeholder='category
						// name']")).sendKeys("HELLO123");
						// Thread.sleep(3000);
						// driver.findElement(By.xpath("//button[@type='submit']")).click();
						// Thread.sleep(3000);
					}
				}
				break;
			}
			Thread.sleep(3000);
		}
		driver.close();
	}
}