package GenericFunctions;

import VIA_Module_Pages.ImportPage;
import VIA_Module_Pages.LoginPage;
import Utilities.CommonFunctions;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

public class BaseTest 
{
	public static Logger logger;
	static String browser_name;
	static FileInputStream filestream;
	static File configfile;
	public static Properties prop;
	public static Properties locator;
	public LoginPage loginPage;
	public ImportPage importPage;

	public static WebDriver driver;
	
	@BeforeClass
	public void classLevelSetup() {

		try {
			FileInputStream filestream = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\Properties\\DataFile.properties");
			//System.out.println("read data from given file path");
			String downloadFilePath = System.getProperty("user.dir")+"\\filedownloads";
    		HashMap<String,Object> chromePrefs = new HashMap<String,Object>();
			prop = new Properties();
			try {
				prop.load(filestream);
			} catch (IOException e) {
				e.printStackTrace();
			}
			browser_name = prop.getProperty("browser");
				if (browser_name.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
					chromePrefs.put("download.default_directory", downloadFilePath);
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", chromePrefs);
		    		//options.setCapability(ChromeOptions.CAPABILITY, options);
					driver = new ChromeDriver(options);
					driver.manage().window().maximize();
					//System.out.println("chrome initialized");
				} else if (browser_name.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					System.out.println("firfox initialize");
				} else if (browser_name.equalsIgnoreCase("headless-chrome")) {
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
					chromePrefs.put("download.default_directory", downloadFilePath);
					ChromeOptions options = new ChromeOptions();
					options.setExperimentalOption("prefs", chromePrefs);
		    		//options.setCapability(ChromeOptions.CAPABILITY, options);
					options.addArguments("--headless", "--window-size=1024,768");
					driver = new ChromeDriver(options);
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					System.out.println("Headless chrome inittialized");
				}
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		logger = Logger.getLogger("via"); 
		DOMConfigurator.configure("Log4j.xml");
	}

	//load Locators file
	@BeforeClass
	public static void locatorproperties() throws IOException 
		{
			locator = new Properties();
			configfile = new File(System.getProperty("user.dir")+ "/src/main/java/Properties/Locators.properties");
			filestream = new FileInputStream(configfile);
			try {
					locator.load(filestream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	
	@BeforeClass
	public void testLevelSetup() throws IOException, InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.loginToVIA();
			}
	
	@BeforeClass
	public void methodLevelSetup() {
		importPage = new ImportPage(driver);
	}
	
	@AfterTest
	public void teardown() {
		//driver.quit();
	}
}
