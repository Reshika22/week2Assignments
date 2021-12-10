package week2.assignments;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.SeleniumHelper;

public class LeafgroundImage {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		//Assignment 4,problem :4
		ChromeDriver driver = SeleniumHelper.getChromeDriver();
		SeleniumHelper.launchUrlMaximizeSetTimeouts("http://leafground.com/pages/Image.html", driver);
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img")).click();
		driver.navigate().back();
		//approach 1
		WebElement imgElement = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img"));
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(imgElement.getAttribute("src"));
		HttpResponse response = client.execute(request);
		// verifying response code he HttpStatus should be 200 if not,
		// increment as invalid images count
		if (response.getStatusLine().getStatusCode() == 404)
		{
			System.out.println("It is broken image");
		}
		else
		{
			System.out.println("It is not broken image");
		}
		
		//approach 2:
		WebElement brokenImage  = driver.findElement(By.xpath("(//div[contains(@class,'large-6 small-12')]//img)[2]"));
		if(brokenImage.getAttribute("naturalWidth").equals("0")) {
			System.out.println("The image is broken");

		}
		else {
			System.out.println("The image is not broken");
		}
	}

}
