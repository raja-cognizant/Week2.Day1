package Week2.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='UserFirstName']")).sendKeys("raja");
		driver.findElement(By.xpath("//input[@name='UserLastName']")).sendKeys("Raman");
		driver.findElement(By.xpath("//input[@name='UserEmail']")).sendKeys("test@test.com");
		
		WebElement jobTitle = driver.findElement(By.xpath("//select[@name='UserTitle']"));
		Select jobTitleDrpDwn = new Select(jobTitle);
		jobTitleDrpDwn.selectByValue("Marketing_PR_Manager_AP");
		
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TESTLEAF");
		
		WebElement employees = driver.findElement(By.xpath("//select[@name='CompanyEmployees']"));
		Select employeeDrpDwn = new Select(employees);
		employeeDrpDwn.selectByValue("1600");
		
		driver.findElement(By.xpath("//input[@name='UserPhone']")).sendKeys("9952952280");
		
		WebElement country = driver.findElement(By.xpath("//select[@name='CompanyCountry']"));
		Select countryDrpDwn = new Select(country);
		countryDrpDwn.selectByValue("IN");
		
		driver.findElement(By.xpath("(//input[@id='SubscriptionAgreement']/following-sibling::div)[1]")).click();
		
		
	}

}
