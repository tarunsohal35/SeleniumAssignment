package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	public WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#checkout")
	WebElement chekbutton;

	@FindBy(xpath = "//div[@class='app_logo']")
	WebElement title;

	@FindBy(css = "#first-name")
	WebElement firstName;

	@FindBy(css = "#last-name")
	WebElement lastName;

	@FindBy(css = "#postal-code")
	WebElement code;

	@FindBy(css = "#continue")
	WebElement cont;

	@FindBy(css = "#finish")
	WebElement finish;
	
	@FindBy(css = ".complete-header")
	WebElement validateTitle;

	public WebElement CheckButton() {
		return chekbutton;
	}

	public WebElement Title() {
		return title;
	}

	public WebElement FirstName() {
		return firstName;
	}

	public WebElement LastName() {
		return lastName;
	}

	public WebElement PinCode() {
		return code;
	}

	public WebElement Continue() {
		return cont;
	}

	public WebElement Finish() {
		return finish;
	}
	
	public String ValidateTitle() {
		return validateTitle.getText();
	}

}
