package Week2.Day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		
/************************************ Create lead First section************************************************************/
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Cognizant"); //Enter Company Name
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Raja"); //Enter Forename
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("raman"); //Enter Surname

		// Create webElement for Source and pass it to the Select Class and SelectByIndex
		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select drop1 = new Select(source);
		drop1.selectByIndex(1);

		// Create webElement for Marketing Campaign and pass it to the Select Class and SelectByValue
		WebElement marketingCampaign = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select drop2 = new Select(marketingCampaign);
		drop2.selectByValue("CATRQ_AUTOMOBILE");

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("raja"); //Enter First Name (Local)
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("raman"); //Enter Last Name (Local)
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mr"); //Enter Salutation 
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("08/15/21"); //Enter Date of birth
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("Test Title"); //Enter Title
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Quality Assurance"); //Enter Department 
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("2 Billion"); //Enter Annual Revenue

		// Create webElement for Preferred Currency and pass it to the Select Class and SelectByValue 
		WebElement PreferredCurr = driver.findElement(By.id("createLeadForm_currencyUomId")); //
		Select prefcuurencyDrpDwn = new Select(PreferredCurr);
		prefcuurencyDrpDwn.selectByValue("USD");

		//Create webElement for Industry and pass it to the Select Class and SelectByVisibleText
		WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select drop3 = new Select(industry);
		drop3.selectByVisibleText("Health Care");
		
		
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("290000"); ////Enter Number of Employees
		
		//Create webElement for Ownership and pass it to the Select Class and SelectByIndex
		WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownerDrpDwn = new Select(ownership);
		ownerDrpDwn.selectByIndex(1);
		
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("ABCD1234"); //Enter SIC Code
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("testing123"); //Enter Ticker Symbol
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is a test description"); //Enter Description
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("This is an Important Note"); //Enter Important Note
		
/*********************** Create lead - Contact Information section******************************************************/
		
		//Create webElement for Country Code and Clear the existing values and enter new value
		WebElement countryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		countryCode.clear();
		countryCode.sendKeys("5");
		
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("+91"); //Enter Area Code
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9952952280"); //Enter Phone Number
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("471234");  //Enter Extension
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Test Name"); //Enter Person to Ask For
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test@gmail.com"); //Enter E-Mail Address
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://Www.testdomain.com"); //Enter Web Url
		
		
/*********************** Create lead - Primary Address section******************************************************/	
		
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Braian"); //Enter To Name
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Humpies"); //Enter Attention Name
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Test Address1"); //Enter Address Line 1
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Test Address 2"); //Enter Address Line 2
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("California"); //Enter City
		
		//Create webElement for State/Province and pass it to the Select Class and SelectByVisibleText
		WebElement stateOrProvince = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateOrProviceDrpDwn = new Select(stateOrProvince);
		stateOrProviceDrpDwn.selectByVisibleText("Alabama");
		
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("43F J124"); //Enter Postal Code
		
		//Create webElement for Country and pass it to the Select Class and SelectByValue
		WebElement country = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select countryDrpDwn = new Select(country);
		countryDrpDwn.selectByValue("USA");
		
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("600100"); //Enter Zip/Postal Code Extension
		driver.findElement(By.className("smallSubmit")).click(); // Click on Create lead
		
		String expectedPageTitle = "View Lead | opentaps CRM";
		String landingPage = driver.getTitle();
		if(expectedPageTitle.equals(landingPage))
			{
				System.out.println("Test case passed Sucessfuly. Lead created!");	
			} 
			else {
				System.out.println("Test case failed. Lead not created successfully!");
			}
			
		
		}

}
