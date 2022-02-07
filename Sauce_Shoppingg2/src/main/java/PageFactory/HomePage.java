package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CLASS_NAME, using = "dropdown-toggle")
	public WebElement InputForm;
	//Login Page
	@FindBy(name="user-name") public WebElement uname;
	@FindBy(name="password") public WebElement pswrd;
	@FindBy(name="login-button") public WebElement btn_Login;
	
	//HomePage
	
	@FindBy(name="add-to-cart-sauce-labs-backpack") public WebElement btn_addToCart;
	@FindBy(id="shopping_cart_container") public WebElement btn_CartIcon;
	@FindBy(id="remove-sauce-labs-backpack") public WebElement btn_RemoveItem;
	
	//YourCart
	@FindBy(linkText="Sauce Labs Backpack") public WebElement lnk_Item1;
	@FindBy(name="remove-sauce-labs-backpack") public WebElement remove_Item1;
	@FindBy(className="removed_cart_item") public WebElement txt_remove_Item1;
	@FindBy(name="checkout") public WebElement btn_Checkout;
	
	//Checkout Page
	@FindBy(name="firstName") public WebElement txt_firstName;
	@FindBy(name="lastName") public WebElement txt_lastName;
	@FindBy(name="postalCode") public WebElement txt_postalCode;
	@FindBy(name="continue") public WebElement btn_continue;
	@FindBy(xpath="//*[@id='checkout_summary_container']")public WebElement checkOut_secPage;
	@FindBy(name="finish") public WebElement btn_Finish;
	
	
	
	
	

	

}
