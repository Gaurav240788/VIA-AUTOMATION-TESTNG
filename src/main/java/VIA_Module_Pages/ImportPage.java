package VIA_Module_Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import GenericFunctions.BaseTest;
import Utilities.CommonFunctions;

public class ImportPage extends CommonFunctions
{
	public ImportPage(WebDriver driver) 
		{
			super(driver);
		}
	String HierarchyFilePath;
	String UsersFilePath;
	String GroupTemplatesFilePath;
	String GroupsFilePath;
	String MembershipsFilePath;
	
	// *********Web Elements*********
	public void go_to_Import() throws IOException
		{
			click(By.xpath(getlocval("Import")),driver,"Import");
			verifyLogin(By.xpath(getlocval("Import_verify")),driver,"Import Users");
			BaseTest.logger.info("Import page get open successfully.");
		}
	
	public void HierarchyFilePath() throws IOException
	{
		HierarchyFilePath=TestDataFile("HierarchyFilePath");
			try
				{
					click(By.xpath(getlocval("Import_hierarchy")),driver,"Import Hierarchy");
					uploadFiles(By.xpath(getlocval("Choose_File_btn")), driver, HierarchyFilePath);									
					click(By.xpath(getlocval("Check_status")),driver,"Check Status");
					verifyImport(By.xpath(getlocval("Failure_link")),driver);									
				}
			catch(Exception e)
				{
					e.printStackTrace();
				}
	}
	public void usersFilePath() throws IOException
	{
		UsersFilePath=TestDataFile("UsersFilePath");
			try
				{
					click(By.xpath(getlocval("Import_usres")),driver,"Import Users");
					uploadFiles(By.xpath(getlocval("Choose_File_btn")), driver, UsersFilePath);									
					click(By.xpath(getlocval("Check_status")),driver,"Check Status");
					verifyImport(By.xpath(getlocval("Failure_link")),driver);									
				}
			catch(Exception e)
				{
					e.printStackTrace();
				}
	}
}
