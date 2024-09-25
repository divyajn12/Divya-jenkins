package jenkinscode;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class createrewardweekdayusingcampign {
	WebDriver driver;
	WebDriverWait wait;

	public void openBrowser() throws Exception {
		// Launch Chrome browser and navigate to Make My Trip Site
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open Swan application
		driver.get("https://app.swan.cx/login");
		// Enter email address.
		driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
		// Enter password
		driver.findElement(By.id("pass")).sendKeys("Divya@1234567");
		// Click on Login Button
		driver.findElement(By.xpath("//button[@id='btn']")).click();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);

		// Click on Loyalty Rewards
		driver.findElement(By.xpath("//span[normalize-space()='Loyalty Rewards']")).click();
		Thread.sleep(2000);
		// Click on create rewards
		driver.findElement(
				By.xpath("//div[@class='dynamic-navbar__register ant-col ant-col-5']//button[@id='createBtn']"))
				.click();

		// Fill in Voucher Name
		WebElement voucherNameInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter voucher name']")));
		voucherNameInput.sendKeys("Discountsep2024");
		// Set Voucher Validity Start Date
		WebElement startDatePicker = driver.findElement(By.xpath("//input[@placeholder='Start date']"));
		startDatePicker.click();
		String checkInmonth = "sep 2024";
		String dateval = "20";
		while (true) {
			String month = driver.findElement(By.xpath(
					"//div[@class='ant-calendar-range-left ant-calendar-range-part ng-star-inserted']//div//div[@class='ant-calendar-header']"))
					.getText();
			if (month.equals(checkInmonth)) {
				break;
			} else {
				driver.findElement(By.xpath(
						"//div[@class='ant-calendar-range-part ant-calendar-range-right ng-star-inserted']//div//inner-popup[@class='ng-star-inserted']//calendar-header//div[@class='ant-calendar-header']//div//a[@title='Next month (PageDown)']"))
						.click();
			}
			List<WebElement> ele = driver.findElements(By.xpath("(//tbody)[1]//tr//td/div"));
			for (WebElement element : ele) {
				String date = element.getText();
				if (date.equals(dateval)) {
					element.click();
					break;
				}
			}
		}

	}

	@Test
	public void state() throws Exception {

		// Reward Earning Conditions attributes
		driver.findElement(By.xpath("//nz-select[@formcontrolname='primary']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Week Days']")).click();

		/// select days any day
		driver.findElement(By.xpath("//nz-select[@formcontrolname='primaryMatchValue']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Wednesday']")).click();
		driver.findElement(By.xpath("//li[normalize-space()='Tuesday']")).click();
				
		// close the dropdown
		driver.findElement(By.xpath(
				"//div[@class='cdk-overlay-backdrop nz-overlay-transparent-backdrop cdk-overlay-backdrop-showing']"))
				.click();
		Thread.sleep(2000);
		// start date and end date

		// Configure Reward
		driver.findElement(By.xpath("//nz-select[@id='selectCamp']")).click();
		// select value for drop down
		driver.findElement(By.xpath("//li[normalize-space()='test19']")).click();// Reward Earning Conditions attributes
		// close the dropdow
		// Thread.sleep(2000);

		WebElement sv = driver
				.findElement(By.xpath("//button[@class='create-voucher ant-btn ng-star-inserted ant-btn-primary']"));
		sv.click();
	}

}