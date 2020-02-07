package VIA_Module_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import GenericFunctions.BaseTest;
import Utilities.CommonFunctions;

public class LoginPage extends CommonFunctions 
{
    //*********Constructor*********
    public LoginPage(WebDriver driver) 
    	{
        	super(driver);
    	}
    
    //*************PAGE METHODS********************
    //Go to Homepage
	public void loginToVIA() throws IOException, InterruptedException
		{		
			sendkeys(By.id(getlocval("Email_textbox")), driver, getdataval("OaLogin"),"Username");
			sendkeys(By.id(getlocval("Password_textbox")), driver, getdataval("OaPassword"),"Password");
			click(By.xpath(getlocval("SignIn_button")),driver, "LoginButton");
			verifyLogin(By.xpath(getlocval("Home_page")),driver, "Via by Watermark");
			BaseTest.logger.info("The user get login successfully.");

		}
}
