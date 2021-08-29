package Week2.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Radhe");
		driver.findElement(By.name("lastname")).sendKeys("Krishna");
		driver.findElement(By.name("reg_email__")).sendKeys("test@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("test@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Password@1357");
		
		WebElement day = driver.findElement(By.id("day"));
		Select dayDrpDwn = new Select(day);
		dayDrpDwn.selectByValue("1");
		
		WebElement month = driver.findElement(By.id("month"));
		Select monthDrpDwn = new Select(month);
		monthDrpDwn.selectByIndex(1);
		
		WebElement year = driver.findElement(By.id("year"));
		Select yearDrpDwn = new Select(year);
		yearDrpDwn.selectByValue("1990");
		
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
		driver.findElement(By.name("websubmit")).click();
	
		
		

		
	}

}
