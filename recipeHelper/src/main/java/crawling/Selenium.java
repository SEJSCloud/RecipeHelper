package crawling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {
	private static Selenium instance = new Selenium();
	private static WebDriver driver;
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "C://00.SEJS/00.SW/chromedriver.exe";

	private Selenium() {
		
	}

	public static Selenium getInstance() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		driver = new ChromeDriver();
		return instance;
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public void close() {
		driver.close();
	}
	
	public void quit() {
		driver.quit();
	}
	
	public void get(String url) {
		driver.get(url);
	}
	
	public WebElement find(String query) {
		return driver.findElement(By.cssSelector(query));
	}
	
	public List<WebElement> findAll(String query) {
		return driver.findElements(By.cssSelector(query));
	}
	
	public WebElement findByTagName(String query) {
		return driver.findElement(By.tagName(query));
	}
	
	public List<WebElement> findAllByTagName(String query) {
		return driver.findElements(By.tagName(query));
	}
	
	public WebElement findByClass(String query){
		return driver.findElement(By.className(query));
	}
	
	public List<WebElement> findAllByClass(String query) {
		return driver.findElements(By.className(query));
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	

	
	public void click(String query) {
		driver.findElement(By.cssSelector(query)).click();
	}
	
	public void input(String query, String text) {
		driver.findElement(By.cssSelector(query)).sendKeys(text);
	}
	
	public void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}