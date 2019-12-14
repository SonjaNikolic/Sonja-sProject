package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsMenuPage extends BasicPage {

	private By sidebarMenu = By.cssSelector("#social-sidebar-menu li a");
	private By tours = By.cssSelector("[href='#Tours']");
	private By toursAdd = By.cssSelector("#Tours li");
	private By coupons = By.cssSelector("[href='https://www.phptravels.net/admin/coupons/']");
	private By newsletter = By.cssSelector("[href='https://www.phptravels.net/admin/newsletter/']");
	private By bookings = By.cssSelector("[href='https://www.phptravels.net/admin/bookings/']");

	public TravelsMenuPage(WebDriver driver) {
		super(driver);
	}

	public WebElement goToDashboard() {
		return this.driver.findElements(sidebarMenu).get(0);
	}

	public WebElement goToUpdates() {
		return this.driver.findElements(sidebarMenu).get(1);
	}

	public WebElement goToModules() {
		return this.driver.findElements(sidebarMenu).get(2);
	}

	public void goToTours() {
		this.driver.findElement(tours).click();
	}

	public WebElement goToToursAddNew() {
		return this.driver.findElements(toursAdd).get(1);
	}

	public void goToCoupons() {
		this.driver.findElement(coupons).click();
	}

	public void goToNewsletter() {
		this.driver.findElement(newsletter).click();
	}

	public void goToBookings() {
		this.driver.findElement(bookings).click();
	}
}
