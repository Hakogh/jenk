package page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


public class Dashboard {

	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(how = How.XPATH,using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement DASH_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]") WebElement CUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement ADDCUSTOMER_ELEMENT;
	@FindBy(how = How.XPATH,using = "//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a") WebElement LISTCUSTOMER_ELEMENT;
	
	public void verifyDashboard () {
		
		Assert.assertEquals(DASH_ELEMENT.getText(), "Dashboard", "Wronng Page!!");
	}
	
	public void clickCustoer() {
		CUSTOMER_ELEMENT.click();
	}
	
	public void addCustomer() {
		ADDCUSTOMER_ELEMENT.click();
	}
	
	public void listCustomer() {
		LISTCUSTOMER_ELEMENT.click();
		
	}
	
	
}
