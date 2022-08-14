package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomer;
import page.Dashboard;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContact {
	ExcelReader excelRead = new ExcelReader("data\\Tech.xlsx");
	
	WebDriver driver;
	String username =excelRead.getCellData("LoginInfo","USERNAME", 2);
	String password =excelRead.getCellData("LoginInfo","PASSWORD", 2);
	
	String FULL_NAME = excelRead.getCellData("AddContactInfo","FULLNAME",2);
	String COMPANY_NAME= excelRead.getCellData("AddContactInfo","COMPANY",2);
	String EMAIL= excelRead.getCellData("AddContactInfo","EMAIL",2);
	String PHONE_NUMBER = excelRead.getCellData("AddContactInfo","PHONE",2);
	String ADR = excelRead.getCellData("AddContactInfo","ADRESS",2);
	String CTY = excelRead.getCellData("AddContactInfo","CITY",2);
	String COUNTRY= excelRead.getCellData("AddContactInfo","COUNTRY",2);
	String ZIPCODE= excelRead.getCellData("AddContactInfo","ZIP",2);

	@Test
	public void validCustomerShouldBeAbleToAddCustomer() throws InterruptedException {

		driver = BrowserFactory.init();

		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.insertUserName(username);
		login.insertPassWord(password);
		login.clickSign();

		Dashboard dashboard = PageFactory.initElements(driver, Dashboard.class);

		dashboard.verifyDashboard();
		dashboard.clickCustoer();
		dashboard.addCustomer();
		
		AddCustomer addCustomer = PageFactory.initElements(driver, AddCustomer.class);
		
		addCustomer.insertFullName(FULL_NAME);
		addCustomer.selectCompany(COMPANY_NAME);
		addCustomer.insertEmail(EMAIL);
		addCustomer.insertPhone(PHONE_NUMBER);
		addCustomer.insertAdress(ADR);
		addCustomer.insertCity(CTY);
		addCustomer.selectCountry(COUNTRY);
		addCustomer.insertZip(ZIPCODE);
		addCustomer.save();
		addCustomer.waitsum();
		
		dashboard.listCustomer();
		addCustomer.verifyEnterdNameAndDelete();
		//addCustomer.pop();
	}

}
