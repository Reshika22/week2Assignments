package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.SeleniumHelper;

public class ACMETest {

	public static void main(String[] args) {
		
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("https://acme-test.uipath.com/login", driver);
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		System.out.println("Ttile of the Page : " + driver.getTitle());
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
	}

}
