package stepDefinations;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartLogin {
	WebDriver driver;
	
	@Before
	public void driverDetails() {
		driver = new EdgeDriver();
		
	}
	
	@Given("User is saucedemo page")
	public void user_is_an_saucedemo_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
//	    throw new io.cucumber.java.PendingException();
	}
	@When("User enters {string} and {string} and clicklogin")
	public void user_enters_and_and_clicklogin(String string, String string1) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("user-name")).sendKeys(string);
		driver.findElement(By.id("password")).sendKeys(string1);
		driver.findElement(By.id("login-button")).click();
//	    throw new io.cucumber.java.PendingException();
	}
	@When("Adding a product to the cart")
	public void adding_a_product_to_the_cart() {

		
		WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]"));
		addToCartButton.click();
		driver.findElement(By.className("shopping_cart_link")).click();
		
	}
	
	
	
	@Then("verify the product is added to the cart")
	public void verify_the_product_is_added_to_the_cart() {
	    // Write code here that turns the phrase above into concrete actions
//		WebElement ele = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
		WebElement ele = driver.findElement(By.className("inventory_item_name"));
		String name = ele.getText();
		System.out.println(name);
		Assert.assertEquals(name, "Sauce Labs Backpack");
		System.out.println("verification done");
//	    throw new io.cucumber.java.PendingException();
	}
	@After
	public void close() {
		driver.close();
	}

}
