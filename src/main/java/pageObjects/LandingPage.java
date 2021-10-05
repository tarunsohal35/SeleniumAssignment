package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "#user-name")
	WebElement username;

	@FindBy(css = "#password")
	WebElement password;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement login;

	public WebElement Username() {
		return username;
	}

	public WebElement Password() {
		return password;
	}

	public WebElement Login() {
		return login;
	}

}
