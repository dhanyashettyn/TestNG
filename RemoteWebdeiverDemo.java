package remoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebdeiverDemo 
{
	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		String baseUrl = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
		WebDriver driver;
		
		URL url = new URL("http://127.0.0.1:4444/wd/hub");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setBrowserName("chrome");
		driver = new RemoteWebDriver(url, capabilities);
		
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(1000);
		driver.quit();

	}
}