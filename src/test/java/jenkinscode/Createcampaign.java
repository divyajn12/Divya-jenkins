package jenkinscode;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
@Test

public class Createcampaign
{
	EdgeDriver driver = new EdgeDriver();
	    public void createcampign() throws InterruptedException
	    {
	        // Maximize window
	        driver.manage().window().maximize();
	        // Open swan application
	        driver.get("https://app.swan.cx/login");
	        // Enter email address
	        driver.findElement(By.id("email")).sendKeys("divya.jain@loyalytics.in");
	        // Enter password
	        driver.findElement(By.id("pass")).sendKeys("Divya@1234567");
	        // Click on Login Button
	        driver.findElement(By.xpath("//button[@id='btn']")).click();
	        // Explicit wait for the Create Campaigns element to be clickable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
	        WebElement createCampaignButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Create Campaigns']")));
	        // Use JavaScript to click the button
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", createCampaignButton);
	        // Wait for the page to load
	       Thread.sleep(3500);
	        // Click on the create button
	        driver.findElement(By.xpath("//div[@class='campaign_button ant-col ant-col-3']//button[@id='createBtn']")).click();
	        // Enter campaign name
	        driver.findElement(By.xpath("//input[@placeholder='name']")).sendKeys("Divya");
	        // Select campaign subtype
	        WebElement clicksubtype = driver.findElement(By.cssSelector("div[unselectable='unselectable']"));
	        clicksubtype.click();
	        WebElement selectoption = driver.findElement(By.cssSelector("li[class='ant-select-dropdown-menu-item ng-star-inserted']:nth-child(1)"));
	        selectoption.click();
	        // Click the Next button
	        WebElement clicknextbutton = driver.findElement(By.cssSelector("button[class='next pull-right ant-btn ng-star-inserted ant-btn-default']"));
	        clicknextbutton.click();
	        // Select date type
	        WebElement selectdatetype = driver.findElement(By.xpath("//div[text()='Select date Type']"));
	        selectdatetype.click();
	        WebElement Selectoption = driver.findElement(By.cssSelector("li[class='ant-select-dropdown-menu-item ng-star-inserted']:nth-child(2)"));
	        Selectoption.click();
	        // Select dynamic date period
	        Thread.sleep(2500);
	        WebElement clickdynamicoption = driver.findElement(By.xpath("//div[text()='Select Dynamic Date period']"));
	        clickdynamicoption.click();
	        WebElement Selectoptionofdynamicddown = driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][1]"));
	        Selectoptionofdynamicddown.click();
	        // Enter start and end dates
	        WebElement Enterstartdate = driver.findElement(By.id("campaignArray.validFrom"));
	        Enterstartdate.sendKeys("2");
	        WebElement Enterenddate = driver.findElement(By.xpath("//input[@formcontrolname='validTo']"));
	        Enterenddate.sendKeys("3");
	        // Click the All Days checkbox
	        WebElement Alldayscheckbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
	        Alldayscheckbox.click();
	       
	       
	        Actions a = new Actions(driver);    //////////////////
			a.moveToElement(driver.findElement(By.xpath("//input[@formcontrolname='allStores']"))).build().perform(); ////////////
			
			
	        // Click on start time using JavaScript if overlay persists
	        WebElement clickselectelecttime = driver.findElement(By.xpath("(//input[@placeholder='Select time'])[1]"));
	        JavascriptExecutor js1 = (JavascriptExecutor) driver;
	        js1.executeScript("arguments[0].click();", clickselectelecttime);
	         // Select start time from the dropdown using JavaScript to avoid overlay issues
	        WebElement selectstarttime = driver.findElement(By.xpath("(//li[@class='ant-time-picker-panel-select-option-selected ng-star-inserted'])[1]"));
	         js1.executeScript("arguments[0].click();", selectstarttime);
	         Thread.sleep(200);
	        
	         a.moveToElement(driver.findElement(By.xpath("//label[text()='End Time ']"))).click().build().perform();//////////
	         driver.findElement(By.xpath("(//input[@placeholder='Select time'])[2]")).click();////////////
	         Thread.sleep(2000);
	         driver.findElement(By.xpath("(//li[@class='ant-time-picker-panel-select-option-selected ng-star-inserted'])[1]")).click();////////////
	         Thread.sleep(2000);
	        
	         a.moveToElement(driver.findElement(By.xpath("//label[text()='End Time ']"))).click().build().perform();/////////////
	        driver.findElement(By.xpath("//input[@formcontrolname='allStores']")).click();
	       
	       
	          Thread.sleep(2000);
			  // click on select all products
             driver.findElement(By.xpath("//input[@formcontrolname='allProducts']")).click();
             //click on next button
             driver.findElement(By.xpath("//button[@class='next pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
             
             
             // Click on offer type
             driver.findElement(By.xpath("//nz-select[@formcontrolname='couponType']")).click();

             // Click on percent option
             driver.findElement(By.xpath("//li[@class='ant-select-dropdown-menu-item ng-star-inserted'][1]")).click();

             // Click and enter discount
             driver.findElement(By.xpath("//input[@onkeypress='return event.charCode >= 48']")).sendKeys("10"); // Enter discount value

             // Click and enter threshold
             driver.findElement(By.xpath("//input[@formcontrolname='threshold']")).sendKeys("100"); // Enter threshold value

             // Click and enter max discount
             driver.findElement(By.xpath("//input[@formcontrolname='maxDiscount']")).sendKeys("50"); // Enter max discount value

             // Click on not valid for already discounted items checkbox
             driver.findElement(By.xpath("//input[@formcontrolname='fullPrice']")).click();

             // Click on next button
             driver.findElement(By.xpath("//button[@class='next pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
             
             // Add a wait if necessary or verification steps
             
          // Click on coupon label and enter value
             driver.findElement(By.xpath("//input[@placeholder='Enter Coupon Label']")).sendKeys("Coupon2024");

             // Click and enter description
             driver.findElement(By.xpath("//textarea[@nzplaceholder='Enter Campaign Description...']")).sendKeys("This is a special campaign description");

             // Click and enter terms and conditions
             driver.findElement(By.xpath("//textarea[@formcontrolname='termsAndConditions']")).sendKeys("Terms and conditions apply");

             // Click on next button
             driver.findElement(By.xpath("//button[@class='next pull-right ant-btn ng-star-inserted ant-btn-default']")).click();

             // Click on submit button
             driver.findElement(By.xpath("//button[@class='button pull-right ant-btn ng-star-inserted ant-btn-default']")).click();
driver.quit();
      
	    }
	
}