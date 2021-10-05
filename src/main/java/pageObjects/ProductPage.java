package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	public WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".product_sort_container")
	WebElement drop;

	@FindBy(css = ".shopping_cart_link")
	WebElement cart;

	@FindBy(css = ".shopping_cart_link")
	WebElement prod;

	public WebElement Drop() {
		return drop;
	}

	public List<WebElement> ProductsName() {
		return driver.findElements(By.cssSelector(".inventory_item_name"));
	}

	public List<WebElement> Products() {
		return driver.findElements(By.xpath("//button[text()='Add to cart']"));
	}

	public WebElement Cart() {
		return cart;
	}

}
