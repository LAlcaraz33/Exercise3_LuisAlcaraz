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
import Guru99.CheckoutPage;
import Guru99.ShoppingCartPage;
import Guru99.TVCatalogPage;

public class placeOrder_Test extends ClsWebElements {
	
	String addSmg = "//button[contains(@onclick, 'product/5')]";
	String shoppSmg = "//span[text() = 'Samsung LCD was added to your shopping cart.']";

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
	public void TestScenario_2()
	{
		
		try 
		{
			ClsReport.objTest = ClsReport.objExtent.createTest("Test Scenario 2");
			NavigateToUrl(URL);
			WaitForLoad();
			ClsReport.fnLog(Status.PASS, "Navigation to URL.", false);
			TVCatalogPage objCatalog = new TVCatalogPage();
			ShoppingCartPage objShopp = new ShoppingCartPage();
			CheckoutPage objCheck = new CheckoutPage();
			objCatalog.catalogPage(addSmg);
			ClsReport.fnLog(Status.PASS, "Samsung LCD was added to cart.", false);
			objShopp.checkItemAdded(shoppSmg);
			ClsReport.fnLog(Status.PASS, "Samsung LCD tv added correctly.", false);
			objShopp.proceedToCheckout();
			ClsReport.fnLog(Status.PASS, "Go to Checkout Page.", false);
			objCheck.billingInfo();
			ClsReport.fnLog(Status.PASS, "Billing Information written.", false);
			objCheck.shippingMethod();
			ClsReport.fnLog(Status.PASS, "Shipping Method confirmed.", false);
			objCheck.payInfo();
			ClsReport.fnLog(Status.PASS, "Payment Information confirmed.", false);
			objCheck.placeOrder();
			ClsReport.fnLog(Status.PASS, "Order is placed.", true);
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
