package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	
	public static void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		driver.get("http://techfios.com/test/101/");

		}
	public static void takeScreenshot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts =(TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		String currentDirectory=System.getProperty("user.dir");
		
		SimpleDateFormat formatter= new SimpleDateFormat("MMDDYY_HHmmss");
		Date date =new Date();
		String lable = formatter.format(date);
		
		FileUtils.copyFile(sourceFile, new File(currentDirectory+"/screenshot/"+lable+".png"));
	}
}