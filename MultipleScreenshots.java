import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MultipleScreenshots 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ph.jobstreet.com/");
		takeScreenshot(driver, "Step1_AccessEmployeebPage"); //Screenshot syntax for each step

		driver.findElement(By.xpath("(//span[normalize-space()='Employer site'])[2]")).click();
		Thread.sleep(3000);
		takeScreenshot(driver, "Step2_AccessEmployerPage"); //Screenshot syntax for each step
	}
	
	//Screenshot syntax in new block / method
	public static void takeScreenshot(WebDriver driver, String screenshotName) {
	    File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File destFile = new File("C:\\Users\\JC\\Pictures\\Automation Screenshots\\" + screenshotName + "_" + timestamp + ".png");
	    try {
	        FileHandler.copy(srcFile, destFile);
	        System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
