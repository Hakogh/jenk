package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public int generateRandomNo(int boundaryNumber) {

		Random rnd = new Random();
		int generateN = rnd.nextInt(boundaryNumber);
		return generateN;
	}

	public void selectFromDropDown(WebElement Element, String visibleText) {
		Select sel = new Select(Element);
		sel.selectByVisibleText(visibleText);
	}

	public void waitForElement(WebDriver driver, int timeInSeconds, WebElement ELEMENT) {
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOf(ELEMENT));

	}
}
