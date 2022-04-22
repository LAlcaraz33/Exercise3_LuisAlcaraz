package TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ addToCart_Test.class, newAccount_Test.class, placeOrder_Test.class })
public class Exercise3_TestSuite {

}
