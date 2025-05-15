import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialScreenshot 
{
	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.TAB); //Opening a new tab
		//driver.switchTo().newWindow(WindowType.WINDOW); //Opening a new window
		
		Set <String> tabs = driver.getWindowHandles(); //Set method for handling windows and tabs
		Iterator <String> it = tabs.iterator(); //Iterator method to store each tab
		String mainTab = it.next(); //1st browser tab stored in 1 variable (current tab position)
		String subTab = it.next(); //2nd browser tab stored in 1 variable also
		driver.switchTo().window(subTab); //Switch to 2nd browser tab
		driver.get("https://rahulshettyacademy.com/"); //Access the link on the 2nd browser tab
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p/']")).get(1).getText(); //Get the text of element on the 1st index
		driver.switchTo().window(mainTab); //Switching back to 1st browser tab
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName); //Input get text in the field
		
		//Take a partial screenshot (must have .jar files from https://mvnrepository.com/artifact/commons-io/commons-io)
		File file = name.getScreenshotAs(OutputType.FILE); //Capture partial screenshot
		FileUtils.copyFile(file, new File("logo.png")); //Converts to physcial file 
	}
}
