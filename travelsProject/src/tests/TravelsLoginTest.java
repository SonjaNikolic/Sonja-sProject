package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TravelsCarsPage;
import pages.TravelsLoginPage;
import pages.TravelsMenuPage;

public class TravelsLoginTest extends BasicTest {

	@Test(priority = 0)
	public void basicLogin() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);

		TravelsLoginPage tlp = new TravelsLoginPage(driver);
		tlp.signIn("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);

		Assert.assertTrue(this.driver.getTitle().contains("Dashboard"));
	}

}
