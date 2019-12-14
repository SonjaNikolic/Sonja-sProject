package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsCarsPage extends BasicPage {

	private By cars = By.cssSelector("[href='#Cars']");
	private By goToCars = By.cssSelector("#Cars a");
	private By carsList = By.cssSelector("tbody tr");
	private By orders = By.cssSelector(".form-control.input-sm");

	public TravelsCarsPage(WebDriver driver) {
		super(driver);
	}

	public void carsPage() {
		this.driver.findElement(cars).click();
	}

	public void goToCars() {
		this.driver.findElement(goToCars).click();
	}

	public List<WebElement> getCarsList() {
		return this.driver.findElements(carsList);
	}

	public boolean numOfOrders() {
		List<WebElement> ordersList = driver.findElements(this.orders);
		List<String> ordersString = new ArrayList<String>();

		for (WebElement e : ordersList) {
			ordersString.add(e.getAttribute("value"));
		}
		List<Integer> ordersInt = new ArrayList<Integer>();

		for (String e : ordersString) {
			ordersInt.add(Integer.parseInt(e));
		}
		int sumOrders = 0;
		for (int i = 0; i < ordersInt.size(); i++) {
			sumOrders = sumOrders + i;
		}
		System.out.println(sumOrders);
		boolean over50 = false;
		if (sumOrders > 50) {
			over50 = true;
		}
		return over50;
	}

}
