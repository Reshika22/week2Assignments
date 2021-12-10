package week2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click(); 
		driver.findElement(By.linkText("CRM/SFA")).click(); 
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("Reshika");
		driver.findElement(By.id("lastNameField")).sendKeys("Prabu");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Reshika");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Prabu");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Software");
		driver.findElement(By.id("createContactForm_description")).sendKeys("I am a beginner in Selenium testing");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("babu@testleaf.com");
		
		WebElement elementState = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select selectState = new Select(elementState);
		selectState.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("I am a good learner and good at programming");
		driver.findElement(By.xpath("//input[@name='submitButton'][@value='Update']")).click();

		driver.close();
		String title = driver.getTitle();
		System.out.println("Title of the Page : " + title );
	}

}
