package automation.pages;

import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	ResourceBundle element;
	ResourceBundle config;
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		element = ResourceBundle.getBundle("Elements");
		config = ResourceBundle.getBundle("config");
	}
  public void enterUsername(String uNmae)
  {
	 //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  String title= driver.getTitle();
	  System.out.println(title);
	  driver.switchTo().frame(0);
	  String src = driver.findElement(By.xpath("//div[@id='divLogo']/img")).getAttribute("src");
	  System.out.println(src);
	  WebDriverWait some_element = new WebDriverWait(driver,100); 
      some_element.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));		
	  driver.findElement(By.id(element.getString("login_username_id"))).sendKeys(uNmae);
  }
  public void enterPassword(String pass)
  {
	  driver.findElement(By.id(element.getString("login_password_id"))).sendKeys(pass);
  }
  public void login()
  {
	  driver.findElement(By.id(element.getString("login_signin_xpath"))).click();
  }
}
