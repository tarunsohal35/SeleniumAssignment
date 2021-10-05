package Academy;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import pageObjects.ProductPage;
import resources.base;

public class HomePage extends base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}

	@Test(priority = 1)
	public void login() {

		LandingPage lp = new LandingPage(driver);
		lp.Username().sendKeys(prop.getProperty("username"));
		lp.Password().sendKeys(prop.getProperty("password"));
		lp.Login().click();
	}

	@Test(priority = 2)
	public void drop() throws IOException, Exception {
		Thread.sleep(3000L);
		ProductPage pp = new ProductPage(driver);
		Select sc = new Select(pp.Drop());
		sc.selectByValue("lohi");

	}

	@Test(priority = 3)
	public void selectProduct() throws IOException, Exception {
		ProductPage pp = new ProductPage(driver);
		String[] items = { "Sauce Labs Onesie", "Sauce Labs Bolt T-Shirt", "Test.allTheThings() T-Shirt (Red)" };
		List<WebElement> prods = pp.Products();
		for (int i = 0; i < pp.ProductsName().size(); i++) {
			List<String> itemsNeeded = Arrays.asList(items);
			String productName = pp.ProductsName().get(i).getText();
			if (itemsNeeded.contains(productName)) {
				prods.get(i).click();
			}
		}
		Thread.sleep(1000L);

	}

	@Test(priority = 4)
	public void cart() throws IOException, Exception {
		Thread.sleep(1000L);
		ProductPage pp = new ProductPage(driver);
		pp.Cart().click();
	}

	@Test(priority = 5)
	public void Checkout() throws IOException, Exception {
		Thread.sleep(1000L);
		CheckOutPage co = new CheckOutPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", co.CheckButton());
		Thread.sleep(1000L);
		co.CheckButton().click();
		js.executeScript("arguments[0].scrollIntoView(true);", co.Title());
		Thread.sleep(1000L);
		co.FirstName().sendKeys("Samuel");
		co.LastName().sendKeys("jamenson");
		co.PinCode().sendKeys("567992");
		Thread.sleep(1000L);
		co.Continue().click();
		Thread.sleep(1000L);
		js.executeScript("arguments[0].scrollIntoView(true);", co.Finish());
		Thread.sleep(1000L);
		co.Finish().click();
		js.executeScript("arguments[0].scrollIntoView(true);", co.Title());
		Thread.sleep(1000L);
	}

	@Test(priority = 6)
	public void Validity() throws IOException, Exception {
		CheckOutPage co = new CheckOutPage(driver);
		String expected = "THANK YOU FOR YOUR ORDER";
		String actual  = co.ValidateTitle();
		Assert.assertEquals(actual, expected);

	}

}
