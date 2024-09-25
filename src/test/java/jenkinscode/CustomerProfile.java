package jenkinscode;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CustomerProfile {
	WebDriver driver = new ChromeDriver();
	
	@BeforeClass
    public void setUp() {
    	ChromeOptions options = new ChromeOptions();
        // Set ChromeOptions to accept insecure certificates
        options.setAcceptInsecureCerts(true);

        // Initialize WebDriver with ChromeOptions
        driver = new ChromeDriver(options);
    }
	@Test
	public void customerregistertation() throws InterruptedException {

		// Maximize window

		driver.manage().window().maximize();

		// open swan application

		driver.get("https://app.swan.cx/app/customer-profile");

		Thread.sleep(2000);

		// Enter email address.

		driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");

		Thread.sleep(1000);

		// Enter password

		driver.findElement(By.id("pass")).sendKeys("Divya@1234567");

		Thread.sleep(2000);

		// click on Login Button .

		driver.findElement(By.xpath("//button[@id='btn']")).click();

		Thread.sleep(5000);

		// Click on customer profile .

		driver.findElement(By.xpath("//span[text()='Customer Profile']")).click();

		Thread.sleep(2500);

		// click on customer register.

		driver.findElement(By.xpath("//button[@class='ant-btn ng-star-inserted ant-btn-default']")).click();

		// fill first name , Last name and email address.

		driver.findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("Swan", Keys.TAB, "Automate",
				Keys.TAB, "automate@loyalytics.com");

		Thread.sleep(1000);

		// click on country code dropdown.

		driver.findElement(By.xpath("(//div[@unselectable='unselectable'])[1]")).click();

		Thread.sleep(1500);

		// Select Country code from the dropdown.

		driver.findElement(By.xpath("(//li[@unselectable='unselectable'])[177]")).click();

		// Enter Phone number.

		driver.findElement(By.xpath("(//input[@formcontrolname='mobile'])")).sendKeys("95822233411");

		// click on Date of birth column.

		driver.findElement(By.xpath("//input[contains(@placeholder,'date')]")).click();

		// Select date from calendar .

		driver.findElement(By.xpath("(//div[text()=' 10 '])[1]")).click();

		// Click on Nationality Dropdown.

		driver.findElement(By.xpath("//div[contains(text(),'Nationality')]")).click();

		// elect country from the dropdown .

		driver.findElement(By.xpath("(//li[@unselectable='unselectable'])[9]")).click();

		Thread.sleep(1500);

		// Click on Gender dropdown .

		driver.findElement(By.xpath("//div[text()='Please select your Gender']")).click();

		// Select Gender from dropdown .

		driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][1]")).click();

		// Click on Language Dropdown.

		driver.findElement(By.xpath("//div[text()='Please select your Language']")).click();

		Thread.sleep(1500);

		// Select Language from the drop down.

		driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][7]")).click();

		Thread.sleep(2000);

		// Enter value on Address column.

		driver.findElement(By.xpath("(//input[@Placeholder='Please enter value'])[1]"))
				.sendKeys("Bangalore Headquarters");

		// Click on Join Bispro drop down.

		driver.findElement(By.xpath("//div[text()='Please select your option']")).click();

		// Select value from the join bispro dropdown.

		driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][1]")).click();

		// Click on whatsapp preferences Enable button.

		driver.findElement(By.xpath("(//nz-button-group[contains(@class,'preferences ant-btn-group')])[4]//button[1]"))
				.click();

		Thread.sleep(1500);

		// Click on Register Button.

		driver.findElement(
				By.xpath("//button[@class='register-btn pull-right ant-btn ng-star-inserted ant-btn-default']"))
				.click();

		Thread.sleep(5000);

		// Logout

		driver.findElement(By.xpath("//i[@nztype='user']/..//span")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Logout']")).click();

		Thread.sleep(2500);

		// close the window.

		driver.close();

	}
}
