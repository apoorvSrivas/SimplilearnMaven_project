package testcases;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.LoginPage;


public class LoginTest extends BaseClass {
	
	
	
	@Test
	public void test1() {
		
		LoginPage login = new LoginPage(driver);
		
		login.loginFunction("abc@xyz.com", "Abc@12345");
		WebElement error = driver.findElement(By.xpath("//div[@class='error_msg']"));
		String ActError = error.getText();
		String ExpError = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActError, ExpError);  // Rather than if-else, use Assertion in testNG		
	}
	
	
	@Test
	public void test2() {
		
		LoginPage login = new LoginPage(driver);
		login.loginFunction("pqr@xyz.com", "Pqr@12345");			
	}
	
	@Test
	public void test4(Method method) throws FilloException {  
		
		Recordset recordset = connection.executeQuery("select * from data where TestName='"+method.getName()+"'");  // With method.getName(), we'll get test name here from TestName column of excel sheet. 
		recordset.next();
			
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPage login = new LoginPage(driver);
		login.loginFunction(UserName, Password);
		}
		
}

