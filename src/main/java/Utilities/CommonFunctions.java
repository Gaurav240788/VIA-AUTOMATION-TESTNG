package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;

import GenericFunctions.BaseTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;

public class CommonFunctions 
{
	public WebDriver driver;
	public static WebDriverWait wait;
	public static Properties testdata;

	// Constructor
	public CommonFunctions(WebDriver driver) 
		{
			this.driver = driver;
			wait = new WebDriverWait(driver, 10);
		}	
	
	// Input Text
	public void inputText(By elementBy, String text, String data) 
		{
			try 
				{
					waitVisibility(elementBy);
					WebElement ele = driver.findElement(elementBy);
					ele.click();
					ele.clear();
					int i;
					for (i = 0; i < text.length(); i++) 
						{
							ele.sendKeys(Character.toString(text.charAt(i)));
							wait.until(ExpectedConditions.attributeContains(ele, "value", text.substring(0, i)));
							Thread.sleep(10);
						}
				}
			catch (Exception e) 
				{

					System.out.println(data + " not entered successfully--------Error Message: " + e.getMessage());
					Assert.fail(data + " not entered successfully--------Error Message: " + e.getMessage());
				}
	}
	
	// Wait Wrapper Method
	public static void waitVisibility(By elementBy) 
		{
		try 
			{
				wait.until(ExpectedConditions.or(ExpectedConditions.presenceOfElementLocated(elementBy),
				ExpectedConditions.elementToBeClickable(elementBy)));
			} 
		catch (Exception e) 
			{
				System.out.println("Not able to find " + elementBy + "--------Error Message: " + e.getMessage());
				Assert.fail("Not able to find " + elementBy + "--------Error Message: " + e.getMessage());
			}
		}
	
	// Click Method
	public void click(By elementBy, String clickableElement) 
		{
			try 
				{
					waitVisibility(elementBy);
					driver.findElement(elementBy).click();
				} 
			catch (Exception e) 
				{
					System.out.println(clickableElement + " Not Clickable--------Error Message: " + e.getMessage());
					Assert.fail(clickableElement + " Not Clickable--------Error Message: " + e.getMessage());
				}
		}
	
	public void sendkeys(By by, WebDriver driver, int wait, String string )
		{
			common_wait(wait,by,driver);
			driver.findElement(by).sendKeys(string);
		}
	
	public void common_wait(int wait,By by, WebDriver driver)
		{		
			WebDriverWait w2= new WebDriverWait(driver, wait);
			w2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));				
		}
	
	// this method will get local(xpath/ID) value	
	public static String getlocval(String keylocval) throws IOException
		{
			String path = BaseTest.locator.getProperty(keylocval);
			return path;		
		}
	
	// this method will get test data value
	public static String getdataval(String keydataval) throws IOException
		{
			String path = BaseTest.prop.getProperty(keydataval);
			return path;		
		}
	
	public void click(By by, WebDriver driver, int wait)
		{
			common_wait(wait,by,driver);
			driver.findElement(by).click();
		}
	
	public void sendkeys(By by, WebDriver driver, String string, String data)
		{
			try
				{
				waitVisibility(by);
				WebElement ele = driver.findElement(by);
				ele.click();
				ele.clear();
				int i;
				for (i = 0; i < string.length(); i++) 
					{
						ele.sendKeys(Character.toString(string.charAt(i)));
						wait.until(ExpectedConditions.attributeContains(ele, "value", string.substring(0, i)));
						//wait(10);
						//driver.findElement(by).sendKeys(string);
					}
				//ExtentTestManager.getTest().log(Status.PASS, data + " successfully entered");
				}
		catch (Exception e) 
			{
				//attachScreenshotWithReport();
				//ExtentTestManager.getTest().log(Status.FAIL,data + " not entered successfully--------Error Message: " + e.getMessage());
				System.out.println(string + " not entered successfully--------Error Message: " + e.getMessage());
				Assert.fail(string + " not entered successfully--------Error Message: " + e.getMessage());
			}
		}
	
	public void click(By by, WebDriver driver, String clickableElement)
		{
			try 
				{
					waitVisibility(by);
					driver.findElement(by).click();
				} 
			catch (Exception e) 
				{
					System.out.println(clickableElement + " Not Clickable--------Error Message: " + e.getMessage());
					Assert.fail(clickableElement + " Not Clickable--------Error Message: " + e.getMessage());
				}
		}
	
	public void waitForElement(By elementBy, int seconds) 
		{
			try 
				{
					WebDriverWait wait1 = new WebDriverWait(driver, seconds);
					wait1.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
				} 
			catch (Exception e) 
				{
					System.out.println("Not able to find " + elementBy + "--------Error Message: " + e.getMessage());
					Assert.fail("Not able to find " + elementBy + "--------Error Message: " + e.getMessage());
				}
		}
	
	public void wait(int wait) throws InterruptedException
		{
			//Thread.sleep(wait);
			driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
		}
	
	// Method for extracting text value
	public String getText(By elementBy) 
		{
			String elementText = null;
				try 
					{
						waitVisibility(elementBy);
						elementText = (driver.findElement(elementBy)).getText();
					} 
				catch (Exception e) 
					{
						System.out.println(" Not able to extract element--------Error Message:" + e.getMessage());
						Assert.fail(" Not able to extract element--------Error Message:" + e.getMessage());
					}
				return elementText;
		}
	public void verifyLogin(By by, WebDriver driver, String expectedResult)
		{
		try 
			{
				waitVisibility(by);
				//Assert.assertEquals(getText(by), "Via by Watermark");
				Assert.assertEquals(getText(by), expectedResult);
			} 
		catch (Exception e) 
			{
				e.getMessage();
			}
		}
	
	public void verifyImport(By by, WebDriver driver)
		{
			try
				{
					Assert.assertFalse(driver.findElements(By.xpath(".//*[@id='wrap']/article/div/div[1]/div[2]/div/div[1]/div[5]/label")).size()>0, "There is an issue in Import");
					wait(5);
				}
			catch (Exception e)
				{
					e.getMessage();
				}
		}
	
	public static String TestDataFile(String key) throws IOException
		{
			String filepath=System.getProperty("user.dir")+"/src/main/java/Properties/TestData.properties";
			testdata = new Properties();
			FileInputStream in=new FileInputStream(new File(filepath));
			testdata.load(in);
			String value= testdata.getProperty(key);
			String pathToFile = System.getProperty("user.dir") + value;
			return pathToFile;		
		}
	
	public void uploadFiles(By by, WebDriver driver, String filepath)
		{
			try
				{
					WebElement ele = driver.findElement(by);
					waitVisibility(by);
					ele.sendKeys(filepath);
				}
			catch (Exception e)
				{
					System.out.println("Not able to import file--------Error Message:" + e.getMessage());
					Assert.fail("Not able to import file--------Error Message:" + e.getMessage());
				}
		}
}
