package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();		
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("98");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		// prabu's : .//*[text()='Lead ID']//ancestor::table//following::table[1]//tr[1]/td[1]//a
		
		//to avoid stale element expection 
		Thread.sleep(3000);
		
		String firstLead = driver.findElement(By.xpath("(.//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a")).getText();
		System.out.println("First Lead : " + firstLead);
		driver.findElement(By.xpath("(.//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[1]//a")).click();
		
		driver.findElement(By.linkText("Delete")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstLead);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String noRecord = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		if(noRecord.contains("No records"))
		{
			System.out.println(noRecord);
		}
		else
		{
			System.out.println("Record Exists");
		}
		
		driver.close();
	}

}
