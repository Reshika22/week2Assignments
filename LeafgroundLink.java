package week2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.SeleniumHelper;

public class LeafgroundLink {

	public static void main(String[] args) throws InterruptedException {

		//Assignment 4,problem :3
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://leafground.com/pages/Link.html", driver);
		driver.findElement(By.xpath("(//section[@class='innerblock']//a)[1]")).click();
		driver.navigate().back();
		String linkedPath = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println(linkedPath);
		String verifyPath =driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href");
		if(verifyPath.contains("error")) {
			System.out.println("It is broken");
		}
		else
		{
			System.out.println("It is not broken");
			driver.findElement(By.linkText("Verify am I broken?")).click();

		}
		driver.findElement(By.xpath("//label/preceding-sibling::a")).click();
		driver.navigate().back();
		Thread.sleep(3000);
		List<WebElement> noOfLinks = driver.findElements(By.tagName("a"));
		System.out.println("No.of.Links in the page : " + noOfLinks.size());
		noOfLinks.clear();
		driver.close();


	}

}
