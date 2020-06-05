package automation.base;
import java.util.ResourceBundle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class CreateDriverInstance 
{
	public WebDriver genrateDriverInstance() throws InterruptedException
	{
		WebDriver driver;
		ResourceBundle config = ResourceBundle.getBundle("config");
		if(config.getString("browser").equalsIgnoreCase("chrome"))
		{			
				System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-extensions");
                Thread.sleep(5000);
				driver = new ChromeDriver(options);
		}
		else if(config.getString("browser").equalsIgnoreCase("firefox"))
		{
				System.setProperty("WebDriver.gecko.driver", "./Driver/geckodriver.exe");
				driver = new FirefoxDriver();
		}
		else if(config.getString("browser").equalsIgnoreCase("ie"))
		{
				System.setProperty("webdriver.ie.driver", "./Driver/IEdriverServer.exe");
				driver = new InternetExplorerDriver();
		}
		else
		{
			System.setProperty("WebDriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();		
		}
		driver.get(config.getString("applicationURL"));
		driver.manage().window().maximize();
		return driver;
	}

	
	public void closeDriver(WebDriver driver)
	{
		driver.close();
		driver.quit();
	}
}
