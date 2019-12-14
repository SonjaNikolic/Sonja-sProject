package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TravelsCustomerPage;
import pages.TravelsLoginPage;

public class TravelsCustomersTest extends BasicTest {

	@BeforeTest
	public void setup() throws InterruptedException {
		super.setup();
		driver.get(this.baseUrl);
		Thread.sleep(2000);

		TravelsLoginPage tlp = new TravelsLoginPage(driver);
		tlp.signIn("admin@phptravels.com", "demoadmin");
		Thread.sleep(2000);
	}

	@Test(priority = 40)
	public void goToCustomersManagement() throws InterruptedException {

		TravelsCustomerPage tcup = new TravelsCustomerPage(driver);
		tcup.getAccounts();
		tcup.goToAccountsCustomers().click();
		tcup.clickOnEditBtn().click();
		Thread.sleep(2000);

		tcup.editCustomer("Milos", "Milic", "milosmilic@gmail.com", "060123123", "Serbia", "Milosevabb");

		tcup.clickOnSearchBtn();
		tcup.getSearchInput("milosmilic@gmail.com");
		Thread.sleep(2000);
		Assert.assertEquals(tcup.getResultTrue("milosmilic@gmail.com"), true);
	}
}