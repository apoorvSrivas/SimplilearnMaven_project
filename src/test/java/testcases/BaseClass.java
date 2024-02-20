package testcases;

import org.testng.annotations.*;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	
	public WebDriver driver;
	
	public ExtentReports report;
	public ExtentTest test;
	
	Fillo fillo;
	Connection connection;
	
	
	@BeforeTest
	public void reportSetUp() throws FilloException {
		
		report = new ExtentReports("ExtentReport.html");
		
		fillo = new Fillo(); 
		connection = fillo.getConnection("DataSheet.xlsx");
	}
	
	
	@BeforeMethod
	public void setUp(Method method) 
	{
		WebDriverManager.chromedriver().setup();    // chromedriver() is static method inside WebDriverManager class so we can diretly call it. 
		
		test= report.startTest(method.getName());  
		test.log(LogStatus.INFO, "Test should be started" , "test case started successfully");
		
		this.driver = new ChromeDriver();
		driver.get("https://simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		report.endTest(test);
		driver.quit();
	}
	
	
	@AfterTest
	public void ReportClean() {
		
		report.flush();
		report.close();
	}

}
