package week2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import selenium.SeleniumHelper;

public class IRCTC {

	public static void main(String[] args) {
		
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("https://www.irctc.co.in/nget/profile/user-registration", driver);
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//span[text()='Personal Details']")).click();
		WebElement country = driver.findElement(By.xpath("//select[@formcontrolname='resCountry']/option"));
		Select scountry = new Select(country);
		List<WebElement> options = scountry.getOptions();
				
		int count = 0;			
		for (WebElement webElement : options) {
			
			if(webElement.getText().startsWith("E"))
			{
				if(count == 1)
				{
					scountry.selectByVisibleText(webElement.getText());
					break;
				}
				count++;
			}
		}

	}

}
