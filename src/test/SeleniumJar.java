package test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

public class SeleniumJar {
	public static String browser;
	static WebDriver driver;

	public static void main(String[] args) {
		SeleniumJar test = new SeleniumJar();
		test.setBrowser("Chrome");
		test.setBrowserConfig();
		test.verifyTitle();
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void setBrowserConfig() {
		String projectlocation = System.getProperty("user.dir");

		if (browser.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", projectlocation + "\\lib\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.contains("Firefox")) {
			System.setProperty("webdriver.firefox.driver", projectlocation + "\\lib\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	@Test
	public void verifyTitle() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String expectedTitle = "OrangeHRM";
		String actualTitle = "";

		actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Assert passed");
	}
}
