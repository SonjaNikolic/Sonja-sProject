package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsCustomerPage extends BasicPage {

	private By accounts = By.cssSelector("[href='#ACCOUNTS']");
	private By accountsCustomers = By.cssSelector("#ACCOUNTS li a");
	private By editBtn = By.cssSelector("[title='Edit']");

	private By editName = By.name("fname");
	private By editLastName = By.name("lname");
	private By editEmail = By.name("email");
	private By editMob = By.name("mobile");
	private By selectCountry = By.className("select2-choice");
	private By editCountry = By.className("select2-input");
	private By editAddress = By.name("address1");
	private By editStatus = By.name("status");
	private By checkSub = By.name("newssub");
	private By submitButton = By.cssSelector(".btn.btn-primary");

	private By searchBtn = By.cssSelector(".xcrud-search-toggle.btn.btn-default");
	private By searchInput = By.name("phrase");
	private By searchResult = By.cssSelector(".xcrud-row.xcrud-row-0");

	public TravelsCustomerPage(WebDriver driver) {
		super(driver);
	}

	public void getAccounts() {
		this.driver.findElement(accounts).click();
	}

	public WebElement goToAccountsCustomers() {
		return this.driver.findElements(accountsCustomers).get(2);
	}

	public WebElement clickOnEditBtn() {
		return this.driver.findElements(editBtn).get(1);
	}

	public void setName(String fname) {
		WebElement name = this.driver.findElement(this.editName);
		name.clear();
		name.sendKeys(fname);

	}

	public void setLastName(String lname) {
		WebElement lastname = this.driver.findElement(this.editLastName);
		lastname.clear();
		lastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		WebElement Email = this.driver.findElement(this.editEmail);
		Email.clear();
		Email.sendKeys(email);
	}

	public void setMobile(String mobile) {
		WebElement smobile = this.driver.findElement(this.editMob);
		smobile.clear();
		smobile.sendKeys(mobile);
	}

	public void setCountry() {
		this.driver.findElement(selectCountry).click();
	}

	public void setCountryName(String countryN) {
		WebElement country = this.driver.findElement(this.editCountry);
		country.sendKeys(countryN);
		country.sendKeys(Keys.ENTER);
	}

	public void setAddress(String address) {
		WebElement Address = this.driver.findElement(this.editAddress);
		Address.clear();
		Address.sendKeys(address);
	}

	public void setStatus() {
		this.driver.findElement(editStatus).click();
	}

	public void checkNewSub() {
		this.driver.findElement(checkSub).click();
	}

	public void clickOnSubBtn() {
		this.driver.findElements(submitButton).get(1).click();
	}

	public void editCustomer(String fname, String lname, String email, String mobile, String countryN, String address)
			throws InterruptedException {
		this.setName(fname);
		this.setLastName(lname);
		this.setEmail(email);
		this.setMobile(mobile);
		this.setCountry();
		Thread.sleep(1000);
		this.setCountryName(countryN);
		this.setAddress(address);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement sub = driver.findElement(By.name("newssub"));
		js.executeScript("arguments[0].scrollIntoView();", sub);
		this.checkNewSub();
		this.clickOnSubBtn();

	}

	public void clickOnSearchBtn() {
		this.driver.findElement(searchBtn).click();
	}

	public void getSearchInput(String email) {
		WebElement sInput = this.driver.findElement(searchInput);
		sInput.sendKeys(email);
		sInput.sendKeys(Keys.ENTER);
	}

	public WebElement getResult() {
		return this.driver.findElement(searchResult);
	}

	public boolean getResultTrue(String result) {
		boolean yes = false;
		WebElement firstRow = driver.findElement(this.searchResult);
		if (firstRow.getText().contains(result)) {
			yes = true;
		}
		return yes;
	}

}
