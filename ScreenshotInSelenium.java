import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotInSelenium 
{
	public static void main(String[] args) throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //Casting driver object to take screenshot
		FileUtils.copyFile(src,new File("C:\\Users\\JC\\Pictures\\Automation Screenshots\\Screenshots.png")); //Source file that the screenshot will be stored

	}
}
