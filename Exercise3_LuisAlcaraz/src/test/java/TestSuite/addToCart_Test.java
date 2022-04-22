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
import Guru99.ShoppingCartPage;
import Guru99.TVCatalogPage;


public class addToCart_Test extends ClsWebElements{
	
	
	String addLG = "//button[contains(@onclick, 'product/4')]";
	String shoppLG = "//span[text() = 'LG LCD was added to your shopping cart.']";

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
	public void TestScenario_1()
	{
		
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("Test Scenario 1");
			NavigateToUrl(URL);
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, "Navigation to URL.", false);
			TVCatalogPage objCatalog = new TVCatalogPage();
			ShoppingCartPage objShopp = new ShoppingCartPage();
			objCatalog.catalogPage(addLG);
			ClsReport.fnLog(Status.PASS, "LG TV was added to cart.", true);
			objShopp.checkItemAdded(shoppLG);
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
