package week2.assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


import selenium.SeleniumHelper;

public class LeafgroundTextbox{

	public static void main(String[] args) throws InterruptedException {
		
		//Assignment 4, problem :1
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://leafground.com/pages/Edit.html", driver);
		driver.findElement(By.id("email")).sendKeys("reshuakshu@gmail.com");
		driver.findElement(By.xpath("//input[contains(@value,'Append')]")).sendKeys("Reshika",Keys.TAB);
		System.out.println("Default text entered : "+ driver.findElement(By.xpath("//label[text()='Get default text entered']//following-sibling::input")).getAttribute("value"));
		driver.findElement(By.xpath("//label[text()='Clear the text']//following-sibling::input")).clear();
		System.out.println("Field is Enabled ? : "+ driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']//following-sibling::input")).isEnabled());
		driver.close();

	}

}
