package com.scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestQasir {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\maulana.yusuf\\coba\\TestQasir\\library\\chromedriver_win32_93\\chromedriver.exe");
		//open browser
		WebDriver driver = new ChromeDriver();
		
		//first way to navigate
		WebDriver.Navigation navigate = driver.navigate();
		navigate.to("https://web.qasir.id/sign-in");
		driver.manage().window().maximize();

		//login
		WebElement phone_field = driver.findElement(By.id("sign-in-phonenumber"));
		phone_field.sendKeys("87887316126");
		WebElement pin_field = driver.findElement(By.id("password"));
		pin_field.sendKeys("123456");
		driver.findElement(By.id("submit-btn-signin")).click();
		
		//wait outlets element clickable
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='menu accordion-menu']/li[10]")));
		
		//choose outlets
		driver.findElement(By.xpath("//div[@class='sidebar']//li[10]/a")).click();
		
		//wait element user profile clickable
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='dropdown']")));
	
		//choose user icon 
		driver.findElement(By.xpath("//li[@class='dropdown']")).click();
		
		//choose profile dropdown
		driver.findElement(By.xpath("//a[normalize-space()='User Profile']")).click();
		
		//wait firstname field visible
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='first_name']")));
		
		//fill fist name
		WebElement firstName_field = driver.findElement(By.xpath("//input[@name='first_name']"));
		firstName_field.clear();
		firstName_field.sendKeys("Maulana");
		
		//fill last name
		WebElement lastName_field = driver.findElement(By.xpath("//input[@name='last_name']"));
		lastName_field.clear();
		lastName_field.sendKeys("Yusuf");
		
		//click save button
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		//refresh
		driver.navigate().refresh();

	
	}
}
