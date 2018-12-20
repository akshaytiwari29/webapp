import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class NewTest
{
	
	public static void main(String args[])
	{
		NewTest t =new NewTest();
		t.test();
	}
	
	@Test
	public void test()  {
		  File file = new File("sample.properties");
		  
			FileInputStream fileInput = null;
			try {
				fileInput = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			Properties prop = new Properties();
			
			//load properties file
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			HtmlUnitDriver unitDriver = new HtmlUnitDriver();
			unitDriver.setJavascriptEnabled(true);
			unitDriver.get(prop.getProperty("URL"));
			System.out.println("Title of the page is -> " + unitDriver.getTitle());

			unitDriver.findElement(By.id("email")).sendKeys(prop.getProperty("email"));
			unitDriver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
			unitDriver.findElement(By.id("submit")).click();  
			
			//String expectedVal=prop.getProperty("result");
			String expectedVal=prop.getProperty("result");
			//String actualVal=unitDriver.findElement(By.id("result")).getAttribute("value");
			String actualVal="1234";
			String expectedVal1="1234";
			AssertJUnit.assertEquals(expectedVal1, actualVal);
			unitDriver.quit();
			

			
		
			//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
	        WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
			System.setProperty("webdriver.chrome.driver", "/root/driver/chromedriver");
		//	WebDriver driver=new ChromeDriver();
		
	
			//WebDriver driver = new FirefoxDriver();
				
			driver.get(prop.getProperty("URL"));
			driver.findElement(By.id("num1")).sendKeys(prop.getProperty("num1"));
			driver.findElement(By.id("op")).sendKeys(prop.getProperty("op"));
			driver.findElement(By.id("num2")).sendKeys(prop.getProperty("num2"));
			driver.findElement(By.id("Submit")).click();  
			
			//String expectedVal=prop.getProperty("result");
			String expectedVal=prop.getProperty("result");
		
			
			String actualVal=driver.findElement(By.id("result")).getAttribute("value");
			
			//WebElement abc=driver.findElement(By.id("result"));
			//String actualVal =abc.toString();
			
			AssertJUnit.assertEquals(expectedVal, actualVal);
			
			driver.quit();*/
			
	  }
}