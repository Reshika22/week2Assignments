package week2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import selenium.SeleniumHelper;

public class LeafgroundButton {

	public static void main(String[] args) {

		//Assignment 4,problem :2

		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://leafground.com/pages/Button.html", driver);
		driver.findElement(By.id("home")).click();
		driver.navigate().back();
		System.out.println("The location(x,y) : " + driver.findElement(By.id("position")).getLocation());
		System.out.println("The color of the button : " + driver.findElement(By.id("color")).getCssValue("background-color"));
		System.out.println("The size of the button : " + driver.findElement(By.id("size")).getSize());
		driver.close();

	}

}
