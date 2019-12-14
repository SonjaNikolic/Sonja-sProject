package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TravelsLoginPage;
import pages.TravelsMenuPage;

public class TravelsMenuTest extends BasicTest {

	@BeforeTest
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(this.baseUrl);
		Thread.sleep(2000);

		TravelsLoginPage tlp = new TravelsLoginPage(driver);
		tlp.signIn("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
	}

	@Test(priority = 5)
	public void getDashboard() throws InterruptedException {

		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.goToDashboard().click();
		Thread.sleep(2000);

		Assert.assertTrue(this.driver.getTitle().contains("Dashboard"));
	}

	@Test(priority = 6)
	public void getUpdates() throws InterruptedException {

		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.goToUpdates().click();
		Thread.sleep(2000);

		Assert.assertTrue(this.driver.getTitle().contains("Updates"));
	}

	@Test(priority = 7)
	public void getModules() throws InterruptedException {

		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.goToModules().click();
		Thread.sleep(2000);

		Assert.assertTrue(this.driver.getTitle().contains("Modules"));
	}

	@Test(priority = 10)
	public void getTours() throws InterruptedException {

		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.goToTours();
		Thread.sleep(2000);
		tmp.goToToursAddNew().click();

		Assert.assertTrue(this.driver.getTitle().contains("Add Tour"));
	}

	@Test(priority = 14)
	public void getCoupons() throws InterruptedException {

		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.goToCoupons();
		Thread.sleep(2000);

		Assert.assertTrue(this.driver.getTitle().contains("Coupon Codes Management"));
	}

	@Test(priority = 15)
	public void getNewsletter() throws InterruptedException {

		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.goToNewsletter();
		Thread.sleep(2000);

		Assert.assertTrue(this.driver.getTitle().contains("Newsletter Management"));
	}

	@Test(priority = 16)
	public void getBookings() throws InterruptedException {

		TravelsMenuPage tmp = new TravelsMenuPage(driver);
		tmp.goToBookings();
		Thread.sleep(2000);

		Assert.assertTrue(this.driver.getTitle().contains("Booking Management"));
	}
}
