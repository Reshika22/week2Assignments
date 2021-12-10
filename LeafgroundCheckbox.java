package week2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import selenium.SeleniumHelper;

public class LeafgroundCheckbox {

	public static void main(String[] args) {

		//Assignment 4,problem :5

		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://leafground.com/pages/checkbox.html", driver);
		//driver.findElement(By.xpath("//div[contains(text(),'SQL')]/input")).click();
		driver.findElement(By.xpath(".//*[contains(text(), 'SQL')]/input")).click();
		driver.findElement(By.xpath(".//*[contains(text(), 'C')]/input")).click();
		boolean selected = driver.findElement(By.xpath(".//*[contains(text(), 'Selenium')]/input")).isSelected();
		if(selected)
		{
			System.out.println("Selenium is selected");
		}
		else{
			System.out.println("Selenium is not selected");
		}
		if(driver.findElement(By.xpath(".//*[contains(text(), 'I am Selected')]/input")).isSelected())
		{
			driver.findElement(By.xpath(".//*[contains(text(), 'I am Selected')]/input")).click();
		}
		List<WebElement> list = driver.findElements(By.xpath(".//*[contains(text(), 'Select all below checkboxes ')]//../div/input"));
        
		for(int i = 0;i<list.size();i++)
		{
			list.get(i).click();
		}
		driver.close();
	}
	
	}
