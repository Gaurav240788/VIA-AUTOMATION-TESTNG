package VIA_Sanity_Scripts;

import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import GenericFunctions.BaseTest;
import VIA_Module_Pages.ImportPage;

public class VIA_Import_Test extends BaseTest
{
	@Test (priority=1, description = "Import Functionality")
	public void go_to_Import(Method method) throws IOException
		{		
			importPage.go_to_Import();
		}	
	@Test (priority=2, description = "Hierarchy Import Functionality")
	public void hierachy_Import(Method method) throws IOException
		{		
			importPage.HierarchyFilePath();
		}
	@Test (priority=3, description = "Users Import Functionality")
	public void users_Import(Method method) throws IOException
		{		
			importPage.usersFilePath();
		}	
	@Test (priority=4, description = "Group Template Import Functionality")
	public void grouptemplates_Import(Method method) throws IOException
		{		
			//importPage.HierarchyFilePath();
		}	
	@Test (priority=5, description = "Group Import Functionality")
	public void groups_Import(Method method) throws IOException
		{		
			//importPage.HierarchyFilePath();
		}	
	@Test (priority=6, description = "Membership Import Functionality")
	public void membership_Import(Method method) throws IOException
		{		
			//importPage.HierarchyFilePath();
		}	
}
