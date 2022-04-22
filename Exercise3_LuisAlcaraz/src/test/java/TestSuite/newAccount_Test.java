package TestSuite;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import com.aventstack.extentreports.Status;
import Base.ClsBrowser;
import Base.ClsReport;
import Base.ClsWebElements;
import Guru99.CreateUserPage;
import Guru99.LoginPage;

public class newAccount_Test extends ClsWebElements {

	@Rule 
	public TestName TC_Name = new TestName();
	public String URL = "http://live.guru99.com/index.php/tv.html";
	
	@BeforeClass
	public static void beforeClass() 
	{
		ClsReport.fnSetupReport();
	}
	
	@Before
	public void setup() 
	{
		ClsBrowser.BrowserName = "CHROME";
		OpenBrowser();
	} 
	
	
	@Test
	public void TestScenario_3()
	{
		
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("Test Scenario 3");
			NavigateToUrl(URL);
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, "Navigation to URL.", false);
			CreateUserPage objNewUser = new CreateUserPage();
			LoginPage objLogin = new LoginPage();
			objNewUser.goToCreate();
			ClsReport.fnLog(Status.PASS, "In Create New User Page.", false);
			objNewUser.createUser();
			ClsReport.fnLog(Status.PASS, "User Created.", true);
			objLogin.goToLogin();
			ClsReport.fnLog(Status.PASS, "In Log In Page.", false);
			objLogin.logIn();
			ClsReport.fnLog(Status.PASS, "Logged in with User just created.", true);
			Thread.sleep(3500);
		}
		catch(Exception e) 
		{
			ClsReport.fnLog(Status.FAIL, "The: " + TC_Name.getMethodName() + " was not executed successfully. \n Exception: " + e.getMessage() , true);
		}
	}
		
		
	@After
	public void tearDown() 
	{
		CloseBrowser();
		ClsReport.fnCloseReport();
	}

}
