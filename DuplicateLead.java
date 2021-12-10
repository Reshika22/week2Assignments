package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.SeleniumHelper;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://leaftaps.com/opentaps", driver);

		SeleniumHelper.type(driver, By.id("username"), "DemoSalesManager");
		SeleniumHelper.type(driver, By.id("password"), "crmsfa");
		SeleniumHelper.click(driver, By.className("decorativeSubmit"));

		SeleniumHelper.click(driver, By.linkText("CRM/SFA"));
		SeleniumHelper.click(driver, By.linkText("Leads"));
		SeleniumHelper.click(driver, By.linkText("Find Leads"));


		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("babu@testleaf.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(3000);

		String firstLead = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]//a")).getText();
		System.out.println("First Lead : " + firstLead);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]//a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		if(driver.getTitle().contains("Duplicate Lead"))
		{
			System.out.println("Duplicate Lead Page is verified");			
		}
		else
		{
			System.out.println("Duplicate Lead Page is not verified");
		}

		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		String duplicateLead = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(firstLead.equals(duplicateLead))
		{
			System.out.println("Name Captured Matched with Duplicate Name");

		}
		else
		{
			System.out.println("Name Captured Not Matched with Duplicate Name");

		}
		driver.close();
	}

}
