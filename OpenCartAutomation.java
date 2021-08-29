package Week2.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCartAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().minimize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		driver.findElement(By.id("input-username")).sendKeys("USER9087");
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("RAJA");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Raman");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("test@test.com");
		
		WebElement country = driver.findElement(By.id("input-country"));
		Select countryDrpDwn = new Select(country);
		countryDrpDwn.selectByValue("233");
		
		driver.findElement(By.id("input-password")).sendKeys("PASSWORD1357");
		

	}

}
