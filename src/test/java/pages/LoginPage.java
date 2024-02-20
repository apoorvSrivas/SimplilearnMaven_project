package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver driver;
	
		public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);   // This line does that all objects on this page gets initialized by driver. First paramenter is this driver and other parameter "this" means current class, so this line will initialize all objects with this driver on this class. 
	}
	
	
	
	
	// =========================================== All Objects ========================================================
	
	@FindBy(linkText="Log in")
	WebElement LoginLink;
	
	@FindBy(name="user_login")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="remember-me")
	WebElement checkBox;
	
	@FindBy(name="btn_login")
	WebElement login_button;
	
	

	
	// ============================================ Methods ==============================================================
	

	
	public void loginFunction(String usrNameVal, String pwdVal) {
		

		LoginLink.click();
		userName.sendKeys(usrNameVal);
		password.sendKeys(pwdVal);
		checkBox.click();
		login_button.click();	
		
	}

}
