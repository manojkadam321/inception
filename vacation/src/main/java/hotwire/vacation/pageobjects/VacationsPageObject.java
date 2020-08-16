package hotwire.vacation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Manoj Kadam : QA Automation
 * Contains WebElement locators for vacations page
 * Contains methods for entering Flight details
 *
 */
public class VacationsPageObject {

	WebDriver driver;
	/** Locators */
	By button_Car = By.xpath("//button[@data-bdd='farefinder-package-bundleoption-car']");
	By text_flyFrom = By.id("farefinder-package-origin-location-input");
	By text_flyTo = By.id("farefinder-package-destination-location-input");
	By text_departingDate = By.id("farefinder-package-startdate-input");
	By select_departingTime = By.id("farefinder-package-pickuptime-input");
	By text_returningDate = By.id("farefinder-package-enddate-input");
	By select_returningTime = By.id("farefinder-package-dropofftime-input");
	By button_findADeal = By.id("farefinder-package-search-button");
	By link_result = By.xpath("//a[@class='flex-link']");
	By link_from= By.xpath("//a[@title='San Francisco, CA, United States of America (SFO - San Francisco Intl.)']");
	By link_to= By.xpath("//a[@title='Los Angeles, CA, United States (LAX-Los Angeles Intl.)']");
	By div_loader= By.xpath("//div[@class='page-perceived-speed-loader-body']");
	
	public VacationsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectFlightHotelCarSearch() {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(div_loader));
		
		driver.findElement(button_Car).click();

	}

	public void enterFlightFrom(String flyFrom) {
		driver.findElement(text_flyFrom).sendKeys(flyFrom);
		driver.findElement(link_from).click();
	}

	public void enterFlightTo(String flyTo) {
		driver.findElement(text_flyTo).sendKeys(flyTo);
		driver.findElement(link_to).click();
	}

	public void selectDepartureDate(String departingDate) {
		driver.findElement(text_departingDate).clear();
		driver.findElement(text_departingDate).sendKeys(departingDate);
	}

	public void selectDepartureTime(String departingTime) {
		Select dropdownDepartingTime = new Select(driver.findElement(select_departingTime));
		dropdownDepartingTime.selectByVisibleText(departingTime);
	}

	public void selectReturnDate(String returningDate) {
		driver.findElement(text_returningDate).clear();
		driver.findElement(text_returningDate).sendKeys(returningDate);
	}

	public void selectReturnTime(String returningTime) {
		Select dropdownReturningTime = new Select(driver.findElement(select_returningTime));
		dropdownReturningTime.selectByVisibleText(returningTime);
	}

	public void clickOnFindADeal() {
		driver.findElement(button_findADeal).click();
	}

	public int getCountOfResult() {
		return driver.findElements(link_result).size();//get list count of all result links
	}
}
