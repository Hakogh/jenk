package page;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomer extends BasePage {

	WebDriver driver;

	public AddCustomer(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]")
	WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
	WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]")
	WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"address\"]")
	WebElement ADRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"city\"]")
	WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"country\"]")
	WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"zip\"]")
	WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"submit\"]")
	WebElement SUBMIT_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"summary\"]")
	WebElement SUMMARY_ELEMENT;

	String generateName; 
	
	public void insertFullName(String username) {

	generateName = username + generateRandomNo(999);
		FULL_NAME_ELEMENT.sendKeys(generateName);
		System.out.println(generateName);
	}

	public void selectCompany(String company) {

		selectFromDropDown(COMPANY_ELEMENT, company);
	}

	public void insertEmail(String email) {
		EMAIL_ELEMENT.sendKeys(generateRandomNo(9999) + email);
	}

	public void insertPhone(String phone) {

		PHONE_ELEMENT.sendKeys(phone + generateRandomNo(99));
	}

	public void insertAdress(String ADR) {
		ADRESS_ELEMENT.sendKeys(ADR);
	}

	public void insertCity(String CITY) {
		CITY_ELEMENT.sendKeys(CITY);
	}

	public void selectCountry(String country) {
		selectFromDropDown(COUNTRY_ELEMENT, country);
	}

	public void insertZip(String ZIPCODE) {
		ZIP_ELEMENT.sendKeys(ZIPCODE);
	}

	public void save() {
		SUBMIT_ELEMENT.click();
	}

	public void waitsum() {
		waitForElement(driver, 5, SUMMARY_ELEMENT);
		Assert.assertEquals(SUMMARY_ELEMENT.getText(), "Summary", "wrong page");
	}
	
	
	//tbody/tr[1]/td[3]
	
	//tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
	//tbody/tr[1]/td[7]/a[2]
	
	String beforXpath ="//tbody/tr[";
	String afterXpath= "]/td[3]";
	String afterXpathDelete = "]/td[7]/a[2]";
	
	
	public void verifyEnterdNameAndDelete() {
	
		 for(int i = 1; i<=10; i++) {
			 
			 String enteredName = driver.findElement(By.xpath(beforXpath + i + afterXpath)).getText();
				
				  System.out.println(enteredName); Assert.assertEquals(enteredName, generateName, "invalide name");
				  System.out.println(generateName);
				 
				/*
				 * if (enteredName.contains(generateName)) { System.out.println("exist");
				 * driver.findElement(By.xpath(beforXpath + i + afterXpathDelete)).click();
				 * 
				 * }
				 */
			break;
		
		 }
		 
	
	}

	/*
	 * public void pop() throws InterruptedException {
	 * System.out.println("==========================="); Thread.sleep(3000); String
	 * Alert= driver.switchTo().alert().getText();
	 * System.out.println(Alert+"alert msg"); driver.switchTo().alert().accept();
	 * 
	 * }
	 */
}
