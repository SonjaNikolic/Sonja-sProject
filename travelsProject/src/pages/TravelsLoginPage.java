package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TravelsLoginPage extends BasicPage {

	private By email = By.name("email");
	private By password = By.name("password");
	private By checkbox = By.className("icheckbox_square-grey");
	private By forgetPassword = By.cssSelector(".forget-password.text-right");
	private By submitBtn = By.cssSelector("[type='submit']");

	public TravelsLoginPage(WebDriver driver) {
		super(driver);
	}

	public void setEmail(String email) {
		this.driver.findElement(this.email).sendKeys(email);
	}

	public void setPassword(String password) {
		this.driver.findElement(this.password).sendKeys(password);
	}

	public void clickOnCheckbox() {
		this.driver.findElement(this.checkbox).click();
	}

	public void clickOnForgetPassword() {
		this.driver.findElement(this.forgetPassword).click();
	}

	public void clickOnSubmitBtn() {
		this.driver.findElement(this.submitBtn).sendKeys(Keys.ENTER);
		;
	}

	public void signIn(String email, String password) throws InterruptedException {
		this.setEmail(email);
		this.setPassword(password);
		this.clickOnSubmitBtn();
	}
}
