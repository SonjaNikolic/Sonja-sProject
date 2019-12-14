package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TravelsCarsExtrasPage;
import pages.TravelsLoginPage;

public class TravelsCarsExtrasTest extends BasicTest {

	@BeforeTest
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(this.baseUrl);
		Thread.sleep(2000);

		TravelsLoginPage tlp = new TravelsLoginPage(driver);
		tlp.signIn("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
	}

	@Test(priority = 25)
	public void addNewItem() throws InterruptedException {

		TravelsCarsExtrasPage tcep = new TravelsCarsExtrasPage(driver);
		tcep.getAddExtras();
		Thread.sleep(2000);
		tcep.getUploadInput();
		Thread.sleep(1000);
		tcep.uploadImage("images\\steering_wheel.jpg");
		Thread.sleep(5000);
		tcep.saveChanges("steering wheel for BMW", "250$");
		Thread.sleep(2000);
		tcep.clickOnSearchBtn().click();
		tcep.getSearchInput("steering wheel for BMW");
		Thread.sleep(2000);

		Assert.assertTrue(tcep.getResultName().getText().contains("steering wheel for BMW"));

	}

	@Test(priority = 26)
	public void isStatusChanged() {
		TravelsCarsExtrasPage tcep = new TravelsCarsExtrasPage(driver);
		Assert.assertTrue(tcep.getResultNameStatus().getText().contains("No"));
	}

	@Test(priority = 27)
	public void isImageUploadedSuccessfuly() throws InterruptedException {

		TravelsCarsExtrasPage tcep = new TravelsCarsExtrasPage(driver);
		Assert.assertTrue(tcep.ifImgExists());
	}

	@Test(priority = 28)
	public void possibleTextInPrice() {
		TravelsCarsExtrasPage tcep = new TravelsCarsExtrasPage(driver);
		Assert.assertTrue(tcep.getResultPrice().getText().contains("250$"));
	}
}
