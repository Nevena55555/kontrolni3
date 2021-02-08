package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	public static final String URL = "https://www.saucedemo.com/";
	private static final String USERNAME_XPATH = "//*[@id=\"user-name\"]";
	private static final String PASSWORD_XPATH = "//*[@id=\"password\"]";
	private static final String BTN_XPATH = "//*[@id=\"login-button\"]";
	
	public static void inputUsername(WebDriver driver, String username) {
		driver.findElement(By.xpath(USERNAME_XPATH)).sendKeys(username);
	}
	public static void inputPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(password);
	}
	
	public static void loginButton(WebDriver driver) {
		driver.findElement(By.xpath(BTN_XPATH)).click();
	}
	
	

}
