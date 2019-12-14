package pages;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsCarsExtrasPage extends BasicPage {

	private By cars = By.cssSelector("[href='#Cars']");
	private By goToCarsExtras = By.cssSelector("#Cars a");

	private By addExtras = By.cssSelector(".xcrud-top-actions a");
	private By uploadInput = By.name("xcrud-attach");
	private By formInputName = By.name("cHRfZXh0cmFzLmV4dHJhc190aXRsZQ--");
	private By status = By.cssSelector(".xcrud-input.form-control");
	private By formInputPrice = By.name("cHRfZXh0cmFzLmV4dHJhc19iYXNpY19wcmljZQ--");
	private By saveBtn = By.cssSelector(".xcrud-top-actions.btn-group a");

	private By searchButton = By.cssSelector(".xcrud-nav a");
	private By searchInput = By.name("phrase");

	private By resultName = By.cssSelector("tr.xcrud-row.xcrud-row-0");
	private By resultNameStatus = By.cssSelector("tr.xcrud-row.xcrud-row-0 td");
	private By resultNameImg = By.cssSelector("tr.xcrud-row.xcrud-row-0 td img");

	public TravelsCarsExtrasPage(WebDriver driver) {
		super(driver);
	}

	public void carsPage() {
		this.driver.findElement(cars).click();
	}

	public WebElement goToCarsExtras() {
		return this.driver.findElements(goToCarsExtras).get(1);
	}

	public WebElement goToAddExtras() {
		return this.driver.findElements(addExtras).get(2);
	}

	public void getAddExtras() throws InterruptedException {
		this.carsPage();
		Thread.sleep(1000);
		this.goToCarsExtras().click();
		this.goToAddExtras().click();
	}

	public WebElement getUploadInput() {
		return this.driver.findElement(uploadInput);
	}

	public void uploadImage(String path) {
		getUploadInput().sendKeys(new File(path).getAbsolutePath());
	}

	public void getInputname(String name) {
		this.driver.findElement(this.formInputName).sendKeys(name);
	}

	public void changeStatus() {
		WebElement st = this.driver.findElements(this.status).get(1);
		st.click();
		st.sendKeys(Keys.ARROW_DOWN);
		st.sendKeys(Keys.ENTER);
	}

	public void getInputPrice(String price) {
		this.driver.findElement(this.formInputPrice).sendKeys(price);
	}

	public void clickOnSaveBtn() {
		this.driver.findElement(this.saveBtn).click();
	}

	public void saveChanges(String name, String price) throws InterruptedException {
		this.getInputname(name);
		this.changeStatus();
		this.getInputPrice(price);
		Thread.sleep(2000);
		this.clickOnSaveBtn();
	}

	public WebElement clickOnSearchBtn() {
		return this.driver.findElements(searchButton).get(1);
	}

	public void getSearchInput(String name) {
		WebElement sInput = this.driver.findElement(searchInput);
		sInput.sendKeys(name);
		sInput.sendKeys(Keys.ENTER);
	}

	public WebElement getResultName() {
		return this.driver.findElement(resultName);
	}

	public WebElement getResultNameStatus() {
		return this.driver.findElements(resultNameStatus).get(4);
	}

	public boolean ifImgExists() {
		try {
			return this.driver.findElement(resultNameImg) != null;
		} catch (Exception e) {
			return false;
		}
	}

	public WebElement getResultPrice() {
		return this.driver.findElements(resultNameStatus).get(5);
	}

}
