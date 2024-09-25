package jenkinscode;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class jouneryworkflow {

	public void testLogin() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		// Maximize window

		driver.manage().window().maximize();

		// implicit time

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// open swan application

		driver.get("https://app.swan.cx/login");

		// Thread.sleep(2000);

		// Enter email address.

		driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");

		// Thread.sleep(1000);

		// Enter password

		driver.findElement(By.id("pass")).sendKeys("Divya@1234567");

		// Thread.sleep(2000);

		// click on Login Button .

		driver.findElement(By.xpath("//button[@id='btn']")).click();

		Thread.sleep(5000);

		// Navigate to Journey Workflows
		WebElement sidebar = driver.findElement(By.xpath("//a[normalize-space()='']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(sidebar).perform();

		driver.findElement(By.xpath("//span[normalize-space()='Journey Workflows']")).click();

		// Search Journey
		WebElement searchJourney = driver.findElement(By.xpath("//input[@placeholder='Search Journeys']"));
		Thread.sleep(4000);
		actions.moveToElement(searchJourney).perform();

		// Create Journey
		WebElement createJourneyButton = driver.findElement(By.xpath(
				"//button[@class='view-journey-container-header__create-btn ant-btn ant-btn-default ant-btn-round']"));
		createJourneyButton.click();
		Thread.sleep(2000);

		// Start from Scratch
		WebElement startFromScratch = driver.findElement(By.xpath("//span[normalize-space()='Start From Scratch']"));
		Thread.sleep(2000);
		actions.moveToElement(startFromScratch).perform();
		driver.findElement(By.xpath("//app-templates-showcase-card[1]//div[2]//button[1]")).click();
		Thread.sleep(5000);

		// Drag and drop components to canvas
		Actions actions1 = new Actions(driver);
		WebElement segmentTrigger = driver.findElement(By.xpath("(//div[@draggable='true'])[1]"));
		actions1.dragAndDropBy(segmentTrigger, 300, 180).perform();

		WebElement attributeFilter = driver.findElement(By.xpath("(//div[@draggable='true'])[18]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", attributeFilter);
		actions1.dragAndDropBy(attributeFilter, 600, 130).perform();

		WebElement emailAction = driver.findElement(By.xpath("(//div[@draggable='true'])[9]"));
		actions1.dragAndDropBy(emailAction, 900, -200).perform();

		WebElement endJourney = driver.findElement(By.xpath("(//div[@draggable='true'])[22]"));
		actions1.dragAndDropBy(endJourney, 1250, -140).perform();
		actions1.dragAndDropBy(endJourney, 900, -70).perform();

			
		// Connecting components
		Actions actions11 = new Actions(driver);
		WebElement segmentPointer = driver.findElement(By.xpath("//*[@port='Segment']"));
		WebElement attributeFilterInPort = driver.findElement(By.xpath("/descendant::*[@port='in_port_id'][1]"));
		actions11.dragAndDrop(segmentPointer, attributeFilterInPort).perform();
Thread.sleep(2000);
		WebElement attributeFilterYesPointer = driver.findElement(By.xpath("//*[@port='Yes']"));
		WebElement emailInPort = driver.findElement(By.xpath("/descendant::*[@port='in_port_id'][2]"));
		actions11.dragAndDrop(attributeFilterYesPointer, emailInPort).perform();

		WebElement emailPointer = driver.findElement(By.xpath("//*[@port='On Send']"));
		WebElement endJourney1InPort = driver.findElement(By.xpath("/descendant::*[@port='in_port_id'][3]"));
		actions11.dragAndDrop(emailPointer, endJourney1InPort).perform();

		WebElement attributeFilterNoPointer = driver.findElement(By.xpath("//*[@port='No']"));
		WebElement endJourney2InPort = driver.findElement(By.xpath("/descendant::*[@port='in_port_id'][4]"));
		actions11.dragAndDrop(attributeFilterNoPointer, endJourney2InPort).perform();

		System.out.println("Successfully Established connection between Components");
		
		
}}
