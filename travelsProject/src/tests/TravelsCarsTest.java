package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TravelsCarsPage;
import pages.TravelsLoginPage;

public class TravelsCarsTest extends BasicTest {

	@BeforeTest
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(this.baseUrl);
		Thread.sleep(2000);

		TravelsLoginPage tlp = new TravelsLoginPage(driver);
		tlp.signIn("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
	}

	@Test(priority = 17)
	public void getNavLinks() throws InterruptedException {

		TravelsCarsPage tcp = new TravelsCarsPage(driver);
		tcp.carsPage();
		tcp.goToCars();
		Assert.assertTrue(tcp.getCarsList().size() == 10);
	}

	@Test(priority = 18)
	public void numOfOrdersOver50() throws InterruptedException {
		TravelsCarsPage tcp = new TravelsCarsPage(driver);
		boolean actual = tcp.numOfOrders();
		boolean expected = true;
		Assert.assertEquals(actual, expected);
	}
}
