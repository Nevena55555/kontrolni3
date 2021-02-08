package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Login;
import objects.Inventory;

public class Testing {
	
	private static final String SORT_XPATH = "//*[@id=\"inventory_filter_container\"]/select";


	
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/Nevena/Downloads/chromedriver");
		driver = new ChromeDriver();
	}
	
	@Test(priority = 1)
	public void testLoginForm1() {
		
        File f = new File("kredencijali1.xlsx");
		
		try {
			InputStream inp = new FileInputStream(f); 
			XSSFWorkbook wb = new XSSFWorkbook(inp); 
			Sheet sheet = wb.getSheetAt(0); 
			Row row = sheet.getRow(0);
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);
			
			SoftAssert sa = new SoftAssert();
			
		    String username = c1.toString();
			String pass = c2.toString();
			
		    driver.navigate().to(Login.URL);
		    Login.inputUsername(driver, username);
		    Login.inputPassword(driver, pass);
		    Login.loginButton(driver);
		
		    String actual  = driver.getCurrentUrl();
		    String expected = "https://www.saucedemo.com/inventory.html";
				
		     Assert.assertEquals(actual, expected);
		     
	    } catch (IOException e) {
		    System.out.println("Nije pronadjen fajl!");
		    e.printStackTrace();
	    }
	}
	   
	@Test(priority = 2)
	public void testLoginForm2() {
		
        File f = new File("kredencijali2.xlsx");
		
		try {
			InputStream inp = new FileInputStream(f); 
			XSSFWorkbook wb = new XSSFWorkbook(inp); 
			Sheet sheet = wb.getSheetAt(0); 
			Row row = sheet.getRow(0);
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);
			
			SoftAssert sa = new SoftAssert();
			
		    String username = c1.toString();
			String pass = c2.toString();
			
				
		    driver.navigate().to(Login.URL);
		    Login.inputUsername(driver, username);
		    Login.inputPassword(driver, pass);
		    Login.loginButton(driver);
		
		    String actual  = driver.getCurrentUrl();
		    String expected = "https://www.saucedemo.com/inventory.html";
				
		    Assert.assertEquals(actual, expected);
			
		} catch (IOException e) {
			System.out.println("Nije pronadjen fajl!");
			e.printStackTrace();
		}
		}
	
		@Test(priority = 3)
		public void sortByPrice() {
			driver.navigate().to(Inventory.URL);
			
			driver.findElement(By.xpath(SORT_XPATH)).click();
			
			WebElement sortBy = driver.findElement(By.xpath(SORT_XPATH));
		    Select sel = new Select(sortBy);
		    sel.selectByVisibleText("Price (low to high)");
		    
		    driver.findElement(By.xpath(SORT_XPATH)).click();
		    
		    String actual  = driver.getCurrentUrl();
		    String expected = "https://www.saucedemo.com/inventory.html";
				
		    Assert.assertEquals(actual, expected);
		   
		  
		}
}
