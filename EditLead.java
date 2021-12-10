package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.SeleniumHelper;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://leaftaps.com/opentaps", driver);
		SeleniumHelper.type(driver, By.id("username"), "DemoSalesManager");
		SeleniumHelper.type(driver, By.id("password"), "crmsfa");
		SeleniumHelper.click(driver, By.className("decorativeSubmit"));

		SeleniumHelper.click(driver, By.linkText("CRM/SFA"));
		SeleniumHelper.click(driver, By.linkText("Leads"));
		SeleniumHelper.click(driver, By.linkText("Find Leads"));
		driver.findElement(By.xpath("//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder']//input[@name='firstName'][contains(@class,'x-form-text x-form-field')]")).sendKeys("Reshika");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(.//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a")).click();
		
		if(driver.getTitle().contains("View Lead"))
		{
			System.out.println("View Lead Page Title is verified");			
		}
		else
		{
			System.out.println("View Lead Page Title is not verified");
		}
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		String newCompanyName = "TCS";
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(newCompanyName);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String updatedCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(updatedCompanyName.contains(newCompanyName))
		{
			System.out.println("COMPANY NAME SUCCESSFULLY UPDATED.");
		}
		else
		{
			System.out.println("COMPANY NAME NOT UPDATED.");
		}
		driver.close();
	}

}
