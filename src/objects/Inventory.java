package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inventory {
	
	public static final String URL = "https://www.saucedemo.com/inventory.html";
	private static final String SORT_XPATH = "//*[@id=\"inventory_filter_container\"]/select";
    
	public static void sort(WebDriver driver) {
		WebElement we = driver.findElement(By.xpath(SORT_XPATH));
		we.click();
	}
	

}
