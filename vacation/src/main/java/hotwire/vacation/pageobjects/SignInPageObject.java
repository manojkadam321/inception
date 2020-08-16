package hotwire.vacation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Manoj Kadam : QA Automation
 * Contains WebElement locators on Sign In page
 * Contains method for clicking on 'vacation' link
 *
 */
public class SignInPageObject {

	WebDriver driver;
	/** Locators */
	By link_vacation = By.linkText("Vacations");

	public SignInPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnVacationLink() {
		driver.findElement(link_vacation).click();
	}

}
