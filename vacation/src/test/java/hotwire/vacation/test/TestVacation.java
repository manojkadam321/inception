package hotwire.vacation.test;

import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import hotwire.vacation.config.ReadConfigFile;
import hotwire.vacation.pageobjects.SignInPageObject;
import hotwire.vacation.pageobjects.VacationsPageObject;
import hotwire.vacations.testdata.PrepareTestData;

/**
 * @author Manoj Kadam : QA Automation
 *
 */
public class TestVacation {

	WebDriver driver;
	ReadConfigFile readConfigFile = new ReadConfigFile();

	/**
	 * @param browser provided from testng.xml
	 * Initiates driver Based on value of 'browser' parameter
	 * Hits base URL and sets implicit wait condition
	 */
	@Parameters("browser")
	@BeforeClass
	public void setupBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfigFile.getChromeDriverPath());
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfigFile.getGeckoDriverPath());
		    driver= new FirefoxDriver();
		}

		if (!driver.equals(null)) {
			driver.get(readConfigFile.getBaseURL());
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(readConfigFile.getImplicitWait(), TimeUnit.SECONDS);
		}
	}

	
	/**
	 * Navigate to vacations tab
	 * Select flight+hotel+car search
	 * Enter flight from and to details mentioned in properties file
	 * Select next day departure date
	 * Select three weeks after day as return date 
	 * Flight Departing evening, returning morning
	 * Find a deal
	 * At least one result should be displayed
	 */
	@Test
	public void testVacation() {
		try {

			SignInPageObject signInPageObject = new SignInPageObject(driver);
			signInPageObject.clickOnVacationLink();
			
			driver.manage().deleteAllCookies();
			
			VacationsPageObject vacationsPageObject = new VacationsPageObject(driver);
			
			vacationsPageObject.selectFlightHotelCarSearch();

			vacationsPageObject.enterFlightFrom(readConfigFile.getFlyFrom());
			
			vacationsPageObject.enterFlightTo(readConfigFile.getFlyTo());
			
			vacationsPageObject.selectDepartureDate(PrepareTestData.getNextDayDateAsString());
				
			vacationsPageObject.selectReturnDate(PrepareTestData.getThreeWeeksAfterDayDateAsString());

			vacationsPageObject.selectDepartureTime(readConfigFile.getDepartureTime());

	        vacationsPageObject.selectReturnTime(readConfigFile.getReturnTime());
	        
			vacationsPageObject.clickOnFindADeal();

            Assert.assertTrue(vacationsPageObject.getCountOfResult()>0, "There is at least one result returned.");

		} catch (ParseException parseException) {
			parseException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	
	/**
	 * Quits driver instance
	 */
	@AfterClass
	public void quitBrowser() {
		driver.quit();
	}
}