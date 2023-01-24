package testprojectSDK;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;

public class testngdemo {
	ChromeDriver driver;
	
	@BeforeTest
	public void beforetest() throws Exception {
		System.out.println("Before test");
		 driver = new DriverBuilder<ChromeDriver>(new ChromeOptions())
				  .withRemoteAddress(new URL("http://localhost:8585"))
				  .withToken("mJOnqaCv7g7UPNroSzGIfN33VEyPzCjm4Rms_zhWE101")
				  .build(ChromeDriver.class);
	}
	
	@Test
	public void test1() {		
		System.out.println("First Statement");
		 driver.navigate().to("https://example.testproject.io/web/");

	        driver.findElement(By.cssSelector("#name")).sendKeys("John Smith");
	        driver.findElement(By.cssSelector("#password")).sendKeys("12345");
	        driver.findElement(By.cssSelector("#login")).click();

	        boolean passed = driver.findElement(By.cssSelector("#logout")).isDisplayed();
	        if (passed) {
	            System.out.println("Test Passed");
	        } else {
	            System.out.println("Test Failed");
	        }
	}
	
	@Test
	public void test2() {		
		System.out.println("second Statement");
	}

	@AfterTest
	public void aftertest() {
		driver.quit();
	}
}
