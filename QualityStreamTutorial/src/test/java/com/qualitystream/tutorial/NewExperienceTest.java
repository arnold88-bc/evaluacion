package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
public class NewExperienceTest {
	
	private WebDriver driver;
	By registerLinkLocator = By.linkText("Sign in");
	By registerPageLocator = By.id("email_create");
	By userEmailLocator =  By.id("email_create");
	By createuserBtnLocator = By.name("SubmitCreate");
	By registerFormLocator = By.name("email");
	By submitBtnLocator = By.name("submitAccount");
	By userNameLocator = By.id("customer_firstname");
	By userLastnameLocator = By.id("customer_lastname");
	By userPassLocator = By.id("passwd");
	By userAddressLocator = By.id("address1");
	By userCityLocator = By.id("city");
	By userPostcodeLocator = By.id("postcode");
	By userCellLocator = By.id("phone_mobile");
	By userEmailrLocator = By.id("email");
	By userPassrLocator = By.id("passwd");
	By submitloginBtnLocator = By.name("SubmitLogin");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
	}    

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

@Test	
	public void registrousuario() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(registerPageLocator).isDisplayed()) {
			driver.findElement(userEmailLocator).sendKeys("zzzzzzzzzz");
			driver.findElement(createuserBtnLocator).click();
			driver.findElement(userEmailLocator).clear();
			driver.findElement(userEmailLocator).sendKeys("arnoldbc88@gmail.com");
			driver.findElement(createuserBtnLocator).click();
			driver.findElement(userEmailLocator).clear();
			driver.findElement(userEmailLocator).sendKeys("aberrio@yahoo.com"); // En esta linea se debe colocar un email nuevo para poder hacerle el registro
			driver.findElement(createuserBtnLocator).click();
		Thread.sleep(5000);
		if(driver.findElement(registerFormLocator).isDisplayed()) {	
			driver.findElement(userNameLocator).sendKeys("Arnold");
			driver.findElement(userLastnameLocator).sendKeys("Berrio Cabarcas");
			driver.findElement(userPassLocator).sendKeys("12345");
			driver.findElement(userAddressLocator).sendKeys("cll 123");
			driver.findElement(userCityLocator).sendKeys("Miami");
			Select State = new Select(driver.findElement(By.id("id_state")));
			State.selectByVisibleText("-");
			State.selectByIndex(9);
			driver.findElement(userPostcodeLocator).sendKeys("33126");
			driver.findElement(userCellLocator).sendKeys("3145726736");
			driver.findElement(submitBtnLocator).click();
		}	
		
	} else {  
		System.out.print("Pagina de registro no encontrada");
	}

 }
@Test	
	public void loginusuario() throws InterruptedException {
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		driver.findElement(userEmailrLocator).sendKeys("arnoldbc88@gmail.com");
		driver.findElement(userPassrLocator).sendKeys("abc123");
		driver.findElement(submitloginBtnLocator).click();
	
	}
}	
