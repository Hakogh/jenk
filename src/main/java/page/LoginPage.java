package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

	
public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	//What's class associate with
	//method //variables == attribute == field
	
	// java associate with class and object
	
	String USERNAME = "demo@techfios.com";
	String PASSWOR = "abc123";
	
	By userNameField = By.xpath("//input[@id='username']");
	By passWordField = By.xpath("//*[@id=\"password\"]");
	By signInButtonField = By.xpath("/html/body/div/div/div/form/div[3]/button");

	@FindBy(how = How.XPATH,using = "//input[@id='username']") WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using="//*[@id=\"password\"]") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button") WebElement SUBMIT_ELEMENT;
	
	//Individual method 
	
	public void insertUserName(String USERNAME) {
		
		USERNAME_ELEMENT.sendKeys(USERNAME);
	}
	
	public void insertPassWord (String PASSWOR) {
		
		PASSWORD_ELEMENT.sendKeys(PASSWOR);
	}
	public void clickSign() {
		SUBMIT_ELEMENT.click();
	}
	
	//together method
	 
//	public void loginTest(String USERNAME,String PASSWOR) {
//		
//		USERNAME_ELEMENT.sendKeys(USERNAME);
//		PASSWORD_ELEMENT.sendKeys(PASSWOR);
//		SUBMIT_ELEMENT.click();
//	
//	
//	}
//	
	
	
	
}
