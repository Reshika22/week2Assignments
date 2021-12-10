package week2.assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import selenium.SeleniumHelper;


public class LeafgroundDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		//Assignment 4,problem :5
		
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://leafground.com/pages/Dropdown.html", driver);
		WebElement index = driver.findElement(By.id("dropdown1"));
		Select selectIndex = new Select(index);
		selectIndex.selectByIndex(1);

		WebElement text = driver.findElement(By.name("dropdown2"));
		Select selectText = new Select(text);
		selectText.selectByVisibleText("Selenium");

//		WebElement value = driver.findElement(By.id("dropdown3"));
//		Select selectValue = new Select(value);
//		selectValue.selectByValue("1");
		
		WebElement value1 = driver.findElement(By.id("dropdown3"));
		Select selectValue1 = new Select(value1);
		List<WebElement> allOptions = selectValue1.getOptions();
		int num = allOptions.size();
		selectValue1.selectByIndex(num-1);

		WebElement listCount = driver.findElement(By.className("dropdown"));
		Select selectCount = new Select(listCount);		
		List<WebElement> listelements = selectCount.getOptions();
		System.out.println("No.of.Elements in the dropdown : " + listelements.size());

		driver.findElement(By.xpath("//section[@class='innerblock']/div[5]/select")).sendKeys("Selenium");
		
		WebElement program = driver.findElement(By.xpath("//section[@class='innerblock']/div[6]/select"));
		Select selectProgram = new Select(program);
		selectProgram.selectByVisibleText("Loadrunner");
		driver.close();

	}

}
