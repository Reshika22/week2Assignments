package week2.assignments;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(" https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(By.xpath("//button[@title='Allow All Cookies']")).click();
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Reshika");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Prabu");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("+917598005752");
		//driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("7598005751");
		driver.findElement(By.xpath("//input[@name='reg_passwd__'][@id='password_step_input']")).sendKeys("ABCDEF123#");
		
		WebElement elementDay = driver.findElement(By.xpath("//select[@name='birthday_day'][@id='day']"));
		Select selectDay = new Select(elementDay);
		selectDay.selectByVisibleText("6");
		
		WebElement elementMonth = driver.findElement(By.xpath("//select[@name='birthday_month'][@id='month']"));
		Select selectMonth = new Select(elementMonth);
		selectMonth.selectByVisibleText("Aug");
		
		WebElement elementYear = driver.findElement(By.xpath("//select[@name='birthday_year'][@id='year']"));
		Select selectYear = new Select(elementYear);
		selectYear.selectByVisibleText("2000");
		
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();

	}

}
